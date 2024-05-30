package org.uniube.summit.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.uniube.summit.repositories.entities.UserEntity;
@Repository
public interface UserRepositoryJPA extends JpaRepository<UserEntity, Long> {
}
