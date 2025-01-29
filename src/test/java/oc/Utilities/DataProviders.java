package oc.Utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws Exception {
		
			String path = ".\\testData\\OC_Testdata.xlsx";
			
			ExcelUtility xcelutil = new ExcelUtility(path);
			
			int rowscount = xcelutil.getRowCount("Sheet1");
			int colscount = xcelutil.getCellCount("Sheet1", 1);
			String logindata[][] = new String[rowscount][colscount];
			
			for(int i=1;i<=rowscount;i++) {
				for(int j=0;j<colscount;j++) {
					logindata[i-1][j] = xcelutil.getCellData("Sheet1", i, j);
				}
			}
			return logindata;
	}

}
