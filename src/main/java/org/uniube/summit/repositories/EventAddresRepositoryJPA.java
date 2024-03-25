package org.uniube.summit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.uniube.summit.domain.EventAddres;

import java.util.List;

@Repository
public interface EventAddresRepositoryJPA extends JpaRepository<EventAddres, Long> {
    @Query("Select eventaddres from EventAddres eventaddres")
    public List<EventAddres>findAll();

}
