package com.gullysports.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gullysports.models.PlayStation;
import com.gullysports.services.PlayStationService;

/**
 * PlayStationController which is responsible for exposing REST APis for
 * PlayStation.
 * 
 * @author nitesh.sharma
 *
 */
@RestController
@RequestMapping("v1/playStations")
public class PlayStationController {

	/**
	 * Spring will initialize PlayStationService object.
	 */
	@Autowired
	private PlayStationService playStationService;
	
	/**
	 * API to get paginated PlayStations.
	 * 
	 * @param pageable Object which contains pagination information.
	 * @return paginated PlayStations.
	 */
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Page<PlayStation> getPlayStations(Pageable pageable) {
		
		return playStationService.getPaginatedItems(pageable);
	}
	
	/**
	 * API to add a PlayStation.
	 * 
	 * @param playStation PlayStation object which needs to be added.
	 * @return added PlayStation object.
	 */
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
	public PlayStation addPlayStation(@RequestBody @Valid PlayStation playStation) {
		
		return playStationService.add(playStation);
	}
	
	/**
	 * API to get a PlayStation record.
	 * 
	 * @param playStationId Unique identifier of PlayStation object.
	 * @return PlayStation record which matched the playStationId.
	 */
	@RequestMapping(value = "{playStationId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
	public PlayStation getPlayStation(@PathVariable("playStationId") String playStationId) {
		
		return playStationService.getById(playStationId);
	}
	
	/**
	 * API to update a PlayStation record.
	 * 
	 * @param playStation PlayStation object which needs to be updated.
	 * @return updated PlayStation object.
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
	public PlayStation updatePlayStation(@RequestBody @Valid PlayStation playStation) {
		
		return playStationService.update(playStation);
	}
	
	/**
	 * API to delete a PlayStation record.
	 * 
	 * @param playStationId Unique identifier of PlayStation object.
	 * @throws Exception Any Exception which occurred during execution.
	 */
	@RequestMapping(value = "{playStationId}", method = RequestMethod.DELETE, produces = "application/json")
    public void deletePlayStation(@PathVariable("playStationId") String playStationId)
        throws Exception {

		playStationService.delete(playStationId);
    }
	
	/**
	 * API to find PlayStations which match with the queried name.
	 *  
	 * @param name Queried name.
	 * @return List of filtered PlayStations.
	 */
	@RequestMapping(value = "name/{name}", method = RequestMethod.GET, produces = "application/json")
	public List<PlayStation> findPlayStationsByName(@PathVariable("name") String name) {
		
		return playStationService.findByName(name);
	}
}
