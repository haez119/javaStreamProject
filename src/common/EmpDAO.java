package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmpDAO {
	
	
	
	public static List<Employee> getEmpList() {
		Connection conn = ConnectDB.getDB();
		
		String sql = "select * from emp_temp";
		List<Employee> list = FXCollections.observableArrayList();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(); // 쿼리실행, 쿼리 결과가 rs에 담김
			while (rs.next()) {
				Employee bk = new Employee(rs.getInt("employee_id"), 
										   rs.getString("first_name"), 
										   rs.getString("last_name"), 
										   rs.getString("email"), 
										   rs.getDate("hire_date").toLocalDate(), 
										   rs.getString("job_id"), 
										   rs.getInt("salary") ); // 칼럼이름

				list.add(bk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
