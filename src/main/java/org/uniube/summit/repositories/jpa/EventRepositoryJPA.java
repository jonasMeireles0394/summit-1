package org.uniube.summit.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.uniube.summit.domain.Event;
@Repository
public interface EventRepositoryJPA extends JpaRepository<Event, Long> {

}
