package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	public TestUtil() throws IOException {
		
	}
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	public void switchToframe(){
		driver.switchTo().frame("mainpanel");
	}
	
	public static String TESTDATA_SHEET_PATH="D:/Java_Tutorials/FreeCRMTest/src/main/java/com/crm/qa/testdata/testdata.xlsx";
	static Workbook book;
	static Sheet sheet;
	public static Object[][] getTestData(String sheetname) throws EncryptedDocumentException, IOException{
		FileInputStream file=null;
		try{
		 file=new FileInputStream(TESTDATA_SHEET_PATH);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		try{
		 book=WorkbookFactory.create(file);
		}
		catch(InvalidFormatException e){
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetname);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNum(); i++)
		{
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++){
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
		
	}
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileHandler.copy(scrFile, new File("D:\\seleniumscreenshot\\swaraj"+ System.currentTimeMillis() + ".png"));
//		File swaraj=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileHandler.copy(swaraj, new File("D:\\seleniumscreenshot\\swaraj.jpg"));
	}

}
