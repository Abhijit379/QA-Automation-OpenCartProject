package utilities;
import java.io.IOException;

import org.testng.annotations.DataProvider;
public class DataProviders {
	
	@DataProvider(name = "LoginData")
	public String[][] logindata() throws IOException {
		String filename = ".\\testData\\testdatalogin.xlsx";
		String sheet ="Sheet1";
		ExcelUtilities ex = new ExcelUtilities();
		int rows =ex.getrows(filename, sheet);
		int cnt=0;
		int column = ex.getcell(filename, sheet, 1);
		String[][] data = new String[rows][column];
		for (int i = 1; i <= rows; i++) {
			cnt++;
			for (int j = 0; j < column; j++) {
				data[i-1][j] = ex.getdata(filename, sheet, i, j);
//				System.out.println(data[i][j]);
			}
		}
		System.out.println(cnt);
		return data;
		
		
	}

}
