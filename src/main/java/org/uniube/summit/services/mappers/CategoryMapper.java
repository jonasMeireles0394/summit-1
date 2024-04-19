package org.uniube.summit.services.mappers;
import org.uniube.summit.domain.Category;
import org.uniube.summit.repositories.entities.CategoryEntity;

public class CategoryMapper {
    public static Category out(CategoryEntity entity){
        if (entity == null){
            return null;
        }
        Category domain = new Category();
        domain.setId(entity.getId());
        domain.setName(entity.getName());
        return domain;
    }

    public static CategoryEntity in(Category domain){
        if (domain == null){
            return null;
        }
        CategoryEntity entity = new CategoryEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        return entity;
    }

}
