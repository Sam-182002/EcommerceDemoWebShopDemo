package com.tricentis.generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	public String readPropertyData(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./testdata/commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		return data;
	}
	public String readExcelData(String sheetname,int rowIndex, int cellIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./testdata/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetname).getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		return data;
	}
	public void writeDataIntoExcel(String sheetName,int rowIndex,int cellIndex,String value) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./testdata/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowIndex).createCell(cellIndex).setCellValue(value);
		FileOutputStream fos= new FileOutputStream("./testdata/testscript.xlsx");
		wb.write(fos);
		wb.close();
	}

}
