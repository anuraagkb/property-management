package com.anuraagkb.propertymanagement.service;

import com.anuraagkb.propertymanagement.dto.PropertyDTO;

import java.util.Collection;
import java.util.List;

public interface PropertyService {

    public PropertyDTO saveProperty(PropertyDTO propertyDTO);

    public Collection<PropertyDTO> getAllProperties();

    public PropertyDTO updateProperty(Long id, PropertyDTO propertyDTO);

    public PropertyDTO updatePropertyDescription(Long id, PropertyDTO propertyDTO);

    public void deleteProperty(Long id);
}
