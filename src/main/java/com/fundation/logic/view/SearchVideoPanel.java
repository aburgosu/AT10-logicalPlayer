/**
 * Copyright (c) 2019 Jalasoft.
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Implements the SearchVideoPanel class
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class SearchVideoPanel extends JPanel {
    private JTextField txtFldFileName;
    private JTextField txtFldSize;
    private JTextField txtFldCreationDate;
    private JTextField txtFldModificationDate;
    private JTextField txtFldFrameRate;
    private JTextField txtFldVideoFormat;
    private JTextField txtFldResolution;
    private JTextField txtFldPath;
    private JLabel lblSearch;
    private JLabel lblPath;
    private JLabel lblFileName;
    private JLabel lblSize;
    private JLabel lblCreationDate;
    private JLabel lblModificationDate;
    private JLabel lblVideoSearchTittle;
    private JLabel lblFrameRate;
    private JLabel lblVideoFormat;
    private JLabel lblResolution;
    private JLabel lblAudio;
    private JLabel lblAurioSearchTittle;
    private JLabel lblAudioChanel;
    private JLabel lblAudioFileFormat;
    private JComboBox comboSize;
    private JComboBox comboAudioFileFormat;
    private JComboBox comboAudioChanel;
    private JCheckBox chxYes, chxNo;
    private Integer positionOneX;
    private Integer positionTwoX;
    private Integer positionThreeX;
    private JButton btnPlayer;
    private JButton btnSearchFile;
    private String pathAddress;

    public SearchVideoPanel() {
        initComponent();
        initSetting();
    }

    /**
     * This method init all component
     */
    public void initComponent() {


        setLayout(null);
        //Init and adds Labels
        lblSearch = new JLabel("CommonSearch");
        add(lblSearch);
        lblPath = new JLabel("Path");
        add(lblPath);
        lblFileName = new JLabel("File Name");
        add(lblFileName);
        lblSize = new JLabel("Size");
        add(lblSize);
        lblCreationDate = new JLabel("Creation Date");
        add(lblCreationDate);
        lblModificationDate = new JLabel("Modification Date");
        add(lblModificationDate);
        //LabelsVideo search options
        lblVideoSearchTittle = new JLabel("CommonSearch Video");
        add(lblVideoSearchTittle);
        lblVideoFormat = new JLabel("Video Format");
        add(lblVideoFormat);
        lblFrameRate = new JLabel("Frame Rate");
        add(lblFrameRate);
        lblResolution = new JLabel("Resolution");
        add(lblResolution);
        lblAudio = new JLabel("Audio");
        add(lblAudio);
        //lblAudio search options
        lblAurioSearchTittle = new JLabel("Specific audio search");
        add(lblAurioSearchTittle);
        lblAudioChanel = new JLabel("Audio chanel");
        add(lblAudioChanel);
        lblAudioFileFormat = new JLabel("Audio File Format");
        add(lblAudioFileFormat);
        //Init and adds Texts Fields
        txtFldPath = new JTextField();
        add(txtFldPath);
        txtFldFileName = new JTextField();
        add(txtFldFileName);
        txtFldSize = new JTextField();
        add(txtFldSize);
        txtFldCreationDate = new JTextField();
        add(txtFldCreationDate);
        txtFldModificationDate = new JTextField();
        add(txtFldModificationDate);
        //Init and adds Texts Fields Video search
        txtFldFrameRate = new JTextField();
        add(txtFldFrameRate);
        txtFldVideoFormat = new JTextField();
        add(txtFldVideoFormat);
        txtFldResolution = new JTextField();
        add(txtFldResolution);
        //Init and adds combo box
        comboSize = new JComboBox();
        add(comboSize);
        comboAudioChanel = new JComboBox();
        add(comboAudioChanel);
        comboAudioFileFormat = new JComboBox();
        add(comboAudioFileFormat);
        ////Init and adds check box
        chxNo = new JCheckBox("No");
        add(chxNo);
        chxYes = new JCheckBox("Yes");
        add(chxYes);
        //Init button
        btnPlayer = new JButton("Player");
        add(btnPlayer);
        btnSearchFile = new JButton("Path");
        add(btnSearchFile);
    }

    /**
     * This method init all settings like position, size and width
     */
    public void initSetting() {
        //positions to align labels textFields checkBoxes comboBoxes
        positionOneX = 10; //First column position for labels
        positionTwoX = 180;//Second column position for textField or comboBox
        positionThreeX = 300;//Third column position for button or comboBox
        //General search labels positions
        lblSearch.setBounds(positionOneX, 23, 62, 27);
        lblPath.setBounds(positionOneX, 56, 51, 27);
        lblFileName.setBounds(positionOneX, 86, 90, 27);
        lblSize.setBounds(positionOneX, 120, 40, 20);
        lblCreationDate.setBounds(positionOneX, 150, 160, 20);
        lblModificationDate.setBounds(positionOneX, 180, 160, 20);
        //Video search label positions
        lblVideoSearchTittle.setBounds(positionOneX, 210, 100, 20);
        lblVideoFormat.setBounds(positionOneX, 240, 100, 20);
        lblResolution.setBounds(positionOneX, 270, 100, 20);
        lblFrameRate.setBounds(positionOneX, 300, 100, 20);
        lblAudio.setBounds(positionOneX, 330, 100, 20);
        //General search textFields positions
        txtFldPath.setBounds(positionTwoX, 59, 200, 20);
        txtFldFileName.setBounds(positionTwoX, 90, 86, 20);
        txtFldSize.setBounds(positionTwoX, 120, 86, 20);
        txtFldCreationDate.setBounds(positionTwoX, 150, 60, 20);
        txtFldModificationDate.setBounds(positionTwoX, 180, 60, 20);
        //Video search text fields positions
        txtFldFrameRate.setBounds(positionTwoX, 300, 100, 20);
        txtFldVideoFormat.setBounds(positionTwoX, 240, 100, 20);
        txtFldResolution.setBounds(positionTwoX, 270, 100, 20);
        //Video search text fields positions
        lblAurioSearchTittle.setBounds(positionOneX, 350, 170, 20);
        lblAudioChanel.setBounds(positionOneX, 380, 100, 20);
        lblAudioFileFormat.setBounds(positionOneX, 410, 100, 20);
        //text inside "TextFields"
        //txtFldPath.setText("...");
        txtFldFileName.setText("...");
        txtFldSize.setText("...");
        txtFldCreationDate.setText("...");
        txtFldModificationDate.setText("...");
        //comboBoxes positions
        comboSize.setBounds(positionThreeX, 120, 45, 20);
        comboAudioChanel.setBounds(positionTwoX, 380, 60, 20);
        comboAudioFileFormat.setBounds(positionTwoX, 410, 60, 20);
        //check boxs positions
        chxYes.setBounds(positionTwoX, 330, 60, 25);
        chxNo.setBounds(240, 330, 60, 25);
        //Button position and init action click
        ActionPlayButton.clickAction(btnPlayer);
        btnPlayer.setBounds(500, 56, 70, 25);
        findPath(btnSearchFile);
        btnSearchFile.setBounds(400, 56, 70, 25);
    }

    /**
     * This method set the path to txtFldPath
     */
    public void findPath(JButton btnSearchFile) {
        btnSearchFile.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                JFileChooser pathChooser = new JFileChooser();
                pathChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnPath = pathChooser.showOpenDialog(null);
                if (returnPath == JFileChooser.APPROVE_OPTION) {
                    txtFldPath.setText(pathChooser.getSelectedFile().getPath());
                }
            }
        });
    }

    /**
     * This method get the path from txtFldPath
     */
    public String getPath() {
        pathAddress = txtFldPath.getText();
        return pathAddress;
    }
}
