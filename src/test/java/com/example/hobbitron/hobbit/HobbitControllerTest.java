package com.example.hobbitron.hobbit;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//Spring - użyj cały kontekst Spring'a do testów
@SpringBootTest
//Podpowiedz Spring'owi, skąd wziąć / jak utworzyć MockMvc
@AutoConfigureMockMvc//do MockMvc
//@DirtiesContext
class HobbitControllerTest {

    @Autowired
    //API do testowania endpointów (Web MVC)
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    //JUnit - metoda testowa
    @Test
    @DisplayName("GET /hobbit -> HTTP 200, lista 2 hobbitów z bazy")
    void findAll() throws Exception {
        //nie trolujemy koleżanke/kolegów z zespołu
       // fail();//dobrze jest to dodac jesli jeszcze nie sprecyzowalismy testu, nigdy nie zostawiamy testow pustych!!!!

        //given: endpoint /hobbits & 3 hobbits in DB

        //when: GET /hobbits
       final var resoultActions = mockMvc
                //wywolaj endpoint
                .perform(MockMvcRequestBuilders.get("/hobbits"))
                //dodaj logowanie
                .andDo(print())
               //then: HTTP 200
                //czego oczekujemy (HTTP 200), możemy testować odpowiedz z uzuciem jsonPath
                .andExpect(status().isOk());

       //mapowanie
       final var hobbitsFormDBInJSON = resoultActions.andReturn().getResponse().getContentAsString();
       List<Hobbit> hobbitsFromDBAsJava = objectMapper.readValue(hobbitsFormDBInJSON, new TypeReference<>() {});


        //then: 3 hobbits
        assertEquals(3, hobbitsFromDBAsJava.size());
        // then: 3 hobbits, Frodo, Bilbo, penelope
        assertAll(
                () -> assertEquals(3, hobbitsFromDBAsJava.size()),
                () -> assertEquals("Frodo", hobbitsFromDBAsJava.get(0).getFirstName()),
                () -> assertEquals("Bilbo", hobbitsFromDBAsJava.get(1).getFirstName()),
                () -> assertEquals("Penelope", hobbitsFromDBAsJava.get(2).getFirstName())
        );
    }
}