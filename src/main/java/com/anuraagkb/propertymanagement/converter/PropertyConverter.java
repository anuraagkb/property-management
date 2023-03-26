package com.anuraagkb.propertymanagement.converter;

import com.anuraagkb.propertymanagement.dto.PropertyDTO;
import com.anuraagkb.propertymanagement.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public PropertyEntity convertDtoToEntity(PropertyDTO propertyDTO){
        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setAddress(propertyDTO.getAddress());
        propertyEntity.setTitle(propertyDTO.getTitle());
        propertyEntity.setPrice(propertyDTO.getPrice());
        propertyEntity.setDescription(propertyDTO.getDescription());
        propertyEntity.setOwnerName(propertyDTO.getOwnerName());
        propertyEntity.setOwnerEmail(propertyDTO.getOwnerEmail());
        return propertyEntity;
    }

    public PropertyDTO convertEntityToDto(PropertyEntity propertyEntity){
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setAddress(propertyEntity.getAddress());
        propertyDTO.setDescription(propertyEntity.getDescription());
        propertyDTO.setTitle(propertyEntity.getTitle());
        propertyDTO.setPrice(propertyEntity.getPrice());
        propertyDTO.setOwnerName(propertyEntity.getOwnerName());
        propertyDTO.setOwnerEmail(propertyEntity.getOwnerEmail());
        return propertyDTO;
    }

}
