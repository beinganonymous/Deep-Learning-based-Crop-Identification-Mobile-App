package com.example.sih;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This program illustrates how to update an existing Microsoft Excel document.
 * Append new rows to an existing sheet.
 *
 * @author www.codejava.net
 *
 */
public class Excel {

    static String crop;
    public static void main() {
            String excelFilePath = "/storage/emulated/0/JavaBooks.xlsx";

        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            System.setProperty("org.apache.poi.javax.xml.stream.XMLInputFactory", "com.fasterxml.aalto.stax.InputFactoryImpl");
            System.setProperty("org.apache.poi.javax.xml.stream.XMLOutputFactory", "com.fasterxml.aalto.stax.OutputFactoryImpl");
            System.setProperty("org.apache.poi.javax.xml.stream.XMLEventFactory", "com.fasterxml.aalto.stax.EventFactoryImpl");
            Workbook workbook = WorkbookFactory.create(inputStream);

            Sheet sheet = workbook.getSheetAt(0);

            crop = MainActivity.result;

            Object[][] bookData = {
                    {crop, MainActivity.loc},

            };

            //byte[] bytes = IOUtils.toByteArray(inputStream1);
            //int pictureIdx = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
            int rowCount = sheet.getLastRowNum();
            /*inputStream.close();
//Returns an object that handles instantiating concrete classes
            CreationHelper helper = workbook.getCreationHelper();
//Creates the top-level drawing patriarch.
            Drawing drawing = sheet.createDrawingPatriarch();
//Create an anchor that is attached to the worksheet
            ClientAnchor anchor = helper.createClientAnchor();
            anchor.setCol1(1);
            anchor.setRow1(2);
//Creates a picture
            Picture pict = drawing.createPicture(anchor, pictureIdx);
//Reset the image to the original size
            pict.resize();
*/
            for (Object[] aBook : bookData) {
                Row row = sheet.createRow(++rowCount);

                int columnCount = 0;

                Cell cell = row.createCell(columnCount);
                cell.setCellValue(rowCount);

                for (Object field : aBook) {
                    cell = row.createCell(++columnCount);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    } else if (field instanceof Integer) {
                        cell.setCellValue((Integer) field);
                    }
                }

            }

            inputStream.close();

            FileOutputStream outputStream = new FileOutputStream("/storage/emulated/0/JavaBooks.xlsx");
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

        } catch (IOException | EncryptedDocumentException
                | InvalidFormatException ex) {
            ex.printStackTrace();
        }
    }

}
