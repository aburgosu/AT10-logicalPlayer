/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic;

import com.fundation.logic.view.SearchVideoFrame;
import com.fundation.logic.controller.Controller;
/**
 * Implements the main class
 *
 * @author Andres Burgos
 * @version 1.0
 */
public class main {

    public static void main(String[] arg) {
        SearchVideoFrame searchFrame = new SearchVideoFrame();
        Controller controller = new Controller(searchFrame);
        controller.setEvents();
    }
}
