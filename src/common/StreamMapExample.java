package common;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import common.EmpDAO;

public class StreamMapExample {
	public static void main(String[] args) {

		List<Employee> employees = EmpDAO.getEmpList();
		
		System.out.println("------------테이블 전체 출력------------");
		employees.stream().forEach(System.out::println);

		// salary가 10000이상인 사람만 출력 (필터 사용)
		System.out.println("------------salary가 10000이상, id가 110 이상인 행------------");
		employees.stream().filter(t -> t.getSalary() >= 10000).filter(t -> t.getEmployeeId() >= 110).forEach(System.out::println);
		
		
		// salary 최대값 reduce 써서 
		System.out.println("------------salary 최소, 최대값------------");
		
		int a = employees.stream().flatMap(new Function<Employee, Stream<Integer>>() {

			@Override
			public Stream<Integer> apply(Employee t) {

				return Stream.of(t.getSalary());
			}

		}).reduce(new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer t, Integer u) {

				return t >= u ? t : u;
			}

		}).get();
		
		System.out.println("최대값: " + a);
		
		int b = employees.stream().map(new Function<Employee, Integer>() {

			@Override
			public Integer apply(Employee t) {
				
				return t.getSalary();
			}
			
		}).reduce(new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer t, Integer u) {
				
				return t<= u ? t : u;
			}
			
		}).get();
		
		
		System.out.println("최소값: " +b );
		
		System.out.println("------------입사일이 1995년 이후인 행------------");
		
		employees.stream().filter(new Predicate<Employee>() {

			@Override
			public boolean test(Employee t) {
				LocalDate a = LocalDate.of(1995,01,01);
				return t.getHireDate().isAfter(a);
			}
			
		}).forEach(System.out::println);
		
		System.out.println("------------입사일이 1995 이전인 행------------");
		
		employees.stream().filter(new Predicate<Employee>() {

			@Override
			public boolean test(Employee t) {
				LocalDate a = LocalDate.of(1995,01,01);
				return t.getHireDate().isBefore(a);
			}
			
		}).forEach(System.out::println);

	}

}
