package DataDriven.Data_testing;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datadriventesting {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("C:\\Users\\forou\\Downloads\\seleniumAutomation.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		int sheets = wb.getNumberOfSheets();
		System.out.println(sheets);

		for (int i = 0; i < sheets; i++) {
			if (wb.getSheetName(i).equalsIgnoreCase("Data1")) {
				XSSFSheet sheet = wb.getSheetAt(i);

				Iterator<Row> row = sheet.iterator();
				Row firstrow = row.next();
				Iterator<Cell> ce = firstrow.iterator();
				int k = 0;
				int column = 0;
				while (ce.hasNext()) {

					Cell value = ce.next();
//		System.out.println(value);
					if (value.getStringCellValue().equalsIgnoreCase("Testcases")) {
						column = k;
					}
					k++;
				}
				System.out.println(column);
				while (row.hasNext()) {
					Row r = row.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase("Login")) {
						Iterator<Cell> cv = r.cellIterator();
	
					while(cv.hasNext()) {
					System.out.println(cv.next().getStringCellValue());
				}
				}
					
				}
			}

		}
	}
}
