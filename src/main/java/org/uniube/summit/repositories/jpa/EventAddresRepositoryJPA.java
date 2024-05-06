package org.uniube.summit.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.uniube.summit.repositories.entities.EventAddresEntity;

import java.util.List;

@Repository
public interface EventAddresRepositoryJPA extends JpaRepository<EventAddresEntity, Long> {
    @Query("Select eventaddres from EventAddresEntity eventaddres")
    public List<EventAddresEntity>findAll();

}
