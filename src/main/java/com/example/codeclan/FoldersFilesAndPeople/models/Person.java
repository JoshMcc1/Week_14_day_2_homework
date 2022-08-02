package com.example.codeclan.FoldersFilesAndPeople.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "people")
public class Person
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "name")
  private String name;
  @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
  @JsonIgnoreProperties({"person"})
  private List<Folder> folders;

  public Person()
  {
  }

  public Person(String name)
  {
    this.name = name;
    this.folders = new ArrayList<>();
  }

  public long getId()
  {
    return id;
  }

  public void setId(long id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public List<Folder> getFolders()
  {
    return folders;
  }

  public void setFolders(List<Folder> folders)
  {
    this.folders = folders;
  }

  public void addFolder(Folder folder) {
    this.folders.add(folder);
  }
}
