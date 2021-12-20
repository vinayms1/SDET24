package com.vtiger.genericLibrary;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtile {
	/**
	 * Get the data from excel file
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return return the value which is present in the excel file
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 * @throws Throwable 
	 * @throws Throwable
	 */
	public String getExcelValue(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException, Throwable  {
		FileInputStream fis=new FileInputStream("C:\\Users\\Vinay\\eclipse-workspace\\SDET24\\src\\test\\resources\\data\\Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return data;
	}
}
