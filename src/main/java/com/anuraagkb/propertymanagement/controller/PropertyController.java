package com.anuraagkb.propertymanagement.controller;

import com.anuraagkb.propertymanagement.dto.PropertyDTO;
import com.anuraagkb.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/v1")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }

    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO){
        PropertyDTO savedPropertyDto = propertyService.saveProperty(propertyDTO);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(savedPropertyDto, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/properties")
    public ResponseEntity<Collection<PropertyDTO>> getAllProperties(){
        Collection<PropertyDTO> allProperties = propertyService.getAllProperties();
        ResponseEntity<Collection<PropertyDTO>> responseEntity = new ResponseEntity<>(allProperties, HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping("/properties/{id}")
    public ResponseEntity<PropertyDTO> updateProperty(@PathVariable("id") Long id,
                                                      @RequestBody PropertyDTO propertyDTO){
        PropertyDTO updatedPropertyDto = propertyService.updateProperty(id, propertyDTO);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(updatedPropertyDto, HttpStatus.OK);
        return responseEntity;
    }

    @PatchMapping("/properties/{id}/update-description")
    public ResponseEntity<PropertyDTO> updatePropertyDescription(@PathVariable("id") Long id,
                                                                 @RequestBody PropertyDTO propertyDTO){
        PropertyDTO updatedPropertyDto = propertyService.updatePropertyDescription(id, propertyDTO);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(updatedPropertyDto, HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/properties/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable("id") Long id){
        propertyService.deleteProperty(id);
        return ResponseEntity.noContent().build();
    }

}
