package org.uniube.summit.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.uniube.summit.repositories.entities.CategoryEntity;

import java.util.List;

@Repository
public interface CategoryRepositoryJPA extends JpaRepository<CategoryEntity, Long> {
    @Query("Select category from Category category")
    public List<CategoryEntity>findAll();

}
