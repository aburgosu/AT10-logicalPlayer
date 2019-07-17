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

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class is in charge of displaying Path, filename and type information.
 *
 * @author Jesus Menacho
 * @version 1.0
 */
public class AdvancedAudioPanelTest {

    @Test
    public void getComboBoxAudioCodecName() {
        AdvancedAudioPanel advancedAudioPanel = new AdvancedAudioPanel();
        String expected="All";
        String actual=(String) advancedAudioPanel.getComboBoxAudioCodecName().getSelectedItem();
        assertEquals(actual,expected);
    }

    @Test
    public void getComboBoxAudioChannel() {
        AdvancedAudioPanel advancedAudioPanel = new AdvancedAudioPanel();
        String expected="All";
        String actual=(String) advancedAudioPanel.getComboBoxAudioChannel().getSelectedItem();
        assertEquals(actual,expected);
    }

    @Test
    public void getComboBoxAudioSampleRate() {
        AdvancedAudioPanel advancedAudioPanel = new AdvancedAudioPanel();
        String expected="All";
        String actual=(String) advancedAudioPanel.getComboBoxAudioSampleRate().getSelectedItem();
        assertEquals(actual,expected);
    }

    @Test
    public void getTextFieldDurationFirst() {
        AdvancedAudioPanel advancedAudioPanel = new AdvancedAudioPanel();
        String expected="";
        String actual=advancedAudioPanel.getTextFieldDurationFirst().getText();
        assertEquals(actual,expected);
    }
}