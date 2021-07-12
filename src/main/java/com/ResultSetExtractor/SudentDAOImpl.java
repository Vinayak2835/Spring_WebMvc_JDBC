package com.ResultSetExtractor;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.DTO.StudentDTO;

@Repository
public class SudentDAOImpl implements StudentDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<StudentDTO> selectAll() {
		
		String sql="SELECT * FROM STUD";
		List<StudentDTO>  studentList=jdbcTemplate.query(sql, new  StudentRowMapper());
		return  studentList;
	}

	@Override
	public void insert(StudentDTO student) {
		
		String sql= "insert into stud(name,mobile,country) values (?,?,?)";
		Object[] object1= {student.getName(),student.getMobile(),student.getCountry()};
		jdbcTemplate.update(sql,object1);
		System.out.println("1  record has been updated");
	}

	@Override
	public StudentDTO update(int id) {
		
		String sql="SELECT  *  FROM stud WHERE id=?";
		StudentDTO  studentDTO=jdbcTemplate.queryForObject(sql, new StudentRowMapper(),id);
		System.out.println("update operation is completed");
		return studentDTO;
	}

	@Override
	public void updateStudentInformation(StudentDTO studentDTO) {
		
	        String sql="UPDATE STUD SET  name=?,mobile=?,country=? where id=?";
		Object[]  object= {studentDTO.getName(),studentDTO.getMobile(),studentDTO.getCountry(),studentDTO.getId()};
		jdbcTemplate.update(sql,object);
		System.out.println("hey 1 record is updated");
		
	}
        public void delete(int id) {
		
		String sql="DELETE FROM STUD WHERE ID=?";
		jdbcTemplate.update(sql,id);
	}
}
