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

/**
 * Implements FileInfo abstract class which is used to get file details.
 *
 * @author Jesus Menacho
 * @version 1.0
 */
public class ByteConvert {

    /**
     *This method convert byte to Kb, Mb and Gb.
     */
    public static Float bytesConvert(String bytesNumber, String unitConversion) {
        Float unitBase = 1024F;
        switch (unitConversion) {
            case "KBytes":
                return Math.round((Float.parseFloat(bytesNumber) / unitBase) * 100 )/100f;
            case "MBytes":
                return Math.round(((Float.parseFloat(bytesNumber) / unitBase) / unitBase)*100)/100f;
            case "GBytes":
                return Math.round((((Float.parseFloat(bytesNumber) / unitBase) / unitBase)/ unitBase)*100)/100f;
        }
        return null;
    }

    /**
     *This method from Kb, Mb and Gb to bytes.
     */
    public static Float anyConvertBytes(String unitConversion, String numberToConvert) {
        Float unitBase = 1024F;
        Float numberConvert = Float.parseFloat(numberToConvert);
        switch (unitConversion) {
            case "KBytes":
                return Math.round((numberConvert * unitBase)*100)/100f;
            case "MBytes":
                return Math.round(((numberConvert * unitBase) * unitBase)*100)/100f;
            case "GBytes":
                return Math.round((((numberConvert * unitBase) * unitBase) * unitBase)*100)/100f;
        }
        return null;
    }
}
