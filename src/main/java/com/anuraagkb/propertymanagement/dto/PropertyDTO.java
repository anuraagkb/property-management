package com.anuraagkb.propertymanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyDTO {

    private String title;
    private String description;
    private String ownerName;
    private String price;
    private String address;
    private String ownerEmail;

    @Override
    public String toString() {
        return "PropertyDTO{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", price='" + price + '\'' +
                ", address='" + address + '\'' +
                ", ownerEmail='" + ownerEmail + '\'' +
                '}';
    }
}
