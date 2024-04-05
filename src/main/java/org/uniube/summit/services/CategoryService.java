package org.uniube.summit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.uniube.summit.domain.Category;
import org.uniube.summit.repositories.implementation.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<Category>findAll(){
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Category get(Long id){
        return repository.get(id);
    }

    @Transactional
    public Category create(Category category){
        if (category.getId() != null) {
            throw new IllegalArgumentException("Identificador deve ser nulo para operação de cadastro!");
        }
        return repository.save(category);
    }

    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }

    @Transactional
    public Category update(Category category){
        if (category.getId() == null){
            throw new IllegalArgumentException("Identificador deve ser fornecido para operação de atualização!");
        }
        return repository.update(category);
    }

}
