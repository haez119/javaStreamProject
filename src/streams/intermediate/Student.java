package streams.intermediate;

public class Student implements Comparable<Student>{
	String name;
	int score;
	
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	
	




	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Student) {
		Student that = (Student) obj;
		return this.name.equals(that.name);
		// this.name.equals(that.name) && this.score == that.score;
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return this.score;
		// thus.score + this.name.hashCode;
		// Objects.hashCode(this.name);
	}



	@Override
	public String toString() {
		return "name=" + name + ", score=" + score;
	}






	@Override
	public int compareTo(Student that) {
		return this.score - that.score;
		// this - that => 오름차순
		// that - this => 내림차순
	}
	
	
	
	
	
	

}
