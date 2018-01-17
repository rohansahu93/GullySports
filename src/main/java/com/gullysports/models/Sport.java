
package com.gullysports.models;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.Data;

/**
 * Sport object properties class
 * 
 * @author nitesh.sharma
 */
@Data
public class Sport {

    @Id private String id;
    private String name;
    private Date createdDate;
    private Date modifiedDate;
}
