package com.example.demo.dtos;

import java.util.List;

public class PeopleDto {
    private List<PersonDto> people;

    public PeopleDto() {
    }

    public PeopleDto(List<PersonDto> personDtos) {
        this.people = personDtos;
    }

    public List<PersonDto> getPeople() {
        return people;
    }
}
