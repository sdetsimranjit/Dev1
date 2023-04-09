package AutoPack1;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DataDrivenTest {
    public static void main(String[] args) throws IOException {
        File src = new File("D:\\Test.xlsx");
        FileInputStream fis = new FileInputStream(src);
        XSSFWorkbook xsf = new XSSFWorkbook(fis);
        XSSFSheet sheet = xsf.getSheet("Sheet1");
        String data;
        double intdata;
        int row_count = sheet.getPhysicalNumberOfRows(); //counting the Number of rows
        XSSFRow row = sheet.getRow(0);
        int col_count = row.getPhysicalNumberOfCells();
        data = sheet.getRow(0).getCell(0).getStringCellValue();
        System.out.println("The value of cell 00 is:: " + data);
        data = sheet.getRow(0).getCell(1).getStringCellValue();
        System.out.println("The value of cell 01 is:: " + data);
        intdata = sheet.getRow(1).getCell(0).getNumericCellValue();
        System.out.println("The value of cell 01 is:: " + intdata);
        intdata = sheet.getRow(1).getCell(1).getNumericCellValue();
        System.out.println("The value of cell 01 is:: " + intdata);




    }
}
