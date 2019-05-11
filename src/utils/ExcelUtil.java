package utils;

import java.io.FileInputStream;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


public class ExcelUtil 
{ 
	
	private  Workbook wb =null;
	
	public ExcelUtil(String excelFile) throws Exception 
	{
		
		FileInputStream fs = new FileInputStream(excelFile);
		 wb = Workbook.getWorkbook(fs);	
		
		
	}
	
	
	public String reder(int col,int row)
	{
		
		Sheet sheet=wb.getSheet(0);
		Cell cell = sheet.getCell(col, row);
		return cell.getContents();
				
	}
	public int getTotalRows(int sheetNo)
	{
		Sheet sheet=wb.getSheet(0);
		return sheet.getRows();
		
	}
	public int getTotalColumn(int sheetNo)
	{
		Sheet sheet=wb.getSheet(0);
		return sheet.getColumns();
		
	}
	



}
