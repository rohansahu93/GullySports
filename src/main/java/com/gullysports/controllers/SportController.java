
package com.gullysports.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.gullysports.models.Sport;
import com.gullysports.services.SportService;

/**
 * This class is responsible for exposing REST APis for sports.
 * TODO :  Refactor controller - create base controller
 */
@RestController
@RequestMapping("v1/sports")
public class SportController {

    /**
     * Spring will initialize SportService object.
     */
    @Autowired
    private SportService sportService;

    /**
     * Rest Interface for fetching all the sports.
     * 
     * @return List of sports
     * @throws Exception
     */
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Sport> getAllSports()
        throws Exception {

        return sportService.getAll();
    }

    /**
     * Rest interface for adding a sport.
     * 
     * @param sport
     * @return added sport details
     */
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    public Sport addSport(@RequestBody @Valid Sport sport)
        throws Exception {

        return sportService.add(sport);
    }

    /**
     * Rest Interface for fetching single sport.
     *
     * @return Single sport
     * @throws Exception
     */
    @RequestMapping(value = "{sportId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Sport getSport(@PathVariable("sportId") String sportId)
        throws Exception {

        return sportService.get(sportId);
    }

    /**
     * Rest Interface for updating sport.
     *
     * @return updated sport
     * @throws Exception
     */

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Sport updateSport(@RequestBody @Valid Sport sport)
        throws Exception {

        return sportService.update(sport);
    }

    /**
     * Rest Interface for deleting sport.
     *
     * @return deleting sport
     * @throws Exception
     */

    @RequestMapping(value = "{sportId}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public void deleteSport(@PathVariable("sportId") String sportId)
        throws Exception {

        sportService.delete(sportId);
    }
}
