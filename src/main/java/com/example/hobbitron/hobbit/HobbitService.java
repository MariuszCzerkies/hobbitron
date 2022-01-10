package com.example.hobbitron.hobbit;

import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class HobbitService {

    private HobbitRepository hobbitRepository;

    public HobbitService(HobbitRepository hobbitRepository) {
        this.hobbitRepository = hobbitRepository;
    }

    @GetMapping("/hobbits")
    List<Hobbit> findAll() {
        return hobbitRepository.findAll();
    }
}
