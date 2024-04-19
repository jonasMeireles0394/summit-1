package org.uniube.summit.services.mappers;
import org.uniube.summit.domain.Image;
import org.uniube.summit.repositories.entities.ImageEntity;


public class ImageMapper {
    public static Image out(ImageEntity entity){
        if (entity == null){
            return null;
        }
        Image domain = new Image();
        domain.setId(entity.getId());
        domain.setFile(entity.getFile());
        return domain;
    }

    public static ImageEntity in(Image domain){
        if (domain == null){
            return null;
        }
        ImageEntity entity = new ImageEntity();
        entity.setId(domain.getId());
        entity.setFile(domain.getFile());
        return entity;
    }
    
}
