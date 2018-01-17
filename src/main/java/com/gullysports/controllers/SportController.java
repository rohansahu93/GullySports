
package com.gullysports.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gullysports.models.Sport;
import com.gullysports.services.SportService;

/**
 * This class is responsible for exposing REST APis for Pricing.
 */
@RestController
@RequestMapping("/sports")
public class SportController {

    /**
     * Spring will initialize ProjectService object.
     */
    @Autowired private SportService sportService;

    /**
     * Rest Interface for fetching all the sports.
     * 
     * @return List of sports
     * @throws Exception
     */
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public final List<Sport> getAllSports()
        throws Exception {

        return sportService.getAllSports();
    }

    /**
     * Rest interface for adding a sport.
     * 
     * @param sport
     * @return added sport details
     */
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    public final Sport addSport(@RequestBody
    final Sport sport) {

        return sportService.addSport(sport);
    }
}
