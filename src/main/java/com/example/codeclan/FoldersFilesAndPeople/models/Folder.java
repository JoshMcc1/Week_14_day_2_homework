package com.example.codeclan.FoldersFilesAndPeople.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "folders")
public class Folder
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "title")
  private String title;
  @OneToMany(mappedBy = "folder", fetch = FetchType.LAZY)
  @JsonIgnoreProperties({"folder"})
  private List<File> files;
  @ManyToOne
  @JoinColumn(name = "person_id")
  @JsonIgnoreProperties({"folders"})
  private Person person;

  public Folder()
  {
  }

  public Folder(String title, Person person)
  {
    this.title = title;
    this.person = person;
    this.files = new ArrayList<>();
  }

  public long getId()
  {
    return id;
  }

  public void setId(long id)
  {
    this.id = id;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public List<File> getFiles()
  {
    return files;
  }

  public void setFiles(List<File> files)
  {
    this.files = files;
  }

  public Person getPerson()
  {
    return person;
  }

  public void setPerson(Person person)
  {
    this.person = person;
  }

  public void addFile(File file) {
    this.files.add(file);
  }
}
