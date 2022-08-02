package com.example.codeclan.FoldersFilesAndPeople.repos;

import com.example.codeclan.FoldersFilesAndPeople.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>
{
}
