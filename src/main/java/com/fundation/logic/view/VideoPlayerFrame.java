 /**
  * Copyright (c) 2019 Jalasoft.
  * This software is the confidential and proprietary information of Jalasoft.
  * ("Confidential Information"). You shall not
  * disclose such Confidential Information and shall use it only in
  * accordance with the terms of the license agreement you entered into
  * with Jalasoft.
  */

package com.fundation.logic.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Implements the VideoPlayerFrame class Frame
 *
 * @author John Salazar Pinto
 * @version 1.0
 */

public class VideoPlayerFrame extends JFrame {

    private JPanel contentVideoPane;

    public VideoPlayerFrame() {

        initComponent();
        initSetting();

    }
/**
 *This method init all component
 */

    public void initComponent(){

        contentVideoPane = new JPanel();

    }

/**
 * This method init all setting of the components
 */

    public void initSetting(){

        setBounds(100, 100, 1000, 700);
        contentVideoPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentVideoPane.setLayout(new BorderLayout(0, 0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentVideoPane);
    }
}