package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample3 {
	static int sum;
	
	public static void main(String[] args) {
		
		List<Student> list = Arrays.asList(
				new Student("최재영", 90),
				new Student("민해주", 88),
				new Student("김상민", 83),
				new Student("최형준", 86));
		
		
		Stream<Student> stream = list.stream(); 
		stream.forEach((t) -> sum += t.score );
		
		System.out.println("총점: " + sum +", 평균: " + (double) (sum / list.size()) );
	}
}
