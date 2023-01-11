package com.attornatus.domain.service;

import com.attornatus.domain.exception.AddressNotFoundException;
import com.attornatus.domain.model.Address;
import com.attornatus.domain.model.Person;
import com.attornatus.domain.repository.AddressRepository;
import com.attornatus.domain.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class RegisterAddressTest {

    public static final String NAME = "Leonardo";
    public static final LocalDate DATE_BIRTH = LocalDate.now();
    public static final String NAO_EXISTE_UM_CADASTRO_DE_PESSOA_E_ENDERECO = "Não existe um cadastro de endereço com código %d para pessoa de código %d";
    public static final Integer INDEX = 0;
    public static final Integer PERSON_ID = 1;

    public static final int ADDRESS_ID = 1;
    public static final String ZIP_CODE = "88888-888";
    public static final String CITY = "Fortaleza";
    public static final boolean ADDRESS_MAIN = false;
    public static final int NUMBER = 4545;
    public static final String PUBLIC_PLACE = "Rua major";
    @InjectMocks
    private RegisterAddress registerAddress;
    @Mock
    private AddressRepository addressRepository;
    @Mock
    private PersonRepository personRepository;

    private Optional<Address> addressOptional;
    private Optional<Person> personOptional;
    private Person person;
    private Address address;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startAddress();
    }

    @Test
    void whenCreateAddressThenReturnSuccess() {
        when(addressRepository.save(any())).thenReturn(address);

        Address response = registerAddress.toSave(address, PERSON_ID ,person);

        assertEquals(Address.class, response.getClass());
        assertEquals(ADDRESS_ID, response.getId());
        assertEquals(PUBLIC_PLACE, response.getPublicPlace());
        assertEquals(ZIP_CODE, response.getZipCode());
        assertEquals(NUMBER, response.getNumber());
        assertEquals(CITY, response.getCity());
        assertEquals(ADDRESS_MAIN, response.getAddressMain());
        assertEquals(person, response.getPerson());
    }

    @Test
    void whenFindByIdThenReturnAnAddressInstance() {
      when(addressRepository.findById(anyInt())).thenReturn(addressOptional);
      when(personRepository.findById(anyInt())).thenReturn(personOptional);

      Address response = registerAddress.seekOrFailAddress(ADDRESS_ID, PERSON_ID);

      assertEquals(Address.class, response.getClass());
      assertEquals(ADDRESS_ID, response.getId());
      assertEquals(PUBLIC_PLACE, response.getPublicPlace());
      assertEquals(ZIP_CODE, response.getZipCode());
      assertEquals(NUMBER, response.getNumber());
      assertEquals(CITY, response.getCity());
      assertEquals(ADDRESS_MAIN, response.getAddressMain());
      assertEquals(person, response.getPerson());
    }
    @Test
    void whenFindByIdThenReturnAnObjectNotFoundException() {
        when(addressRepository.findById(anyInt())).thenThrow(new AddressNotFoundException((NAO_EXISTE_UM_CADASTRO_DE_PESSOA_E_ENDERECO)));
        try {
            registerAddress.seekOrFailAddress(ADDRESS_ID,PERSON_ID);
        } catch (Exception ex) {
            assertEquals(AddressNotFoundException.class, ex.getClass());
            assertEquals(NAO_EXISTE_UM_CADASTRO_DE_PESSOA_E_ENDERECO, ex.getMessage());
        }
    }

    @Test
    void testingThemainAddress(){
        when(addressRepository.save(any())).thenReturn(address);
        when(personRepository.save(any())).thenReturn(person);
        List<Address> addresses = addressRepository.findByPerson(person);
        assertNotNull(addresses);
    }
    private void startAddress() {
        person = new Person(PERSON_ID, NAME, DATE_BIRTH);
        address = new Address(ADDRESS_ID, PUBLIC_PLACE, ZIP_CODE, NUMBER, CITY, ADDRESS_MAIN, person);
        personOptional = Optional.of(new Person(PERSON_ID, NAME, DATE_BIRTH));
        addressOptional = Optional.of(new Address(ADDRESS_ID, PUBLIC_PLACE, ZIP_CODE, NUMBER, CITY, ADDRESS_MAIN, person));
    }

}