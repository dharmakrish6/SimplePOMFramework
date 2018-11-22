package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadCellValue {
	@SuppressWarnings("resource")
	public String getTestDataValue(String sheetName, String key) throws IOException {
		String datavalue = null;
		String excelFilePath = "testdata.xlsx";
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheet(sheetName);
		Iterator<Row> iterator = firstSheet.iterator();
		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				String cellv = cell.getStringCellValue();

				if (cellv.equalsIgnoreCase(key)) {
					cell = cellIterator.next();
					datavalue = cell.getStringCellValue();

				}
			}
		}
		return datavalue;
	}

	public static void main(String[] args) throws IOException {
		ReadCellValue rc = new ReadCellValue();
		System.out.println(rc.getTestDataValue("Books", "email"));
	}
}
