package com.example.demo.dtos;

public class PersonDto {
    private Long id;
    private String name;
    private Integer height;
    private Integer weight;

    public PersonDto() {
    }

    public PersonDto(Long id, String name, Integer height, Integer weight) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWeight() {
        return weight;
    }
}
