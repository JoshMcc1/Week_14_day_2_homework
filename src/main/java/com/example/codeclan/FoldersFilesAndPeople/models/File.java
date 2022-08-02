package com.example.codeclan.FoldersFilesAndPeople.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "files")
public class File
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "name")
  private String name;
  @Column(name = "extension")
  @Enumerated(value = EnumType.STRING)
  private ExtensionType extension;
  @Column(name = "size")
  private int size;

  // one to many
  @ManyToOne
  @JoinColumn(name = "folder_id")
  @JsonIgnoreProperties({"files"})
  private Folder folder;

  public File()
  {
  }

  public File(String name, ExtensionType extension, int size, Folder folder)
  {
    this.name = name;
    this.extension = extension;
    this.size = size;
    this.folder = folder;
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

  public ExtensionType getExtension()
  {
    return extension;
  }

  public void setExtension(ExtensionType extension)
  {
    this.extension = extension;
  }

  public int getSize()
  {
    return size;
  }

  public void setSize(int size)
  {
    this.size = size;
  }

  public Folder getFolder()
  {
    return folder;
  }

  public void setFolder(Folder folder)
  {
    this.folder = folder;
  }
}
