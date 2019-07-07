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
    public Float bytesConvert(String bytesNumber, String unitConversion) {
        double unitBase = 1024;
        switch (unitConversion) {
            case "KB":
                return (float) (Double.parseDouble(bytesNumber) / unitBase);
            case "MB":
                return (float) ((Double.parseDouble(bytesNumber) / unitBase) / unitBase);
            case "GB":
                return (float) (((Double.parseDouble(bytesNumber) / unitBase) / unitBase)/ unitBase);
        }
        return null;
    }

    /**
     *This method from Kb, Mb and Gb to bytes.
     */
    public Float anyConvertBytes(String unitConversion, String numberToConvert) {
        double unitBase = 1024;
        double numberConvert = Double.parseDouble(numberToConvert);
        switch (unitConversion) {
            case "KB":
                return (float)(numberConvert * unitBase);
            case "MB":
                return (float)((numberConvert * unitBase) * unitBase);
            case "GB":
                return (float)(((numberConvert * unitBase) * unitBase) * unitBase);
        }
        return null;
    }
}
