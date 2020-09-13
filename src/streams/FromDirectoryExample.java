package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FromDirectoryExample {
	public static void main(String[] args) {
		Path path = Paths.get("C:/program files");
		
		try {
			Stream<Path> stream = Files.list(path);
			stream.forEach(t -> System.out.println(t.getFileName())); // 파일 이름을 가져옴
			stream.close();
			
		} catch (IOException e) {e.printStackTrace();}
		
		
		
	}
	
	
	
	
}
