package com.example.codeclan.FoldersFilesAndPeople.repos;

import com.example.codeclan.FoldersFilesAndPeople.models.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Long>
{
}
