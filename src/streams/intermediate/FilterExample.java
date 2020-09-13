package streams.intermediate;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.function.Predicate;

public class FilterExample {
	public static void main(String[] args) {
		
		List<Employee> list = Employee.employees();
		list.stream().filter(new Predicate<Employee>() {
			@Override
			public boolean test(Employee t) {
					return t.isFemale(); 
			}
		}).peek(s -> {
			s.setIncome(s.getIncome() * 0.9);
		}).forEach(System.out::println);
		
		System.out.println("----------------------------------");
		
		list.stream().filter(t -> t.getIncome() > 5000).forEach(System.out::println);
		
		System.out.println("----------------------------------");
		
		// isBefore 이전 93년 3월 1일 이전 값을 출력
		list.stream().filter(t -> t.getDateOfBirth().isBefore(LocalDate.of(1993, Month.MARCH,1))).forEach(System.out::println);
		System.out.println("----------------------------------");
		
		// isAfter 이후
		list.stream().filter(t -> t.getDateOfBirth().isAfter(LocalDate.of(1993, Month.MARCH, 1))).forEach(System.out::println);
		
	}
}
