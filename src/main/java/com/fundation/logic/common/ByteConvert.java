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
            case "Bytes":
                return Float.parseFloat(bytesNumber);
            case "KBytes":
                return (Float.parseFloat(bytesNumber) / unitBase);
            case "MBytes":
                return ((Float.parseFloat(bytesNumber) / unitBase) / unitBase);
            case "GBytes":
                return (((Float.parseFloat(bytesNumber) / unitBase) / unitBase)/ unitBase);
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
            case "Bytes":
                return numberConvert;
            case "KBytes":
                return (numberConvert * unitBase);
            case "MBytes":
                return ((numberConvert * unitBase) * unitBase);
            case "GBytes":
                return (((numberConvert * unitBase) * unitBase) * unitBase);
        }
        return null;
    }
}
