package streams;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class FromArrayExample {
	public static void main(String[] args) {
		int[] intAry = {3,6,4,9,7};
		
		IntStream is = Arrays.stream(intAry);
		
		is.filter((value) -> value > 5)
		.forEach((value) ->System.out.println(value)); 
		
		// forEach 최종처리로 끝나면 더이상 데이터가 없음  다시 데이터를 가져와야 함
		
		is = Arrays.stream(intAry);
		System.out.println("avg: " + is.average().getAsDouble());
		
		is = Arrays.stream(intAry);
		System.out.println("sum: " + is.sum());
		
		is = Arrays.stream(intAry);
		System.out.println("count: " + is.count());
		
		// 가져올 값의 위치를 지정해서 넣기 4개만 넣음
		is = Arrays.stream(intAry, 0, 4);
		is.filter((value) -> value > 5)
		.forEach((value) ->System.out.println(value)); 
		
		is = Arrays.stream(intAry, 0, 4);
		System.out.println("count: " + is.count());
		
		
		// peek 중간처리 메소드...
		is = Arrays.stream(intAry, 0, 4);
		int i = is.peek((value) -> System.out.println(value)).sum();
		System.out.println("sum: " + i);
		
		
		
		
		
		
		
	}
}
