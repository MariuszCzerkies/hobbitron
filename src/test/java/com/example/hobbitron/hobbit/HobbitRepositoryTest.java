package com.example.hobbitron.hobbit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class HobbitRepositoryTest {

    @Autowired
    private HobbitRepository hobbitRepository;

//    public HobbitRepositoryTest(HobbitRepository hobbitRepository) {
//        this.hobbitRepository = hobbitRepository;
//    }

    @Test
    void shouldFindFrodo_usingInheritedRepoMethod() {

       //given
        String firstName = "Frodo";
        String firstLast = "Baggins";
       //when

        Hobbit foundHobbitByFirstNameAndLastName = hobbitRepository.findHobbitByFirstNameAndLastName(firstName, firstLast);

       //then
        assertEquals(firstName, foundHobbitByFirstNameAndLastName.getFirstName());
        assertEquals(firstLast, foundHobbitByFirstNameAndLastName.getLastName());

    }

    @Test
    void shouldFindFrodo_usingQuery() {
        //given
        String expectedFirstName = "Frodo";
        String expectedLastName = "Baggins";

        //when
        List<Hobbit> foundHobbitByFirstNameAndLastNameQuery = hobbitRepository.findHobbitByQuery(expectedFirstName, expectedLastName);

        //then
        assertEquals(expectedFirstName, foundHobbitByFirstNameAndLastNameQuery.get(0).getFirstName());
        assertEquals(expectedLastName, foundHobbitByFirstNameAndLastNameQuery.get(0).getLastName());
    }

    @Test
    void shouldFindFrodo_usingNativeQuery() {
        //given
        String expectedFirstName = "Frodo";
        String expectedLastName = "Baggins";

        //when
       // List<Hobbit> foundHobbitByFirstNameAndLastNameQuery = hobbitRepository.findHobbitByNativeQuery(expectedFirstName, expectedLastName);
        Hobbit foundHobbitByFirstNameAndLastNameQuery = hobbitRepository.findHobbitByNativeQuery(expectedFirstName, expectedLastName);

        //then
        assertEquals(expectedFirstName, foundHobbitByFirstNameAndLastNameQuery.getFirstName());
        assertEquals(expectedLastName, foundHobbitByFirstNameAndLastNameQuery.getLastName());
    }

    @Test
    void shouldFindFrodo_usingNamedQuery() {

        //given
        String firstName = "Frodo";
        String lastName = "Baggins";

        //when
        List<Hobbit> hobbitFound = hobbitRepository.findUsingNameQuery(firstName, lastName);

        //then
        assertEquals(firstName, hobbitFound.get(0).getFirstName());
        assertEquals(lastName, hobbitFound.get(0).getLastName());

    }

    @Test
    void shouldFindFrodo_usingCustomRepo() {
        //given
        String expectedFirstName = "Frodo";
        String expectedLastName = "Baggins";

        //when
        List<Hobbit> hobbitFromDB = hobbitRepository.findUsingCustomRepo(expectedFirstName, expectedLastName);

        //then
        assertEquals(expectedFirstName, hobbitFromDB.get(0).getFirstName());
        assertEquals(expectedLastName, hobbitFromDB.get(0).getLastName());
    }
}
