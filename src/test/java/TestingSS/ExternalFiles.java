package TestingSS;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.*;


public class ExternalFiles {

   @Test
    public void InputDataExcel() {


        try {

            String ExcelPath = System.getProperty("user.dir");
            XSSFWorkbook Workbook = new XSSFWorkbook(ExcelPath + "/ExcelFile/WorkbookMavenProject.xlsx");
            XSSFSheet SheetName = Workbook.getSheet("Sheet1");
            int rowcount = SheetName.getLastRowNum()-SheetName.getFirstRowNum();
            System.out.println("Number of rows are " + rowcount);

                    String CellUserName = SheetName.getRow(1).getCell(0).getStringCellValue();

                    String CellPassword = SheetName.getRow(1).getCell(1).getStringCellValue();

                    System.out.println("User Name is " + CellUserName);
                    System.out.println("Password is " + CellPassword);


        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("CAUSE " + e.getCause());


        }

    }
}




