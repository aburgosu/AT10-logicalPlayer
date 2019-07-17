package com.fundation.logic.view;
/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class is in charge of displaying Path, filename and type information.
 *
 * @author Jesus Menacho
 * @version 1.0
 */
public class AdvancedAudioVideoPanelTest {

    @Test
    public void getComboBoxVideoCodec() {
        AdvancedAudioVideoPanel advancedAudioVideoPanel = new AdvancedAudioVideoPanel();
        String expected="MPEG-4";
        String actual=(String) advancedAudioVideoPanel.getComboBoxVideoCodec() .getSelectedItem();
        assertEquals(actual,expected);
    }

    @Test
    public void getComboBoxVideoFramerate() {
        AdvancedAudioVideoPanel advancedAudioVideoPanel = new AdvancedAudioVideoPanel();
        String expected="All";
        String actual=(String) advancedAudioVideoPanel.getComboBoxVideoFramerate() .getSelectedItem();
        assertEquals(actual,expected);
    }

    @Test
    public void getComboBoxResolution() {
        AdvancedAudioVideoPanel advancedAudioVideoPanel = new AdvancedAudioVideoPanel();
        String expected="1280x720";
        String actual=(String) advancedAudioVideoPanel.getComboBoxResolution() .getSelectedItem();
        assertEquals(actual,expected);
    }

    @Test
    public void getTextFieldDurationsSecond() {
        AdvancedAudioVideoPanel advancedAudioVideoPanel = new AdvancedAudioVideoPanel();
        String expected="";
        String actual=(String) advancedAudioVideoPanel.getTextFieldDurationsSecond() .getText();
        assertEquals(actual,expected);
    }

    @Test
    public void getTextFieldDurationFirst() {
        AdvancedAudioVideoPanel advancedAudioVideoPanel = new AdvancedAudioVideoPanel();
        String expected="";
        String actual=(String) advancedAudioVideoPanel.getTextFieldDurationFirst() .getText();
        assertEquals(actual,expected);
    }

    @Test
    public void getComboBoxAudioCodecName() {
        AdvancedAudioVideoPanel advancedAudioVideoPanel = new AdvancedAudioVideoPanel();
        String expected="MPEG";
        String actual=(String) advancedAudioVideoPanel.getComboBoxAudioCodecName() .getSelectedItem();
        assertEquals(actual,expected);
    }
}
