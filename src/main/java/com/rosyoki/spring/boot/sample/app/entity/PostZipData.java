package com.rosyoki.spring.boot.sample.app.entity;

import lombok.Data;

/**
 * Table: post_zip_data
 */
@Data
public class PostZipData {
    /**
     * Column: id
     */
    private Long id;

    /**
     * Column: old_zip
     */
    private String oldZip;

    /**
     * Column: zip
     */
    private String zip;

    /**
     * Column: pref
     */
    private String pref;

    /**
     * Column: city
     */
    private String city;

    /**
     * Column: town
     */
    private String town;
}