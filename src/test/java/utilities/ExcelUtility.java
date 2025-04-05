package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtility {
    
    private String path;

    public ExcelUtility(String path) {
        this.path = path;
    }

    public int getRowCount(String sheetName) throws IOException {
        FileInputStream fi = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fi);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        int rowcount = (sheet == null) ? 0 : sheet.getLastRowNum();
        workbook.close();
        fi.close();
        return rowcount;
    }

    public int getCellCount(String sheetName, int rownum) throws IOException {
        FileInputStream fi = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fi);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        XSSFRow row = (sheet == null) ? null : sheet.getRow(rownum);
        int cellcount = (row == null) ? 0 : row.getLastCellNum();
        workbook.close();
        fi.close();
        return cellcount;
    }

    public String getCellData(String sheetName, int rownum, int colnum) throws IOException {
        FileInputStream fi = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fi);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        XSSFRow row = (sheet == null) ? null : sheet.getRow(rownum);
        if (row == null) {
            workbook.close();
            fi.close();
            return "";
        }
        XSSFCell cell = row.getCell(colnum);
        DataFormatter formatter = new DataFormatter();
        String data = (cell == null) ? "" : formatter.formatCellValue(cell);
        workbook.close();
        fi.close();
        return data;
    }

    public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException {
        File xlfile = new File(path);
        if (!xlfile.exists()) {
            XSSFWorkbook workbook = new XSSFWorkbook();
            FileOutputStream fo = new FileOutputStream(path);
            workbook.write(fo);
            workbook.close();
            fo.close();
        }

        FileInputStream fi = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fi);
        fi.close();

        if (workbook.getSheetIndex(sheetName) == -1)
            workbook.createSheet(sheetName);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        if (sheet.getRow(rownum) == null)
            sheet.createRow(rownum);
        XSSFRow row = sheet.getRow(rownum);
        XSSFCell cell = row.createCell(colnum);
        cell.setCellValue(data);

        FileOutputStream fo = new FileOutputStream(path);
        workbook.write(fo);
        workbook.close();
        fo.close();
    }

    public void fillColor(String sheetName, int rownum, int colnum, IndexedColors color) throws IOException {
        FileInputStream fi = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fi);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        XSSFRow row = (sheet == null) ? null : sheet.getRow(rownum);
        if (row == null) {
            workbook.close();
            fi.close();
            return;
        }
        XSSFCell cell = row.getCell(colnum);
        if (cell == null) {
            workbook.close();
            fi.close();
            return;
        }

        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(color.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(style);

        fi.close();
        FileOutputStream fo = new FileOutputStream(path);
        workbook.write(fo);
        workbook.close();
        fo.close();
    }

    public void fillGreenColor(String sheetName, int rownum, int colnum) throws IOException {
        fillColor(sheetName, rownum, colnum, IndexedColors.GREEN);
    }

    public void fillRedColor(String sheetName, int rownum, int colnum) throws IOException {
        fillColor(sheetName, rownum, colnum, IndexedColors.RED);
    }
}
