package com.gullysports.db;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.gullysports.models.PlayStation;

/**
 * PlayStationRepository interface, declares the methods exposed by the repository.
 * Following default methods are provided by PagingAndSortingRepository and can be used as
 * is without requiring any implementation. save, findOne, exists, findAll,
 * count, delete and deleteAll. Please refer to the javadocs for more details.
 * 
 * @author nitesh.sharma
 */
public interface PlayStationRepository extends PagingAndSortingRepository<PlayStation, String>{

	PlayStation findById(String id);

	List<PlayStation> findByName(String name);
}
