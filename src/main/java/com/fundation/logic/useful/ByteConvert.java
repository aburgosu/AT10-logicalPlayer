/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.useful;

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
    public String bytesConvert(String bytesNumber, String unitConversion) {
        double unitBase = 1024;
        switch (unitConversion) {
            case "KB":
                return Double.toString(Double.parseDouble(bytesNumber) / unitBase);
            case "MB":
                return Double.toString((Double.parseDouble(bytesNumber) / unitBase) / unitBase);
            case "GB":
                return Double.toString(((Double.parseDouble(bytesNumber) / unitBase) / unitBase) / unitBase);
        }
        return null;
    }

    /**
     *This method from Kb, Mb and Gb to bytes.
     */
    public String anyConvertBytes(String unitConversion, String numberToConvert) {
        double unitBase = 1024;
        double numberConvert = Double.parseDouble(numberToConvert);
        switch (unitConversion) {
            case "KB":
                return Double.toString(numberConvert * unitBase);
            case "MB":
                return Double.toString((numberConvert * unitBase) * unitBase);
            case "GB":
                return Double.toString(((numberConvert * unitBase) * unitBase) * unitBase);
        }
        return null;
    }
}
