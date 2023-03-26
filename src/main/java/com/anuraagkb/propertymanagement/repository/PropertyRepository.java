package com.anuraagkb.propertymanagement.repository;

import com.anuraagkb.propertymanagement.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<PropertyEntity, Long> {
}
