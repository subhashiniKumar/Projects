package utilities;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReading { 
	public static Workbook wb;
	public static Sheet sh;
	
	
	public static void setupExcel(String path, String s) throws Exception
	{
		FileInputStream fis = new FileInputStream(path);
		wb = WorkbookFactory.create(fis);
		sh = wb.getSheet(s);
	}
	public static String getData(int row, int col)
	{
		String dataSet = sh.getRow(row).getCell(col).toString();
		return dataSet;
	}
}
