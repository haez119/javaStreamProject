package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

class Student {
	String name;
	int score;
	
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

}
public class StreamExample2 {
	public static void main(String[] args) {
		List<Student> stu = Arrays.asList(
				new Student("최재영", 90),
				new Student("민해주", 88),
				new Student("김상민", 83),
				new Student("최형준", 86));
		
		int rCnt=0;
		for(int i=0; i<stu.size(); i++) {
			if(stu.get(i).score >= 85) {
				System.out.println(stu.get(i).name + ", " + stu.get(i).score);
				rCnt++;
			}
		}
		System.out.println("총인원: " + rCnt + "\n");
		
		
		// 스트림
		 Stream<Student> stream = stu.stream();
		
		 stream.filter( (t) -> t.score >= 85 )
				.peek((t) -> System.out.println("peek=> " + t.name + ", " + t.score))
				.filter( (t) -> t.name.startsWith("최"))
				.forEach(new Consumer<Student> () {

					@Override
					public void accept(Student t) {
						System.out.println("forEach=> " + t.name + ", " + t.score);
					}
				});
		
		
		
	}
}
