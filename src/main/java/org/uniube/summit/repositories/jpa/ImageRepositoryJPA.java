package org.uniube.summit.repositories.jpa;

import org.ietf.jgss.Oid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.uniube.summit.domain.Image;

import java.sql.Blob;
import java.util.List;
import java.util.Optional;

@Repository
public interface ImageRepositoryJPA extends JpaRepository<Image, Oid> {
    @Query("Select image from Image image")
    public List<Image> findAll();

}
