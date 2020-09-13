package streams.collect;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import common.EmpDAO;
import common.Employee;

public class CollectionDataBaseExample {
	public static void main(String[] args) {
		
		System.out.println("-----입사일이 1990년대인 사원들만 출력-----");
		List<Employee> employees = EmpDAO.getEmpList();
		
		List<Employee> empList = employees.stream().filter(new Predicate<Employee>() {

			@Override
			public boolean test(Employee t) {
				return t.getHireDate().isAfter(LocalDate.of(1990, 01, 01)) && t.getHireDate().isBefore(LocalDate.of(1999, 12, 31));
			}
			
		}).collect(Collectors.toList());
		
		empList.stream().forEach(System.out::println);
		
		// jobId => ST_CLERK 인 사람들의 이름과  급여를 컬렉션에 저장
		
		
		System.out.println("-----부서가 ST_CLERK인 사원들의 이름과 급여-----");
		employees = EmpDAO.getEmpList();
		
		Map<String, Integer> me = employees.stream().filter(new Predicate<Employee>() {

			@Override
			public boolean test(Employee t) {
				return t.getJobId().equals("ST_CLERK");
			}
			
		}).collect(Collectors.toMap(new Function<Employee, String>() {

			@Override
			public String apply(Employee t) {
				return t.getFirstName() + " " + t.getLastName();
			}
			
		}, new Function<Employee, Integer>() {

			@Override
			public Integer apply(Employee t) {
				return t.getSalary();
			}
		}));
		
		Set<String> keys = me.keySet();
		
		for(String s : keys) {
			System.out.println("이름: " + s + " 급여: " + me.get(s));
		}
		
		
		
		
		
		
		
	}
}
