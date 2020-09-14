package common.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import common.Employee;

public class EmployeeExcelWriter {

	public void xlsWriter(List<Employee> list) {

		HSSFWorkbook workbook = new HSSFWorkbook(); // 엑셀 만들기
		HSSFSheet sheet = workbook.createSheet(); // 시트 만들기
		HSSFRow row = sheet.createRow(0); // 첫번째 행
		HSSFCell cell; // 셀

		cell = row.createCell(0); // 첫번째 행의 첫번째 칼럼
		cell.setCellValue("EmployeeID");

		cell = row.createCell(1); // 두번째 칼럼
		cell.setCellValue("FirstName");

		cell = row.createCell(2);
		cell.setCellValue("LastName");

		cell = row.createCell(3);
		cell.setCellValue("Email");

		cell = row.createCell(4);
		cell.setCellValue("Salary");

		Employee emp;

		for (int i = 0; i < list.size(); i++) {
			emp = list.get(i);
			
			// row 새로 만들기 0행에는 칼럼명이 이후부터 값이 들어와야 돼서 +1 하기
			row = sheet.createRow( i +1); 

			cell = row.createCell(0);
			cell.setCellValue(emp.getEmployeeId());

			cell = row.createCell(1);
			cell.setCellValue(emp.getFirstName());

			cell = row.createCell(2);
			cell.setCellValue(emp.getLastName());

			cell = row.createCell(3);
			cell.setCellValue(emp.getEmail());

			cell = row.createCell(4);
			cell.setCellValue(emp.getSalary());

		}

		File file = new File("employeeExcel.xls"); // 파일 생성
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(file); // 파일을 밖으로 저장?
			workbook.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (workbook != null)
					workbook.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	
	public void xlsWriter2(List<Employee> list) {

		HSSFWorkbook workbook = new HSSFWorkbook(); // 엑셀 만들기
		HSSFSheet sheet = workbook.createSheet(); // 시트 만들기
		HSSFRow row = sheet.createRow(0); // 첫번째 행
		HSSFCell cell; // 셀

		cell = row.createCell(0); // 첫번째 행의 첫번째 칼럼
		cell.setCellValue("EmployeeID");

		cell = row.createCell(1); // 두번째 칼럼
		cell.setCellValue("FirstName");

		cell = row.createCell(2);
		cell.setCellValue("LastName");

		cell = row.createCell(3);
		cell.setCellValue("Email");

		cell = row.createCell(4);
		cell.setCellValue("Salary");
		
		cell = row.createCell(4);
		cell.setCellValue("HireDate");

		Employee emp;

		for (int i = 0; i < list.size(); i++) {
			emp = list.get(i);
			
			// row 새로 만들기 0행에는 칼럼명이 이후부터 값이 들어와야 돼서 +1 하기
			row = sheet.createRow( i +1); 

			cell = row.createCell(0);
			cell.setCellValue(emp.getEmployeeId());

			cell = row.createCell(1);
			cell.setCellValue(emp.getFirstName());

			cell = row.createCell(2);
			cell.setCellValue(emp.getLastName());

			cell = row.createCell(3);
			cell.setCellValue(emp.getEmail());

			cell = row.createCell(4);
			cell.setCellValue(emp.getSalary());
			
			cell = row.createCell(4);
			cell.setCellValue(emp.getHireDate());

		}

		File file = new File("it_prog.xls"); // 파일 생성
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(file); // 파일을 밖으로 저장?
			workbook.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (workbook != null)
					workbook.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	
	
	
	

}
