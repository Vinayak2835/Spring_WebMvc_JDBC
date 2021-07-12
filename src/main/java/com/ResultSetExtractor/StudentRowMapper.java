package com.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.DTO.StudentDTO;

public class StudentRowMapper  implements  RowMapper<StudentDTO> {

	@Override
	public StudentDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		StudentDTO  student = new  StudentDTO();
		student.setId(rs.getInt("id"));
		student.setName(rs.getString("name"));
		student.setMobile(rs.getLong("mobile"));
		student.setCountry(rs.getString("country"));
		return student;
		
	}
}
