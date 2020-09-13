package streams.collect;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

enum Gender{
	MALE, FEMALE;
}

class Student {
	String name;
	int age;
	Gender gender;
	
	public Student(String name, int age, Gender gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

}


public class CollectToListExample {
	public static void main(String[] args) {
		
		Student s1 = new Student("허성준", 25, Gender.MALE);
		Student s2 = new Student("최형준", 26, Gender.MALE);
		Student s3 = new Student("문선애", 27, Gender.FEMALE);
		
		System.out.println("---------(list) 남자만---------");
		List<Student> students = Arrays.asList(s1, s2, s3);
		
		//??
		Collector<Student, ? , List<Student>> collector = Collectors.toList();
		List<Student> newList = students.stream().filter(t-> t.gender == Gender.MALE).collect(collector);
		
		newList.stream().forEach(s -> System.out.println(s.name + ", " + s.age));
		
		System.out.println("---------(set) 25살 넘는---------");
		
		students = Arrays.asList(s1, s2, s3);
		
		
		Set<Student> ss = students.stream().filter(t -> t.age > 25).collect(Collectors.toSet());
		
		Iterator<Student> is = ss.iterator();
		while(is.hasNext()) {
			Student s = is.next();
			System.out.println(s.name + ", " + s.age);
		}
		
		
		
		
		
		
		
		
		
	}
}














