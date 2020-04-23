package DigitalBank.Helpers;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader
{
    public static List<Data> logData = new ArrayList<>();

    public static List<Data> excelReader(File file) throws IOException
    {
        DataFormatter formatter = new DataFormatter();

        FileInputStream stream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(stream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Row row = sheet.getRow(1);
        int cellsNumber = sheet.getRow(0).getLastCellNum();

        for (int i = 0; i <= cellsNumber; i++ )
        {
            logData.add(new Data(formatter.formatCellValue(row.getCell(0)),
                                 formatter.formatCellValue(row.getCell(1))));
        }

        return logData;
    }
}
