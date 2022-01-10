package com.example.hobbitron.hobbit;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HobbitRepository extends JpaRepository<Hobbit, Long>, CustomHobbitRepository {

    Hobbit findHobbitByFirstNameAndLastName(String firstName, String lastName);

    @Query("select h from Hobbit h where h.firstName = :firstName and h.lastName = :lastName")
    List<Hobbit> findHobbitByQuery(String firstName, String lastName);

    @Query(
            nativeQuery = true,
            value = "select * from hobbits where hobbits.first_name = :firstName and hobbits.last_name = :lastName")
    Hobbit findHobbitByNativeQuery(String firstName, String lastName);

    List<Hobbit> findUsingNameQuery(String firstName, String lastName);
}
