
package com.gullysports.db;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gullysports.models.Sport;

/**
 * AssetRepository interface, declares the methods exposed by the repository.
 * Following default methods are provided by CrudRepository and can be used as
 * is without requiring any implementation. save, findOne, exists, findAll,
 * count, delete and deleteAll. Please refer to the javadocs for more details.
 * 
 * @author nitesh.sharma
 */
public interface SportRepository extends CrudRepository<Sport, String> {

    /**
     * Finds a Sport object that matches the name parameter. Spring
     * automatically formulates appropriate query depending on the name of the
     * method. findByXXX() method would look for a match for XXX property and
     * return the object instance.
     *
     * @param name name of the Sport
     * @return Sport Object matching the name parameter
     */
    List<Sport> findByName(String name);

    Sport findById(String id);
}
