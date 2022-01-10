package com.example.hobbitron.hobbit;

import java.util.List;

public interface CustomHobbitRepository {
    List<Hobbit> findUsingCustomRepo(String firstName, String lastName);
}
