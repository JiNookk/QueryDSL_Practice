package com.example.demo.models;

import com.example.demo.dtos.PersonDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {
    @GeneratedValue
    @Id
    private Long id;

    private String name;
    private Integer height;
    private Integer weight;

    public Person() {
    }

    public Person(String name, Integer height, Integer weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public static Person of() {
        return new Person("Person", 180, 80);
    }

    public PersonDto toDto() {
        return new PersonDto(this.id, this.name, this.height, this.weight);
    }
}
