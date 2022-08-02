package com.example.codeclan.FoldersFilesAndPeople.repos;

import com.example.codeclan.FoldersFilesAndPeople.models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long>
{
}
