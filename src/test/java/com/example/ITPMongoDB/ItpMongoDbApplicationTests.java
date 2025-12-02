package com.example.ITPMongoDB;

import com.example.ITPMongoDB.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ItpMongoDbApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void filterByName_Query(){
        System.out.println(userRepository.filterByName("Ervin Howell"));
    }

    @Test
    void filter_Query(){
        System.out.println(userRepository.filter("PP",35));
    }

    @Test
    void filterByNameStartingWith_Query(){
        System.out.println(userRepository.filterByNameStartingWith("an"));
    }

	@Test
	void contextLoads() {
	}

}
