
package com.gullysports.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gullysports.db.SportRepository;
import com.gullysports.models.Sport;
import org.springframework.web.bind.MethodArgumentNotValidException;

/**
 * Sports class which is responsible for managing all the sports we are supporting
 * related to project pricing.
 * 
 * @author nitesh.sharma
 */
@Service
public class SportService {

    /**
     * Repository instance for Asset.
     */
    @Autowired
    private SportRepository sportRepository;

    /**
     * Function to get all the sports from database.
     * @return list of sports
     */
    public List<Sport> getAllSports() {
        return (List<Sport>) sportRepository.findAll();
    }

    public Sport getSport(String sportID) {

        if(sportRepository.findById(sportID) == null){
            throw new IllegalArgumentException(String.format("Sport with ID:%s is not present", sportID));
        }

        return sportRepository.findById(sportID);
    }
    
    /**
     * Function to add a sport.
     * @param sport sport object which needs to be added
     * @return added sport
     */
    public Sport addSport(final Sport sport) {

        if(!(sportRepository.findByName(sport.getName()).isEmpty())){
            throw new IllegalArgumentException(String.format("Sport %s is already present", sport.getName()));
        }

        return sportRepository.save(sport);
    }

    public Sport updateSport(Sport sport){

        if(sport.getId() == null){
            throw new IllegalArgumentException("Sport ID cannot be null");
        }

        if(sportRepository.findById(sport.getId()) == null){
            throw new IllegalArgumentException(String.format("Sport with ID:%s is not present", sport.getId()));
        }

        return sportRepository.save(sport);
    }
}
