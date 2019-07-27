/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.model.search;

import com.fundation.logic.model.searchCriteria.Audio;
import com.fundation.logic.model.searchCriteria.Common;
import com.fundation.logic.model.searchCriteria.Criteria;
import com.fundation.logic.model.searchCriteria.Image;
import com.fundation.logic.model.searchCriteria.Video;

/**
 * Implements the SearchFactory class.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class SearchFactory {
    /**
     * Allows to get an instance of a class that implements ISearch interface according to criteria input.
     * @param criteria
     * @return
     */
    public ISearch createSearch(Criteria criteria) {
        if (criteria instanceof Common) {
            return new CommonSearch((Common) criteria);
        }
        if (criteria instanceof Video) {
            return new VideoSearch((Video) criteria);
        }
        if (criteria instanceof Audio) {
            return new AudioSearch((Audio) criteria);
        }
        if (criteria instanceof Image) {
            return new ImageSearch((Image) criteria);
        }
        return null;
    }
}
