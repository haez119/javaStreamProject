package streams.intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class DistinctExample {
	
	public static void main(String[] args) {
		
		String[] sAry = {"Hong", "Park", "choi", "Hong" };
		
		Stream<String> ss = Arrays.stream(sAry);
		// System.out::println >> ?? 람다식에서 변수만 출력할 때?
		//ss.distinct().forEach(System.out::println);
		
		ss = Arrays.stream(sAry);
		ss.sorted().forEach(System.out::println); // 사전 순으로 정렬 (아스키코드 값 기준)
		
		Student[] students = { 
				new Student("이화진", 50), 
				new Student("이화진", 50), 
				new Student("이화진", 55), 
				new Student("동광희", 60), 
				new Student("우청일", 90), 
				new Student("우청일", 90), 
				new Student("김도은", 70) };
		
		Stream<Student> sstu = Arrays.stream(students);
		//sstu.distinct().forEach(System.out::println);
		// 중복제거 하려면 hashCode(), equals() 재정의 해야 함
		
		//sstu.sorted().forEach(System.out::println);
		// 정렬해주는 sorted => 클래스에 사용할 경우 Comparable 사용해서 재정의
		
		// 바로 재정의 하기
		sstu.sorted(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.score - o2.score;
			}
			
		}).forEach(System.out::println);
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
