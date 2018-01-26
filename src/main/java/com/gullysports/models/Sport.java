
package com.gullysports.models;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection = "sports")
public class Sport extends EntityBase{

    @NotNull(message = "Sport name cannot be null")
    @Indexed(unique = true)
    private String name;

    @NotNull(message = "Sport type cannot be null")
    private SportType sportType;

    private String description;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SportType getSportType() {
        return sportType;
    }

    public void setSportType(SportType sportType) {
        this.sportType = sportType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
