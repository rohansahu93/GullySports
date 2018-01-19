
package com.gullysports.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gullysports.models.Sport;
import com.gullysports.services.SportService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * This class is responsible for exposing REST APis for sports.
 */
@RestController
@RequestMapping("/v1/sports")
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
    @ResponseBody
    public List<Sport> getAllSports() throws Exception {
        return sportService.getAllSports();
    }

    /**
     * Rest interface for adding a sport.
     * 
     * @param sport
     * @return added sport details
     */
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    public Sport addSport(@RequestBody @Valid Sport sport) throws Exception{

        return sportService.addSport(sport);
    }

    /**
     * Rest Interface for fetching single sport.
     *
     * @return Single sport
     * @throws Exception
     */
    @RequestMapping(value = "/{sportId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Sport getSport(@PathVariable("sportId") String sportId) throws Exception {
        return sportService.getSport(sportId);
    }

    /**
     * Rest Interface for updating sport.
     *
     * @return updated sport
     * @throws Exception
     */

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Sport updateSport(HttpServletRequest request, HttpServletResponse response, @RequestBody @Valid Sport sport) throws Exception {
        return sportService.updateSport(sport);
    }
}
