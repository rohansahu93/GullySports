
package com.gullysports.services;

import com.gullysports.db.SportRepository;
import com.gullysports.models.Sport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Sports class which is responsible for managing all the sports we are supporting
 * related to project GullySports.
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

    private final Logger LOGGER = LoggerFactory.getLogger(SportService.class);

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
    public Sport addSport(Sport sport) {

        if(!(sportRepository.findByName(sport.getName()).isEmpty())){
            throw new IllegalArgumentException(String.format("Sport %s is already present", sport.getName()));
        }

        return sportRepository.save(sport);
    }

    /**
     * Function to update a sport.
     * @param sport sport object which needs to be updated
     * @return update sport
     */
    public Sport updateSport(Sport sport){

        if(sport.getId() == null){
            throw new IllegalArgumentException("Sport ID cannot be null");
        }

        if(sportRepository.findById(sport.getId()) == null){
            LOGGER.error(String.format("Sport with ID:%s is not present", sport.getId()));
            throw new IllegalArgumentException(String.format("Sport with ID:%s is not present", sport.getId()));
        }

        return sportRepository.save(sport);
    }

    /**
     * Function to delete a sport.
     * @param sportID which needs to be deleted
     * @return update sport
     */
    public void deleteSport(String sportID){

        if(sportRepository.findById(sportID) == null){
            LOGGER.error(String.format("Sport with ID:%s is not present", sportID) );
            throw new IllegalArgumentException(String.format("Sport with ID:%s is not present", sportID));
        }
        sportRepository.delete(sportID);
        LOGGER.info(String.format("SPORT: Sport id:%s deleted", sportID));
    }
}
