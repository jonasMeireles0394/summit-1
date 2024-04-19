package org.uniube.summit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.uniube.summit.domain.Image;
import org.uniube.summit.repositories.entities.ImageEntity;
import org.uniube.summit.repositories.implementation.ImageRepository;
import org.uniube.summit.services.mappers.ImageMapper;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    private ImageRepository repository;
    @Transactional(readOnly = true)
    public List<ImageEntity> findAll(){
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Image get(Long id){
        return ImageMapper.out(repository.get(id));
    }
}
