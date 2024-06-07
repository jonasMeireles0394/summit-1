package org.uniube.summit.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.uniube.summit.repositories.entities.PersonEntity;

import java.util.List;

@Repository
public interface PersonRepositoryJPA extends JpaRepository <PersonEntity, Long> {
    @Query("Select person from PersonEntity person")
    public List<PersonEntity> findAll();

    @Query("Select person from PersonEntity person where person.username = ?1 and person.password = ?2")
    public PersonEntity findByCredential(String username, String password);
}