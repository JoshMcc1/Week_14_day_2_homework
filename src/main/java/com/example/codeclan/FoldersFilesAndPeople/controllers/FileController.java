package com.example.codeclan.FoldersFilesAndPeople.controllers;

import com.example.codeclan.FoldersFilesAndPeople.models.File;
import com.example.codeclan.FoldersFilesAndPeople.models.Person;
import com.example.codeclan.FoldersFilesAndPeople.repos.FileRepository;
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
public class FileController
{
  @Autowired
  FileRepository fileRepository;

  @GetMapping(value = "/files")
  public ResponseEntity<List<File>> getFiles() {
    return new ResponseEntity<>(fileRepository.findAll(), HttpStatus.OK);
  }

  @GetMapping(value = "/files/{id}")
  public ResponseEntity getFileById(@PathVariable Long id) {
    return new ResponseEntity<>(fileRepository.findById(id), HttpStatus.OK);
  }

  @PostMapping(value = "/files")
  public ResponseEntity<File> createFile(@RequestBody File file) {
    fileRepository.save(file);
    return new ResponseEntity<>(file, HttpStatus.CREATED);
  }
}
