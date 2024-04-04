package org.uniube.summit.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.uniube.summit.domain.Image;

import java.util.List;

@Repository
public class ImageRepository {
    @Autowired
    private ImageRepositoryJPA repositoryJPA;
    public List<Image> findAll(){
        return repositoryJPA.findAll();
    }


}
