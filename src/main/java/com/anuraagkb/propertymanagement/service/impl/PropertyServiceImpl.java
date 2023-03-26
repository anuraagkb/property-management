package com.anuraagkb.propertymanagement.service.impl;

import com.anuraagkb.propertymanagement.converter.PropertyConverter;
import com.anuraagkb.propertymanagement.dto.PropertyDTO;
import com.anuraagkb.propertymanagement.entity.PropertyEntity;
import com.anuraagkb.propertymanagement.repository.PropertyRepository;
import com.anuraagkb.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.query.JpaEntityGraph;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;

    @Value("${test.message}")
    private String variable;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        PropertyEntity propertyEntity = propertyConverter.convertDtoToEntity(propertyDTO);
        PropertyEntity savedEntity = propertyRepository.save(propertyEntity);
        PropertyDTO savedDTO = propertyConverter.convertEntityToDto(savedEntity);
        return savedDTO;
    }

    @Override
    public Collection<PropertyDTO> getAllProperties() {
        System.out.println(variable);
        List<PropertyEntity> all = (List)propertyRepository.findAll();
        return all.stream().map(p -> propertyConverter.convertEntityToDto(p)).collect(Collectors.toList());
    }

    @Override
    public PropertyDTO updateProperty(Long id, PropertyDTO propertyDTO) {
        Optional<PropertyEntity> propertyEntityOptional = propertyRepository.findById(id);
        if(propertyEntityOptional.isPresent()){
            PropertyEntity propertyEntity = propertyEntityOptional.get();
            propertyEntity.setAddress(propertyDTO.getAddress());
            propertyEntity.setTitle(propertyDTO.getTitle());
            propertyEntity.setPrice(propertyDTO.getPrice());
            propertyEntity.setDescription(propertyDTO.getDescription());
            propertyEntity.setOwnerName(propertyDTO.getOwnerName());
            propertyEntity.setOwnerEmail(propertyDTO.getOwnerEmail());
            PropertyEntity updatedEntity = propertyRepository.save(propertyEntity);
            return propertyConverter.convertEntityToDto(updatedEntity);
        }
        return null;
    }

    @Override
    public PropertyDTO updatePropertyDescription(Long id, PropertyDTO propertyDTO) {
        Optional<PropertyEntity> propertyEntityOptional = propertyRepository.findById(id);
        if(propertyEntityOptional.isPresent()){
            PropertyEntity propertyEntity = propertyEntityOptional.get();
            propertyEntity.setDescription(propertyDTO.getDescription());
            PropertyEntity updatedEntity = propertyRepository.save(propertyEntity);
            return propertyConverter.convertEntityToDto(updatedEntity);
        }
        return null;
    }

    @Override
    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }
}
