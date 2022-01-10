package com.example.hobbitron.hobbit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HobbitController {

    @Autowired
    private HobbitRepository hobbitRepository;

    public HobbitController(HobbitRepository hobbitRepository) {
        this.hobbitRepository = hobbitRepository;
    }

    @GetMapping("/hobbits")
    List<Hobbit> findAll() {
        return hobbitRepository.findAll();
    }
}
