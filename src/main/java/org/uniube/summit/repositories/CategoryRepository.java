package org.uniube.summit.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.uniube.summit.domain.Category;

import java.util.List;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryRepositoryJPA repositoryJPA;

    public List<Category>findAll(){
        return repositoryJPA.findAll();
    }

    public Category get(Long id){
        return repositoryJPA.findById(id).orElse(null);
    }

    public Category save(Category category){
        return repositoryJPA.save(category);
    }
}
