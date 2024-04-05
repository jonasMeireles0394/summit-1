package org.uniube.summit.repositories.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.uniube.summit.domain.Category;
import org.uniube.summit.repositories.jpa.CategoryRepositoryJPA;

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

    public void deleteById(Long id){
        repositoryJPA.deleteById(id);
    }

    public Category update(Category category){
        if (category.getId() != null && repositoryJPA.existsById(category.getId())){
            return repositoryJPA.save(category);
        } else {
            throw new IllegalArgumentException("Identificador deve ser nulo para operação de atualização!");
        }
    }
}
