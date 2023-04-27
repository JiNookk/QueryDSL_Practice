package com.example.demo.controllers;

import com.example.demo.dtos.PeopleDto;
import com.example.demo.dtos.PersonDto;
import com.example.demo.models.Person;
import com.example.demo.models.QPerson;
import com.example.demo.repositories.PersonRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
@Transactional
public class PeopleController {
    private final PersonRepository jinseongRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public PeopleController(PersonRepository jinseongRepository) {
        this.jinseongRepository = jinseongRepository;
    }

    @GetMapping("jinseongs")
    public PeopleDto list() {
        //        List<Person> people = jinseongRepository.findAll();

        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        BooleanBuilder builder = new BooleanBuilder();
        builder.or(QPerson.person.id.eq(1L));
        builder.or(QPerson.person.id.eq(5L));

        List<Person> people = queryFactory.selectFrom(QPerson.person)
                .where(builder)
                .fetch();

        return new PeopleDto(people.stream().map(Person::toDto).toList());
    }


    @PostMapping("jinseongs")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDto create() {
        Person person = Person.of();

        Person saved = jinseongRepository.save(person);

        return saved.toDto();
    }
}
