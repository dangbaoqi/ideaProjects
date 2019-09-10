package excel;


import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import java.io.File;
import java.io.FileInputStream;

/**
 * POI解析Excel
 */
public class POIReadExcelTest {


    public static void main(String[] args) throws Exception {

        //读取本地文件
        File file = new File("E:/test.xls");
        FileInputStream fis = new FileInputStream(file);
        HSSFWorkbook workbook = new HSSFWorkbook(fis);
        HSSFSheet sheet1 = workbook.getSheetAt(0);
        //获取当前sheet页的总行数
        int totalRowNums = sheet1.getPhysicalNumberOfRows();
        for (int i = 0; i < totalRowNums; i++) {
            Row row = sheet1.getRow(i);
            //获取每一行的总列数
            int totalCellNums = row.getPhysicalNumberOfCells();
            for (int j = 0; j < totalCellNums; j++) {
                Cell cell = row.getCell(j);
                String value = getCellValue(cell);
                System.out.println(value);
            }
        }
    }

    public static String getCellValue(Cell cell) {
        if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(cell.getBooleanCellValue());
        } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            Double d = cell.getNumericCellValue();
            return String.valueOf(d.intValue());
        }
        return String.valueOf(cell.getStringCellValue());
    }
}