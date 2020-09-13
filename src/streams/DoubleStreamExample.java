package streams;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DoubleStreamExample {
	public static void main(String[] args) {
		
		double[] dAry = { 2.3, 4.5, 8.3, 5.5, 4.6};	
		
		DoubleStream ds = Arrays.stream(dAry);
		double dd = ds.filter((value) ->value < 5).sum();
		
		// 한줄로 줄이기
		double dd2 = Arrays.stream(dAry).filter((value) -> value < 5).sum();
		
		// 바로 값 넣기
		long ll = Arrays.stream(new long[] {10,20,30,40}).filter((value) -> value <= 20).sum();
		
		IntStream iis = Arrays.stream(new int[] {1, 2, 3});

		System.out.println("1. 5보다 작은 수의 합: " + dd);
		System.out.println("2. 5보다 작은 수의 합: " + dd2);
		
		// String 스트림
		

		
		Stream<String> sStream = Arrays.stream(new String[] = { "홍", "길", "동"});
		Stream<Student> stStream = Arrays.stream(new Student[] {new Student(), new Student()});
		
		
	}
	

}
