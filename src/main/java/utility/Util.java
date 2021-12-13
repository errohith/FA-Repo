package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import customerServiceTestCases.*;

public class Util {
	
	static List<String> winList;
	static Set<String> windows;
	String[][] data;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	FileInputStream fs;
	int lastRowNum,lastColNum;
	
	public static String getDownloadedFileName() {
		
		File file = new File(S011072_DownloadPDF.downloadPath);
		String[] fileList = file.list();
		return fileList[0];
	}
	
	public static String getLastWindow(WebDriver driver) {
		windows=driver.getWindowHandles();
		winList= new ArrayList<String>();
		winList.addAll(windows);
		System.out.println(winList.size());
		return (winList.get(winList.size()-1));
	}
	
	public String[][] readExcel(String fileName, String sheetName) {
		
		try {
			fs = new FileInputStream(new File(".\\TestData\\"+fileName+".xlsx"));
			wb = new XSSFWorkbook(fs);
			sheet=wb.getSheet(sheetName);
			lastRowNum = sheet.getLastRowNum();
			lastColNum = sheet.getRow(0).getLastCellNum();
			data = new String[lastRowNum][lastColNum];
			for(int i=1;i<=lastRowNum;i++ ) {
				for(int j=0;j<lastColNum;j++) {
					if(sheet.getRow(i).getCell(j).getCellType()==CellType.NUMERIC)
					{
						data[i-1][j]=Double.toString(sheet.getRow(i).getCell(j).getNumericCellValue());	
					}
					else {
						data[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
					}
				}
			}	
			wb.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}
