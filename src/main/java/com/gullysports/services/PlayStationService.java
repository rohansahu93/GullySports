package com.gullysports.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gullysports.db.PlayStationRepository;
import com.gullysports.models.PlayStation;

/**
 * PlayStationService class which is responsible for managing different
 * operations on all the PlayStations we are supporting related to project
 * GullySports.
 * 
 * @author nitesh.sharma
 *
 */
@Service
public class PlayStationService implements PaginationGenericService<PlayStation, String> {

	/**
	 * Repository instance for PlayStation.
	 */
	@Autowired
	private PlayStationRepository playStationRepository;

	/**
	 * Logger object to log all the important activities.
	 */
	private final Logger LOGGER = LoggerFactory.getLogger(SportService.class);

	@Override
	public Page<PlayStation> getPaginatedItems(Pageable pageable) {
		LOGGER.info("PlayStationService - getting List of all the play stations.");
		return playStationRepository.findAll(pageable);
	}

	@Override
	public PlayStation getById(String id) {
		return playStationRepository.findById(id);
	}

	@Override
	public PlayStation add(PlayStation playStation) {
		return playStationRepository.save(playStation);
	}

	@Override
	public PlayStation update(PlayStation playStation) {

		if (playStation.getId() == null) {
			LOGGER.error("PlayStation ID cannot be null.");
			throw new IllegalArgumentException("PlayStation ID cannot be null");
		}

		if (playStationRepository.findById(playStation.getId()) == null) {
			LOGGER.error(String.format("PlayStation with ID:%s is not present", playStation.getId()));
			throw new IllegalArgumentException(
					String.format("PlayStation with ID:%s is not present", playStation.getId()));
		}

		return playStationRepository.save(playStation);
	}

	@Override
	public void delete(String id) {
		
		if(playStationRepository.findById(id) == null){
            LOGGER.error(String.format("PlayStation with ID:%s is not present", id) );
            throw new IllegalArgumentException(String.format("Sport with ID:%s is not present", id));
        }
		
		playStationRepository.delete(id);
        LOGGER.info(String.format("PlayStation: PlayStation id:%s deleted", id));
	}

}
