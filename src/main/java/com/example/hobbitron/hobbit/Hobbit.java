package com.example.hobbitron.hobbit;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "hobbits")
@NamedQuery(name = "Hobbit.findUsingNameQuery", query = "select h from Hobbit h where h.firstName = :firstName and h.lastName = :lastName" )
public class Hobbit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

}
