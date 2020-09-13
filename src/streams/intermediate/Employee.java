package streams.intermediate;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

enum Gender {
	MALE, FEMALE;
}


public class Employee {
	String name;
	Gender gender;
	LocalDate dateOfBirth;
	double income;
	
	
	public Employee(String name, Gender gender, LocalDate dateOfBirth, double income) {
		
		this.name = name;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.income = income;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public double getIncome() {
		return income;
	}


	public void setIncome(double income) {
		this.income = income;
	}
	
	
	public boolean isMale() {
		return this.gender == Gender.MALE; 
		// 생성자 매개값이 male이면 true를 리턴
	}
	
	public boolean isFemale() {
		return this.gender == Gender.FEMALE;
	}


	@Override
	public String toString() {
		String str = String.format("(%s, %s, %s, %.2f) ", name, gender, dateOfBirth, income);
		return str;
	}
	
	public static List<Employee> employees() {
		Employee e1 = new Employee("홍", Gender.MALE, LocalDate.of(1991, Month.JANUARY, 1), 7843.0);
		Employee e2 = new Employee("황", Gender.FEMALE, LocalDate.of(1995, Month.AUGUST, 5), 5843.0);
		Employee e3 = new Employee("최", Gender.MALE, LocalDate.of(1994, Month.JANUARY, 9), 2143.0);
		Employee e4 = new Employee("박", Gender.FEMALE, LocalDate.of(1993, Month.NOVEMBER, 14), 4343.0);
		Employee e5 = new Employee("김", Gender.FEMALE, LocalDate.of(1992, Month.APRIL, 30), 2345.0);
		
		List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5);
		return employees;
	}
	

	
	
	
}


