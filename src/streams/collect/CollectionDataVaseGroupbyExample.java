package streams.collect;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import common.EmpDAO;
import common.Employee;

public class CollectionDataVaseGroupbyExample {
	
	public static void main(String[] args) {
		
		List<Employee> employees = EmpDAO.getEmpList();
		
		// 직무별 사원 출력
		
		Map<String, List<Employee>> gMap = employees.stream().collect(Collectors.groupingBy(new Function<Employee, String>() {

			@Override
			public String apply(Employee t) {
				return t.getJobId();
			}
		}));
		
		Set<String> keys = gMap.keySet();
		for(String s : keys) {
			List<Employee> list = gMap.get(s);
			System.out.println(s);
			for(Employee e : list) {
				System.out.println(e);
			}
			
			
		}
		
		
	}

}
