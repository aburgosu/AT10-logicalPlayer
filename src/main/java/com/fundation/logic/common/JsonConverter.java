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

import com.fundation.logic.model.criteria.*;
import com.google.gson.Gson;

/**
 * Implements JsonConverter abstract class which is used to convert json records in DB.
 *
 * @author Melissa Román
 * @version 1.0
 */
public abstract class JsonConverter {
    public static String criteriaToJson(Criteria criteria) {
        Gson gson = new Gson();
        String json = gson.toJson(criteria);
        return json;
    }

    public static Criteria jsonToCriteria(String json) {
        Gson gson = new Gson();
        int indexType = json.indexOf(" ");
        String criteriaType = json.substring(0, indexType);
        String jsonCriteria = json.substring(indexType + 1);
        switch (criteriaType) {
            case "Audio":
                return gson.fromJson(jsonCriteria, Audio.class);
            case "Common":
                return gson.fromJson(jsonCriteria, Common.class);
            case "Image":
                return gson.fromJson(jsonCriteria, Image.class);
            case "Video":
                return gson.fromJson(jsonCriteria, Video.class);
            default:
                return null;
        }
    }
}