package org.uniube.summit.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.uniube.summit.domain.Person;

import java.util.List;

@Repository
public interface PersonRepositoryJPA extends JpaRepository <Person, Long> {
    @Query("Select person from Person person")
    public List<Person> findAll();

    @Query("Select person from Person person where person.username = ?1 and person.password = ?2")
    public Person findByCredential(String username, String password);
}
