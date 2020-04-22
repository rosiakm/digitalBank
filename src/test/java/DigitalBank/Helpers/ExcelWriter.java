package DigitalBank.Helpers;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelWriter
{
    public static void excelWriter(List<String> dataList, File file) throws IOException
    {
        FileInputStream stream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(stream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Row nextRow = sheet.createRow(sheet.getLastRowNum()+1);
        for(int i = 0; i < dataList.size(); i++)
        {
            nextRow.createCell(i).setCellValue(dataList.get(i));
        }

        FileOutputStream outputStream = new FileOutputStream("loginBase.xlsx");
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
