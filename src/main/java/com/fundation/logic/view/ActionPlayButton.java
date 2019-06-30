/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Implements the ButtonPlayer class
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class ActionPlayButton {
    public ActionPlayButton(){
    }

    /**
     * This method run video when we do click on button player
     */
    public static void clickAction(JButton btnPlayer) {
        btnPlayer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                PlayerJFrame playerWindow = new PlayerJFrame("resources/Wildlife.wmv");
                playerWindow.setVisible(true);
            }
        });
    }
}
