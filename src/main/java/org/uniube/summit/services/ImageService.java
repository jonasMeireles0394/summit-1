package org.uniube.summit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.uniube.summit.domain.Image;
import org.uniube.summit.repositories.jpa.ImageRepositoryJPA;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    private ImageRepositoryJPA repository;
    @Transactional(readOnly = true)
    public List<Image> findAll(){
        return repository.findAll();
    }


}
