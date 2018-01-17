
package com.gullysports.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gullysports.db.SportRepository;
import com.gullysports.models.Sport;

/**
 * PrintersPricingService class which is responsible for all kind of operations
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
    
    /**
     * Function to add a sport.
     * @param sport sport object which needs to be added
     * @return added sport
     */
    public Sport addSport(final Sport sport) {
        return sportRepository.save(sport);
    }
}
