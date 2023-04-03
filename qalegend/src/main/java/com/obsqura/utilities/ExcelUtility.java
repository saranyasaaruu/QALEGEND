package com.obsqura.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.obsqura.constants.Constants;

public class ExcelUtility {
	public static XSSFSheet sh;
	public static FileInputStream f;
	public static XSSFWorkbook w;

	public static String readStringData(int i, int j) throws IOException {
		// f=new FileInputStream("D:\\testdata.xlsx");
		String path = System.getProperty("user.dir");
		// System.out.println(path);
		f = new FileInputStream(Constants.excelPath);
		w = new XSSFWorkbook(f);
		PageUtility pu = new PageUtility();
		sh = w.getSheet(pu.getExcelSheet());
		Row r = sh.getRow(i);
		Cell c = r.getCell(j);
		return c.getStringCellValue();
	}

	public static String readIntegerData(int i, int j) throws IOException {
		// f=new FileInputStream("D:\\testdata.xlsx");
		String path = System.getProperty("user.dir");
		System.out.println(path);
		f = new FileInputStream(Constants.excelPath);
		w = new XSSFWorkbook(f);
		PageUtility pu = new PageUtility();
		sh = w.getSheet(pu.getExcelSheet());
		Row r = sh.getRow(i);
		Cell c = r.getCell(j);
		int a = (int) c.getNumericCellValue();
		return String.valueOf(a);
	}

}
