/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.common;

import com.fundation.logic.model.convertCriteriaBuilderPattern.ConvertCriteria;
import com.fundation.logic.model.searchCriteria.Audio;
import com.fundation.logic.model.searchCriteria.Common;
import com.fundation.logic.model.searchCriteria.Criteria;
import com.fundation.logic.model.searchCriteria.Image;
import com.fundation.logic.model.searchCriteria.Video;
import com.google.gson.Gson;

/**
 * Implements JsonConverter abstract class which is used to convert json records in DB.
 *
 * @author Melissa Román
 * @version 1.0
 */
public abstract class JsonConverter {
    /**
     * Converts an instance of Criteria class to json.
     * @param criteria - Criteria to be convert to json.
     * @return json corresponding to given searchCriteria.
     */
    public static String searchCriteriaToJson(Criteria criteria) {
        Gson gson = new Gson();
        String json = gson.toJson(criteria);
        return json;
    }

    /**
     * Converts a json to a Criteria instance according on given type.
     * @param json - String corresponding to json.
     * @param type - Criteria's type.
     * @return Instance of Criteria class according on given type.
     */
    public static Criteria jsonToSearchCriteria(String json, String type) {
        Gson gson = new Gson();
        switch (type) {
            case "Audio":
                return gson.fromJson(json, Audio.class);
            case "Common":
                return gson.fromJson(json, Common.class);
            case "Image":
                return gson.fromJson(json, Image.class);
            case "Video":
                return gson.fromJson(json, Video.class);
            default:
                return null;
        }
    }

    /**
     * Converts an instance of ConvertCriteria class to json.
     * @param criteria - ConvertCriteria to be convert to json.
     * @return json corresponding to given convertCriteria.
     */
    public static String convertCriteriaToJson(ConvertCriteria criteria) {
        Gson gson = new Gson();
        String json = gson.toJson(criteria);
        return json;
    }
}
