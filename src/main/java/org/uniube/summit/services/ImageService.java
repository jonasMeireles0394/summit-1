package org.uniube.summit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.uniube.summit.domain.EventAddres;
import org.uniube.summit.domain.Image;
import org.uniube.summit.repositories.entities.EventAddresEntity;
import org.uniube.summit.repositories.entities.ImageEntity;
import org.uniube.summit.repositories.implementation.ImageRepository;
import org.uniube.summit.services.mappers.EventAddressMapper;
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

    @Transactional
    public Image create(Image image){
        if(image.getId() != null){
            throw new IllegalArgumentException("Identificador deve ser nulo para operação de cadastro!");
        }
        ImageEntity entity = ImageMapper.in(image);
        return ImageMapper.out(repository.save(entity));
    }

    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }

    @Transactional
    public Image update(Image image){
        if(image.getId() == null){
            throw new IllegalArgumentException("Identificador deve ser fornecido para operação de atualização!");
        }
        ImageEntity entity = ImageMapper.in(image);
        return ImageMapper.out(repository.save(entity));
    }
}
