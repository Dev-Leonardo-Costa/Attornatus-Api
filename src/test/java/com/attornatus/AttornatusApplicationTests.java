package com.attornatus;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class AttornatusApplicationTests {

    @Test
    void main(){
        AttornatusApplication.main(new String[] {} );
    }
}