package streams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class IntExample {

	public static void main(String[] args) {
		// 1~10 정수형 배열 생성
		int[] ary = new int[10];
		
		for(int i=0; i<10; i++) {
			ary[i] = i+1;
		}

		// 배열로부터 스트림 생성
		IntStream is = Arrays.stream(ary);
		
		// filter를 통해서 짝수값을 
		// 최종집계는 sum() => 짝수값의 합을 구하기 
		// int sum = is.filter((value) -> value % 2 ==0).sum();
		System.out.println("sum: " + is.filter((value) -> value % 2 ==0).sum());
		
		IntStream.range(1, 10).forEach(s -> System.out.println("range: " + s));  // 9까지만 나옴
		IntStream.rangeClosed(1, 10).forEach(s -> System.out.println("rangeClosed: " + s)); // 10까지 나옴
		
		IntStream.rangeClosed(1, 10).filter(s -> s > 5).forEach(s -> System.out.println("filter: " + s));
		
		
	}
}
