package common.excel;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;



import common.EmpDAO;
import common.Employee;

public class ExcelExample {
	public static void main(String[] args) {
		
		EmployeeExcelWriter writer = new EmployeeExcelWriter();
		
		List<Employee> list = EmpDAO.getEmpList(); // db에서 emp 테이블 가져와서
		writer.xlsWriter(list); // 엑셀 파일 만드는 메소드의 매개값으로 주기
		
		System.out.println("엑셀 완료");
		
		// 직무 IT_PROG  사원들의 사원번호, 이름, 메일주소, 급여, 입사일
		//it_prog.xls 파일로 생성
		
		list = EmpDAO.getEmpList();
		
		List<Employee> empList =  list.stream().filter(new Predicate<Employee>() {

			@Override
			public boolean test(Employee t) {
				
				return t.getJobId().equals("IT_PROG");
			}
			
		}).collect(Collectors.toList());
		
		writer.xlsWriter2(empList);
		System.out.println("엑셀완료2");
	
	}
}
