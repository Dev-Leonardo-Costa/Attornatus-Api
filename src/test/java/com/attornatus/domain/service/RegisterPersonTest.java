package com.attornatus.domain.service;

import com.attornatus.domain.exception.PersonNotFoundException;
import com.attornatus.domain.model.Person;
import com.attornatus.domain.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class RegisterPersonTest {

    public static final String NAME = "Leonardo";
    public static final LocalDate DATE_BIRTH = LocalDate.now();
    public static final String NAO_EXISTE_UM_CADASTRO_DE_PESSOA = "Não existe um cadastro de pessoa com código %d";
    public static final Integer INDEX = 0;
    public static final Integer ID = 1;

    @InjectMocks
    private RegisterPerson registerPerson;
    @Mock
    private PersonRepository repository;
    private Person person;

    private Optional<Person> person2;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startPerson();
    }

    @Test
    void whenFindByIdThenReturnAnPersonInstance() {
        when(repository.findById(anyInt())).thenReturn(person2);
        Person response = registerPerson.seekOrFailPerson(ID);
        assertEquals(Person.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(DATE_BIRTH, response.getDateBirth());
    }

    @Test
    void whenFindAllThenReturnAnListOfPersons() {
        when(repository.findAll()).thenReturn(List.of(person));
        List<Person> response = registerPerson.fetchAllPerson();
        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(Person.class, response.get(INDEX).getClass());
        assertEquals(ID, response.get(INDEX).getId());
        assertEquals(NAME, response.get(INDEX).getName());
        assertEquals(DATE_BIRTH, response.get(INDEX).getDateBirth());
    }

    @Test
    void whenFindByIdThenReturnAnObjectNotFoundException() {
        when(repository.findById(anyInt())).thenThrow(new PersonNotFoundException((NAO_EXISTE_UM_CADASTRO_DE_PESSOA)));
        try {
            registerPerson.seekOrFailPerson(ID);
        } catch (Exception ex) {
            assertEquals(PersonNotFoundException.class, ex.getClass());
            assertEquals(NAO_EXISTE_UM_CADASTRO_DE_PESSOA, ex.getMessage());
        }
    }

    @Test
    void whenCreateThenReturnSuccess() {
        when(repository.save(any())).thenReturn(person);
        Person response = registerPerson.toSave(person);
        assertEquals(Person.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(DATE_BIRTH, response.getDateBirth());
    }

    @Test
    void whenCreateThenReturnAnDataIntegratyValiolationException() {
        when(repository.save(any())).thenReturn(person);
        try{
            person.setId(2);
            registerPerson.toSave(person);
        }catch (Exception ex){
            assertEquals(DataIntegrityViolationException.class, ex.getClass());
        }
    }

    private void startPerson() {
        person = new Person(ID, NAME, DATE_BIRTH);
        person2 = Optional.of(new Person(ID, NAME, DATE_BIRTH));
    }
}