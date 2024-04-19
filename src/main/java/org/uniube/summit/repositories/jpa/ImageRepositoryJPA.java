package org.uniube.summit.repositories.jpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.uniube.summit.repositories.entities.ImageEntity;

import java.util.List;

@Repository
public interface ImageRepositoryJPA extends JpaRepository<ImageEntity, Long> {
    @Query("Select image from ImageEntity image")
    public List<ImageEntity> findAll();
}
