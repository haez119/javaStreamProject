package streams.intermediate;

import java.time.LocalDate;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class FlatMapExample {
	public static void main(String[] args) {
		
		
		Stream<Integer> stream = Stream.of(1,2,3,4,5);
		stream.flatMap(new Function<Integer, Stream<Integer>>() {
			@Override
			public Stream<Integer> apply(Integer t) {
				return Stream.of(t *2);
			}
			
		}).forEach(System.out::println);
		
		
		Employee.employees().stream().flatMapToDouble(new Function<Employee,DoubleStream>() {

			@Override
			public DoubleStream apply(Employee t) {
				return DoubleStream.of(t.getIncome());
			}
		}).forEach(System.out::println);
		
		
		Employee.employees().stream().flatMap(new Function<Employee, Stream<String>>() {

			@Override
			public Stream<String> apply(Employee t) {
				return Stream.of(t.getName());
			}
		}).forEach(System.out::println);
		
		System.out.println("----------------------");
		Employee.employees().stream().flatMap( (t) -> Stream.of(t.name)).findFirst().ifPresent(System.out::println);
		// ifPresent >> 리턴된 값이 있으면 출력하시오?
		

		double dd = Employee.employees().stream().flatMapToDouble((t) -> DoubleStream.of(t.getIncome())).sum();
		System.out.println(dd);
		
		System.out.println("----------------------");
		
		OptionalDouble result = Employee.employees().stream().flatMapToDouble(new Function<Employee,DoubleStream>() {

			@Override
			public DoubleStream apply(Employee t) {
				return DoubleStream.of(t.getIncome());
			}
		}).filter(n -> n> 7000).min();
		
		OptionalDouble result1 = Employee.employees().stream().flatMapToDouble(new Function<Employee,DoubleStream>() {

			@Override
			public DoubleStream apply(Employee t) {
				return DoubleStream.of(t.getIncome());
			}
		}).reduce(new DoubleBinaryOperator() {
			
			@Override
			public double applyAsDouble(double left, double right) {
				System.out.println(left + ", " + right);
				return left + right;
			}
		});

		// 8000보다 큰 값 없음 => result에 값 x
		// result에 값이 있으면 result 출력 아니면 결과없음 출력
		if(result1.isPresent()) {
			System.out.println("result: " + result1);
		} else {
			System.out.println("결과없음");
		}

		
		Optional<LocalDate> result2 = Employee.employees().stream().flatMap(new Function<Employee, Stream<LocalDate>>() {

			@Override
			public Stream<LocalDate> apply(Employee t) {
				return Stream.of(t.getDateOfBirth());
			}
			
		}).reduce(new BinaryOperator<LocalDate>() {

			@Override
			public LocalDate apply(LocalDate t, LocalDate u) {
				return t.isBefore(u) ? u : t;  //최대값?
				// t보다 u가 으면 u / t가 크면 t
				// 리턴값이 t에 저장됨 t에는 항상 큰 값만 저장됨 >> 최대값
			}
			
		});
		
		System.out.println(result2);
		
	}
}
