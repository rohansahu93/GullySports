
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
public class SportService implements GenericService<Sport, String> {

    /**
     * Repository instance for Sport.
     */
    @Autowired
    private SportRepository sportRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(SportService.class);

    /**
     * Function to get all the sports from database.
     * @return list of sports
     */
    @Override
    public List<Sport> getAll() {
        return (List<Sport>) sportRepository.findAll();
    }

    @Override
    public Sport getById(String sportID) {

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
    @Override
    public Sport add(Sport sport) {

        return sportRepository.save(sport);
    }

    /**
     * Function to update a sport.
     * @param sport sport object which needs to be updated
     * @return update sport
     */
    @Override
    public Sport update(Sport sport){

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
    @Override
    public void delete(String sportID){

        // TODO :  Delete entities which are linked with this user

        if(sportRepository.findById(sportID) == null){
            LOGGER.error(String.format("Sport with ID:%s is not present", sportID) );
            throw new IllegalArgumentException(String.format("Sport with ID:%s is not present", sportID));
        }
        sportRepository.delete(sportID);
        LOGGER.info(String.format("SPORT: Sport id:%s deleted", sportID));
    }
}
