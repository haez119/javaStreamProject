package streams.intermediate.terminate;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import common.EmpDAO;
import common.Employee;

public class ReduceExample {
	public static void main(String[] args) {
		
		List<Employee> empList = EmpDAO.getEmpList();
		
		Stream<Employee> stream = empList.stream();
		
		// average() 메소드의 반환값이 double!!
		OptionalDouble avg = stream.flatMapToInt(new Function<Employee, IntStream>() {

			@Override
			public IntStream apply(Employee t) {
				
				return IntStream.of(t.getSalary());
			}
			
		}).average();
		
		System.out.println("평균급여는: " + avg.getAsDouble());
		
		
		stream = empList.stream();
		int sum = stream.flatMapToInt(new Function<Employee, IntStream>() {

			@Override
			public IntStream apply(Employee t) {
				
				return IntStream.of(t.getSalary());
			}
			
		}).sum();
		
		System.out.println("합계: " + sum);
		
		stream = empList.stream();
		
		OptionalDouble avg1 = stream.filter(new Predicate<Employee>() {

			@Override
			public boolean test(Employee t) {
				
				return t.getJobId().equals("IT_PROG");
			}
			
		}).flatMapToInt(new Function<Employee, IntStream>() {

			@Override
			public IntStream apply(Employee t) {
				
				return IntStream.of(t.getSalary());
			}
			
		}).average();
		
		System.out.println("IT_PROG의 평균 급여: " + avg1.getAsDouble());
		
		stream = empList.stream();
		
		OptionalInt min = stream.filter(new Predicate<Employee>() {

			@Override
			public boolean test(Employee t) {
				
				return t.getJobId().equals("IT_PROG");
			}
			
		}).flatMapToInt(new Function<Employee, IntStream>() {

			@Override
			public IntStream apply(Employee t) {
				
				return IntStream.of(t.getSalary());
			}
			
		}).min();
		
		System.out.println("IT_PROG의 최소급여: " + min.getAsInt());

	}
}










