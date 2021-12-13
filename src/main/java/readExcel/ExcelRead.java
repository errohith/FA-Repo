package readExcel;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static String[][] readExcel(String FileName) throws IOException {
		// Path
		XSSFWorkbook wb = new XSSFWorkbook("./Data/"+FileName+".xlsx");

		XSSFSheet ws = wb.getSheet("Create");
		int rowCount = ws.getLastRowNum();
		short cellCount = ws.getRow(0).getLastCellNum();
		String[][] data = new String[rowCount][cellCount];
		for (int i = 1; i <= rowCount; i++) {

			for (int j = 0; j < cellCount; j++) {
				String cellValues = ws.getRow(i).getCell(j).getStringCellValue();
				data[i - 1][j] = cellValues;
			}

		}

		wb.close();
		return data;
	}

}
