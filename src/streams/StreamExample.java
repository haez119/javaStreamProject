package streams;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
		// 컬렉션으로 처리 => 외부반복자
		List<String> users = Arrays.asList("홍길동", "최재영", "민해주", "김상민");
		System.out.println("외부반복자 사용");
		Iterator<String> iter = users.iterator();  // 반복자
		
		while(iter.hasNext()) {
			String str = iter.next();
			System.out.println(str.toString());  // str만 해줘도 출력됨
		}
					
		// 스트림 => 내부반복자
		// Consumer 매개값을 받 리턴값이 없는? 함수적 인터페이스???
		System.out.println("내부반복자 사용");
		Stream stream = users.stream();
		stream.forEach((t) ->  System.out.println(t.toString())); // 중괄호도 제거
		// forEach 스트림 요소를 반복처리?
		
		
		
		
		
	}

}
