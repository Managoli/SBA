package com.cognizant.cleartrip.Utilits;


import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtils {
	
	private static HSSFWorkbook ExcelWBook;
	private static HSSFSheet ExcelWSheet;
	private static HSSFCell cell;
	private static HSSFRow row;
	
	//This method is to set the File path and open the TestData.xls
	public static void setExcelFile(String path, String SheetName) throws Exception{
		
		try{
			FileInputStream ExcelFile = new FileInputStream(path);
			ExcelWBook = new HSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			
		}catch(Exception e)
		{
			throw(e);
		}		
	}
	
	// This method is to read the test data from excel, in this we are passing Row and Column as parameters 
	public static String getCellData(int rowNum,int colNum){
		
		try{
			cell = ExcelWSheet.getRow(rowNum).getCell(colNum);
			String cellData = cell.getStringCellValue();
			return cellData;
		}catch (Exception e){
			return "";
		}	
	}
	// This method is to write the result data to excel and it takes row and column as parameters 
	public static void setCellData(String result,int rowNum, int colNum) throws Exception{
		
		try{
			row = ExcelWSheet.getRow(rowNum);
			cell = row.getCell(colNum,row.RETURN_BLANK_AS_NULL);
			if(cell == null){
				cell= row.createCell(colNum);
				cell.setCellValue(result);
			}else{
				cell.setCellValue(result);
			}
			// now set the values to excel sheet
			FileOutputStream  fileOut = new FileOutputStream(Constant.testFilePath + Constant.sheetName);
			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		}catch(Exception e){

			throw(e);
		}
	}
}
