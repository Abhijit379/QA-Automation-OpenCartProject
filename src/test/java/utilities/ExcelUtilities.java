package utilities;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.AddHasCasting;

public class ExcelUtilities {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	
	public int getrows(String filename, String sheetname) throws IOException {
		
		fi = new FileInputStream(filename);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(sheetname);
		int rowcnt = sheet.getLastRowNum();
		wb.close();
		fi.close();
		return rowcnt;
		
	}
	public int getcell(String filename, String sheetname ,int ro) throws IOException {
		fi = new FileInputStream(filename);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(sheetname);
		row = sheet.getRow(ro);
		int cel =  row.getLastCellNum();
		return cel;
		
	}
	public String getdata(String filename,String sheetname,int ro,int cell) throws IOException {
		
		fi = new FileInputStream(filename);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(sheetname);
		row = sheet.getRow(ro);
		this.cell = row.getCell(cell);
		String data;
		try {
			data = this.cell.toString();
		} catch (Exception e) {
			data="";
		}
		return data;
		
	}

}
