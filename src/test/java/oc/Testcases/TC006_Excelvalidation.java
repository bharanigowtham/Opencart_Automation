package oc.Testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class TC006_Excelvalidation {
	
	@Test
	public void ExceltoExcelcomparison() throws Exception {
		
		String excelfilepath1="C:\\Workspace\\MyAutomation\\Ecommerce_Opencart2\\testData\\Excelread1.xlsx";
		String excelfilepath2="C:\\Workspace\\MyAutomation\\Ecommerce_Opencart2\\testData\\Excelread2.xlsx";
		
		File file1 = new File(excelfilepath1);
		File file2 = new File(excelfilepath2);
		
		FileInputStream inputstream1 = new FileInputStream(file1);
		FileInputStream inputstream2 = new FileInputStream(file2);
		
		XSSFWorkbook workbook1 = new XSSFWorkbook(inputstream1);
		XSSFWorkbook workbook2 = new XSSFWorkbook(inputstream2);
		
		XSSFSheet sheet1 = workbook1.getSheetAt(0);
		XSSFSheet sheet2 = workbook2.getSheetAt(0);
		
		String riderPlanamountFinal1 = null;
		String riderPlanfrequncyFinal1 = null;
		String MainplancurrentpremiumamountFinal1 = null;
		String MainplancurrentpremiumFrequencyFinal1 = null;
		String RiderplancurrentpremiumAmountFinal1 = null;
		String RiderplancurrentpremiumFreqFinal1 = null;
		String RiderplanNewpremiumAmountFinal1 = null;
		String RiderplanNewpremiumFreqFinal1 = null;
		String CurrentTotalPremiumAmountFinal1 = null;
		String CurrentTotalPremiumFreqFinal1 = null;
		String NewTotalPremiumAmountFinal1 = null;
		String NewTotalPremiumFreqFinal1 = null;
		
		int sheet1lastrownum = sheet1.getLastRowNum();
		System.out.println("sheet1lastrownum = " + sheet1lastrownum);
		XSSFCellStyle style = workbook1.createCellStyle();

		for(int i=1;i<sheet1lastrownum;i++) {
			try {
				Row row1 = sheet1.getRow(i);
				Cell cell = row1.getCell(2);
				String Polno1 = cell.getStringCellValue();
				String Polno1_trim = Polno1.trim();
				System.out.println("Policy no from sheet1 = " + Polno1_trim);
				
				if(Polno1.equals(null) || Polno1.isEmpty() || Polno1.isBlank() || Polno1.equals("")) {
					break;
				}
				
				try {
				Cell riderplanamt = row1.getCell(6);
				String riderplanamtvalue = riderplanamt.getStringCellValue();
					if(riderplanamtvalue!=null && !riderplanamtvalue.isEmpty() && riderplanamtvalue != "") {
						String riderplanamtnew  = riderplanamtvalue.substring(2);
						String[] riderplanamtnewArr = riderplanamtnew.split(" ");
						riderPlanamountFinal1 = riderplanamtnewArr[0].replace(",", "");
						riderPlanfrequncyFinal1 = riderplanamtnewArr[1];
				}
				}
				catch(Exception e) {
					
				}
				
				
				try {
					Cell Mainplancurrentpremium = row1.getCell(7);
					String getMainplancrntprm = Mainplancurrentpremium.getStringCellValue();
					if(getMainplancrntprm != null && !getMainplancrntprm.isEmpty() && getMainplancrntprm != "") {
						String subMainplancurPremium = getMainplancrntprm.substring(2);
						String[] MainplancrntpremArr = subMainplancurPremium.split(" ");
						MainplancurrentpremiumamountFinal1 = MainplancrntpremArr[0].replace(",", "");
						MainplancurrentpremiumFrequencyFinal1 = MainplancrntpremArr[1];
					}
					
				}
				catch(Exception e) {
					
				}
				
				
				try {
					Cell Riderplancurrentpremium = row1.getCell(9);
					String Rpcp = Riderplancurrentpremium.getStringCellValue();
					if(Rpcp != null && !Rpcp.isEmpty() && Rpcp != "") {
						String subRpcp = Rpcp.substring(2);
						String[] RpcpArr = subRpcp.split(" ");
						RiderplancurrentpremiumAmountFinal1 = RpcpArr[0].replace(",", "");
						RiderplancurrentpremiumFreqFinal1 = RpcpArr[1];
					}
					
				}
				catch(Exception e) {

				}
				
				
				try {
					Cell RiderplanNewp1emium = row1.getCell(10);
					String RpNp = RiderplanNewp1emium.getStringCellValue();
					if(RpNp != null && !RpNp.isEmpty() && RpNp != "") {
						String subRpNp = RpNp.substring(2);
						String[] RpnpArr = subRpNp.split(" ");
						RiderplanNewpremiumAmountFinal1 = RpnpArr[0].replace(",", "");
						RiderplanNewpremiumFreqFinal1 = RpnpArr[1];
					}
					
				} 
				catch(Exception e) {
					
				}
				
				
				try {
					Cell CurrentTotalPremium = row1.getCell(11);
					String CTP = CurrentTotalPremium.getStringCellValue();
					if(CTP!=null && !CTP.isEmpty() && CTP !="") {
						String subCTP = CTP.substring(2);
						String[] CTPArr = subCTP.split(" ");
						CurrentTotalPremiumAmountFinal1 = CTPArr[0].replace(",", "");
						CurrentTotalPremiumFreqFinal1 = CTPArr[1];
					}
					
				}
				catch(Exception e) {
					
				}
				
				try {
					Cell NewTotalPremium = row1.getCell(12);
					String NTP = NewTotalPremium.getStringCellValue();
					if(NTP!=null && !NTP.isEmpty() && NTP !="") {
						String subNTP = NTP.substring(2);
						String[] NTPArr = subNTP.split(" ");
						NewTotalPremiumAmountFinal1 = NTPArr[0].replace(",", "");
						NewTotalPremiumFreqFinal1 = NTPArr[1];
					}
				}
				catch(Exception e) {
					
				}
				
				String CP_final = null;
				String NP_final = null;
				String CP03_final = null;
				String NP03_final = null;
				String CP02_final = null;
				String NP02_final = null;
				
				int sheet2totalrows = sheet2.getLastRowNum();
				//System.out.println("Sheet2totalrows = "+sheet2totalrows);
//				System.out.println("sheet2totalrows = "+sheet2totalrows);

				loopInSheet2:
				for(int j=1;j<=sheet2totalrows;j++) {
					Row row2 = sheet2.getRow(j);
					Cell cell2 = row2.getCell(0);
					String Polno2 = cell2.getStringCellValue();
					String Polno2_trim = Polno2.trim();
					//System.out.println("Policy no from sheet2 = " + Polno2_trim);
					if(Polno1_trim.equals(Polno2_trim)) 
					{
						System.out.println("Policy number matched " + Polno1_trim + " & " + Polno2_trim);
						
						// 1- Rider plan
						try 
						{
						Cell CURRENT_PREMIUM = row2.getCell(6);
						String CP = CURRENT_PREMIUM.getStringCellValue();
						CP_final = CP.trim();
						if(riderPlanamountFinal1.equals(CP_final)) 
						  {
							//System.out.println("RIDER PREMIUM MATCHED");
						/*	Cell cr_cell = row1.createCell(26);
							style.setFillBackgroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
							style.setFillPattern(FillPatternType.FINE_DOTS);
							cr_cell.setCellValue('\u2713' + " RIDER PREMIUM MATCHED|RIDER PREMIUM1 = " + riderPlanamountFinal1 + " RIDER PREMIUM2 = " + CURRENT_PREMIUM + " for the policy no " + Polno1);
							cr_cell.setCellStyle(style);
							FileOutputStream fos = new FileOutputStream(file1);
							workbook1.write(fos);	*/
							}
						else {
							Cell cr_cell = row1.createCell(26);
							style.setFillBackgroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
							style.setFillPattern(FillPatternType.FINE_DOTS);
							cr_cell.setCellValue("X Rider Premium NOT Matched X |RIDER PREMIUM1 = " + riderPlanamountFinal1 + " RIDER PREMIUM2 = " + CURRENT_PREMIUM + " for the policy no " + Polno1);
							cr_cell.setCellStyle(style);
							FileOutputStream fos = new FileOutputStream(file1);
							workbook1.write(fos);
						}
						
						}
						catch(Exception e) {
							
						}	
						
						//2 -Main plan current premium
						try {
							Cell NEW_PREMIUM = row2.getCell(8);
							String NP = NEW_PREMIUM.getStringCellValue();
							NP_final = NP.trim();
							if(MainplancurrentpremiumamountFinal1.equals(NP_final)) 
							{
								//System.out.println(MainplancurrentpremiumamountFinal1);
								//System.out.println("MAIN PLAN CURRENT PREMIUM MATCHED");
						/*		Cell cr_cell = row1.createCell(27);
								style.setFillBackgroundColor(IndexedColors.BRIGHT_GREEN1.getIndex());
								style.setFillPattern(FillPatternType.FINE_DOTS);
								cr_cell.setCellValue('\u2713' + " Main plan current premium matched: Premium1 =  "+ MainplancurrentpremiumamountFinal1 + " & Premium 2 = "+ NP_final + " for "+ Polno1);
								cr_cell.setCellStyle(style);
								FileOutputStream fos = new FileOutputStream(file1);
								workbook1.write(fos); */
							}
							else {
								Cell cr_cell = row1.createCell(27);
								style.setFillBackgroundColor(IndexedColors.BRIGHT_GREEN1.getIndex());
								style.setFillPattern(FillPatternType.FINE_DOTS);
								cr_cell.setCellValue("X  Main plan current NOT premium matched X: Premium1 =  "+ MainplancurrentpremiumamountFinal1 + " & Premium 2 = "+ NP_final + " for "+ Polno1);
								cr_cell.setCellStyle(style);
								FileOutputStream fos = new FileOutputStream(file1);
								workbook1.write(fos);
							}
						}
						catch(Exception e) {
							
						}
						
						// 3- Rider plan Current Premium
						try {
							Cell CURRENT_PREMIUM_03 = row2.getCell(19);
							String CP03 = CURRENT_PREMIUM_03.getStringCellValue();
							CP03_final = CP03.trim();
							if(RiderplancurrentpremiumAmountFinal1.equals(CP03_final)) 
							{
							/*	Cell cr_cell = row1.createCell(28);
								style.setFillBackgroundColor(IndexedColors.BRIGHT_GREEN1.getIndex());
								style.setFillPattern(FillPatternType.FINE_DOTS);
								cr_cell.setCellValue('\u2713' +" Rider plan current premium matched: Premium1 =  "+ RiderplancurrentpremiumAmountFinal1 + " & Premium 2 = "+ CP03_final + " for "+ Polno1);
								cr_cell.setCellStyle(style);
								FileOutputStream fos = new FileOutputStream(file1);
								workbook1.write(fos); */
							}
							else {
								Cell cr_cell = row1.createCell(28);
								style.setFillBackgroundColor(IndexedColors.BRIGHT_GREEN1.getIndex());
								style.setFillPattern(FillPatternType.FINE_DOTS);
								cr_cell.setCellValue(" X Rider plan current premium NOT matched X: Premium1 =  "+ RiderplancurrentpremiumAmountFinal1 + " & Premium 2 = "+ CP03_final + " for "+ Polno1);
								cr_cell.setCellStyle(style);
								FileOutputStream fos = new FileOutputStream(file1);
								workbook1.write(fos);
							}
						}
						catch(Exception e) {
							
						}
						
						// 4- Rider plan New Premium
						try {
							Cell NEW_PREMIUM_03 = row2.getCell(17);
							String NP03 = NEW_PREMIUM_03.getStringCellValue();
							NP03_final = NP03.trim();
							if(RiderplanNewpremiumAmountFinal1.equals(NP03_final)) 
							{
						/*		Cell cr_cell = row1.createCell(29);
								style.setFillBackgroundColor(IndexedColors.BRIGHT_GREEN1.getIndex());
								style.setFillPattern(FillPatternType.FINE_DOTS);
								cr_cell.setCellValue('\u2713' + " Rider plan New premium matched: Premium1 =  "+ RiderplanNewpremiumAmountFinal1 + " & Premium 2 = "+ NP03_final + " for "+ Polno1);
								cr_cell.setCellStyle(style);
								FileOutputStream fos = new FileOutputStream(file1);
								workbook1.write(fos); */
							}
							else {
								Cell cr_cell = row1.createCell(29);
								style.setFillBackgroundColor(IndexedColors.BRIGHT_GREEN1.getIndex());
								style.setFillPattern(FillPatternType.FINE_DOTS);
								cr_cell.setCellValue("X Rider plan New premium NOT matched X: Premium1 =  "+ RiderplanNewpremiumAmountFinal1 + " & Premium 2 = "+ NP03_final + " for "+ Polno1);
								cr_cell.setCellStyle(style);
								FileOutputStream fos = new FileOutputStream(file1);
								workbook1.write(fos);
							}
						}
						catch(Exception e) {
							
						}
						
						// 5 - Current Total Premium
						try {
							Cell CURRENT_PREMIUM_02 = row2.getCell(18);
							String CP02 = CURRENT_PREMIUM_02.getStringCellValue();
							CP02_final = CP02.trim();
							if(CurrentTotalPremiumAmountFinal1.equals(CP02_final)) 
							{
						/*		Cell cr_cell = row1.createCell(30);
								style.setFillBackgroundColor(IndexedColors.BRIGHT_GREEN1.getIndex());
								style.setFillPattern(FillPatternType.FINE_DOTS);
								cr_cell.setCellValue('\u2713' + " Current Total Premium matched: Premium1 =  "+ CurrentTotalPremiumAmountFinal1 + " & Premium 2 = "+ CP02_final + " for "+ Polno1);
								cr_cell.setCellStyle(style);
								FileOutputStream fos = new FileOutputStream(file1);
								workbook1.write(fos); */
							}else {
								Cell cr_cell = row1.createCell(30);
								style.setFillBackgroundColor(IndexedColors.BRIGHT_GREEN1.getIndex());
								style.setFillPattern(FillPatternType.FINE_DOTS);
								cr_cell.setCellValue("X Current Total Premium NOT matched X: Premium1 =  "+ CurrentTotalPremiumAmountFinal1 + " & Premium 2 = "+ CP02_final + " for "+ Polno1);
								cr_cell.setCellStyle(style);
								FileOutputStream fos = new FileOutputStream(file1);
								workbook1.write(fos);
							}
						}
						catch(Exception e) {
							
						}
						
						// 6 - New Total Premium
						try {
							Cell NEW_PREMIUM_02 = row2.getCell(16);
							String NP02 = NEW_PREMIUM_02.getStringCellValue();
							NP02_final = NP02.trim();
							if(NewTotalPremiumAmountFinal1.equals(NP02_final)) 
							{
					/*			Cell cr_cell = row1.createCell(31);
								style.setFillBackgroundColor(IndexedColors.BRIGHT_GREEN1.getIndex());
								style.setFillPattern(FillPatternType.FINE_DOTS);
								cr_cell.setCellValue('\u2713' + " New Total Premium matched: Premium1 =  "+ NewTotalPremiumAmountFinal1 + " & Premium 2 = "+ NP02_final + " for "+ Polno1);
								cr_cell.setCellStyle(style);
								FileOutputStream fos = new FileOutputStream(file1);
								workbook1.write(fos); */
							}
							else {
								Cell cr_cell = row1.createCell(31);
								style.setFillBackgroundColor(IndexedColors.RED.getIndex());
								style.setFillPattern(FillPatternType.DIAMONDS);
								cr_cell.setCellValue("X NEW TOTAL PREMIUM NOT MATCHED X : Premium1 =  "+ NewTotalPremiumAmountFinal1 + " & Premium 2 = "+ NP02_final + " for "+ Polno1);
								cr_cell.setCellStyle(style);
								FileOutputStream fos = new FileOutputStream(file1);
								workbook1.write(fos);
							}
							
							
						}
						catch (Exception e) {
							
						}
						
						Cell cr_cell = row1.createCell(32);
						style.setFillBackgroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
						style.setFillPattern(FillPatternType.DIAMONDS);
						cr_cell.setCellValue("Validation done for the policy = " + Polno1);
						cr_cell.setCellStyle(style);
						FileOutputStream fos = new FileOutputStream(file1);
						workbook1.write(fos);
						
						break loopInSheet2;
						
						} 
				}
			
			
			
			/*
			System.out.println(riderPlanamountFinal1);
			System.out.println(riderPlanfrequncyFinal1);
			System.out.println(MainplancurrentpremiumamountFinal1);
			System.out.println(MainplancurrentpremiumFrequencyFinal1);
			System.out.println(RiderplancurrentpremiumAmountFinal1);
			System.out.println(RiderplancurrentpremiumFreqFinal1);
			System.out.println(RiderplanNewpremiumAmountFinal1);
			System.out.println(RiderplanNewpremiumFreqFinal1);
			System.out.println(CurrentTotalPremiumAmountFinal1);
			System.out.println(CurrentTotalPremiumFreqFinal1);
			System.out.println(NewTotalPremiumAmountFinal1);
			System.out.println(NewTotalPremiumFreqFinal1); */
	
			}
			catch(Exception e) {
				
			}
		}	
		
		System.out.println("Validation Completed");
		}
		
		
		
	}

