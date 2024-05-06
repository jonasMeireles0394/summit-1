package org.uniube.summit.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.uniube.summit.repositories.entities.EventEntity;

import java.util.List;

@Repository
public interface EventRepositoryJPA extends JpaRepository<EventEntity, Long> {
    @Query("Select event from EventEntity event")
    public List<EventEntity> findAll();

}
