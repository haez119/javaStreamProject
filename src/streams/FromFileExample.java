package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FromFileExample {
	public static void main(String[] args) {
		// 최상위 위치의 파일을 읽어오기 때문에 파일 이름만 (아니면 경로지정 bin/list.txt ...)
		// D:\Dev\workspace\javaStreamProject >>> 최상위 >>> "list.txt"
		String file = "src/streams/StreamExample.java";  
		Path path = Paths.get(file);
		try {
			Stream<String> stream = Files.lines(path); // 라인 1개씩 읽어옴
			stream.forEach(s -> System.out.println(s));
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
