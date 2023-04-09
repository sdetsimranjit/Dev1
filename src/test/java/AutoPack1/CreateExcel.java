package AutoPack1;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateExcel {
    static String filename;
    static XSSFWorkbook workbook;
    static XSSFSheet sheet1;
    static XSSFRow rowhead;
    public static void main(String[] args) throws IOException {
        System.out.println("This is test");
        filename = "D:\\new5.xlsx";
        //creating an instance of HSSFWorkbook class
        workbook = new XSSFWorkbook();
        //invoking creatSheet() method and passing the name of the sheet to be created
        sheet1 = workbook.createSheet("January");
        rowhead = sheet1.createRow((short) 0);  //creating the 0th row using the createRow() method
        rowhead.createCell(0).setCellValue("S.No.");
        rowhead.createCell(1).setCellValue("TestCaseID");
        rowhead.createCell(2).setCellValue("Scenario");
        rowhead.createCell(3).setCellValue("Actual");
        // closing the workbook
        FileOutputStream fileOut = new FileOutputStream(filename);
        workbook.write(fileOut);
        //closing the Stream
        fileOut.close();
        //closing the workbook
        workbook.close();
        System.out.println("Excel file has been generated successfully.");
    }
}
