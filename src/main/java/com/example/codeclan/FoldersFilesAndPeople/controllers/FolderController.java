package com.example.codeclan.FoldersFilesAndPeople.controllers;

import com.example.codeclan.FoldersFilesAndPeople.models.Folder;
import com.example.codeclan.FoldersFilesAndPeople.repos.FolderRepository;
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
public class FolderController
{
  @Autowired
  FolderRepository folderRepository;

  @GetMapping(value = "/folders")
  public ResponseEntity<List<Folder>> getFolders() {
    return new ResponseEntity<>(folderRepository.findAll(), HttpStatus.OK);
  }

  @GetMapping(value = "/folders/{id}")
  public ResponseEntity getFolderById(@PathVariable Long id) {
    return new ResponseEntity<>(folderRepository.findById(id), HttpStatus.OK);
  }

  @PostMapping(value = "/folders")
  public ResponseEntity<Folder> createFolder(@RequestBody Folder folder) {
    folderRepository.save(folder);
    return new ResponseEntity<>(folder, HttpStatus.CREATED);
  }
}
