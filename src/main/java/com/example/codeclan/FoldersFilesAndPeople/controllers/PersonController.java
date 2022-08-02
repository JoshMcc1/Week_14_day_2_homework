package com.example.codeclan.FoldersFilesAndPeople.controllers;

import com.example.codeclan.FoldersFilesAndPeople.models.Person;
import com.example.codeclan.FoldersFilesAndPeople.repos.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController
{
  @Autowired
  PersonRepository personRepository;

  @GetMapping(value = "/people")
  public ResponseEntity<List<Person>> getPeople() {
    return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
  }

  @GetMapping(value = "/people/{id}")
  public ResponseEntity getPersonById(@PathVariable Long id) {
    return new ResponseEntity<>(personRepository.findById(id), HttpStatus.OK);
  }

  @PostMapping(value = "/people")
  public ResponseEntity<Person> createPerson(@RequestBody Person person) {
    personRepository.save(person);
    return new ResponseEntity<>(person, HttpStatus.CREATED);
  }

}
