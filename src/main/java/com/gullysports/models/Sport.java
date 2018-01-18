
package com.gullysports.models;

import javax.validation.constraints.NotNull;

public class Sport extends EntityBase{

    @NotNull
    private String name;

    @NotNull
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
