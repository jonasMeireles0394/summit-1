package org.uniube.summit.repositories.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.uniube.summit.domain.Image;
import org.uniube.summit.repositories.entities.CategoryEntity;
import org.uniube.summit.repositories.entities.ImageEntity;
import org.uniube.summit.repositories.jpa.ImageRepositoryJPA;

import java.util.List;

@Repository
public class ImageRepository {
    @Autowired
    private ImageRepositoryJPA repositoryJPA;
    public List<ImageEntity> findAll(){
        return repositoryJPA.findAll();
    }

    public ImageEntity get(Long id){
        return repositoryJPA.findById(id).orElse(null);
    }
    public ImageEntity save(ImageEntity image){
        return repositoryJPA.save(image);
    }

    public void deleteById(Long id){
        repositoryJPA.deleteById(id);
    }

    public ImageEntity update(ImageEntity image){
        if (image.getId() != null && repositoryJPA.existsById(image.getId())){
            return repositoryJPA.save(image);
        } else {
            throw new IllegalArgumentException("Identificador deve ser nulo para operação de atualização!");
        }
    }


}
