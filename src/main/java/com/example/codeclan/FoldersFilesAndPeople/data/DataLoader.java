package com.example.codeclan.FoldersFilesAndPeople.data;

import com.example.codeclan.FoldersFilesAndPeople.models.ExtensionType;
import com.example.codeclan.FoldersFilesAndPeople.models.File;
import com.example.codeclan.FoldersFilesAndPeople.models.Folder;
import com.example.codeclan.FoldersFilesAndPeople.models.Person;
import com.example.codeclan.FoldersFilesAndPeople.repos.FileRepository;
import com.example.codeclan.FoldersFilesAndPeople.repos.FolderRepository;
import com.example.codeclan.FoldersFilesAndPeople.repos.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test") //Run every time EXCEPT Tests
@Component
public class DataLoader implements ApplicationRunner
{
  @Autowired
  FileRepository fileRepository;

  @Autowired
  FolderRepository folderRepository;

  @Autowired
  PersonRepository personRepository;

  @Override
  public void run(ApplicationArguments args) throws Exception
  {
    Person jim = new Person("Jim");
    personRepository.save(jim);

    Person hope = new Person("Hope");
    personRepository.save(hope);

    Person ken = new Person("Ken");
    personRepository.save(ken);

    Folder jimFolder = new Folder("jim_folder", jim);
    folderRepository.save(jimFolder);

    Folder hopeFolder = new Folder("hope_folder", hope);
    folderRepository.save(hopeFolder);

    Folder kenFolder = new Folder("ken_folder", ken);
    folderRepository.save(kenFolder);

    File file1 = new File("holiday", ExtensionType.JPEG, 500, jimFolder);
    fileRepository.save(file1);

    File file2 = new File("hello_world", ExtensionType.JAVA, 300, hopeFolder);
    fileRepository.save(file2);

    File file3 = new File("runner", ExtensionType.JS, 350, kenFolder);
    fileRepository.save(file3);

    jimFolder.addFile(file1);
    folderRepository.save(jimFolder);

    hopeFolder.addFile(file2);
    folderRepository.save(hopeFolder);

    kenFolder.addFile(file3);
    folderRepository.save(kenFolder);

    jim.addFolder(jimFolder);
    personRepository.save(jim);

    hope.addFolder(hopeFolder);
    personRepository.save(hope);

    ken.addFolder(kenFolder);
    personRepository.save(ken);





  }
}
