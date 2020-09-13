package streams.intermediate.terminate.collect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import streams.intermediate.Student;

public class CollectionExample {
	public static void main(String[] args) {
	
		// String 타입의 컬랙션
		Set<String> setStr = new HashSet<>();
		setStr.add(new String("최재영"));
		setStr.add(new String("민해주"));
		setStr.add(new String("김상민"));
		
		
		for(String s: setStr) {
			// 가져오기1
		}
		
		Iterator<String> iter = setStr.iterator();
		
		while(iter.hasNext()) {
			// 방법2  
			System.out.println(iter.next());
		}
		
		
		
		// 클래스 타입의 컬랙션
		List<Student> students = new ArrayList<>();
		
		students.add(new Student("허성준", 80));
		students.add(new Student("최형준", 90));
		
		List<Student> studentw = new ArrayList<>();
		
		studentw.add(new Student("김다희", 80));
		studentw.add(new Student("김도은", 90));
		
		for(Student s: studentw) {
			System.out.println(s);
		}
		
		List<Student> studentr = new ArrayList<>();
		
		studentr.add(new Student("재평가1", 80));
		studentr.add(new Student("재평가2", 80));
		
		
		// map => key, value 형식으로 저장
		Map<String, Integer> map = new HashMap<>();
		map.put("동광희", 25);
		map.put("김시무", 26);
		
		Set<String> key = map.keySet(); // key 가져오기
		
		Iterator<String> itr = key.iterator(); // key를 기준으로 반복
		while(itr.hasNext()) {
			String k = itr.next(); // k에 key가 저장됨
			System.out.println(map.get(k));  // get안에 key를 넣으면 key에 맞는 value를 반환
		}
		
		
		Map<String, List<Student>> stMap = new HashMap<>();
		// <Student>가 아니라 List<Student> 니까 new Student(); 불가
		stMap.put("남자", students);
		stMap.put("여자", studentw);
		stMap.put("재평가", studentr);
		
		Set<String> setK = stMap.keySet(); // key 가져오기
		for(String s: setK) {
			System.out.println(s); // key 출력
			List<Student> valueList = stMap.get(s); // value 가져오기
			for(Student st: valueList) {
				System.out.println(st);
			}
		}
		
	}
}
