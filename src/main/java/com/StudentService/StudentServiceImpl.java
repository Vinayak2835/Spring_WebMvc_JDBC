package com.StudentService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.DTO.StudentDTO;
import com.ResultSetExtractor.SudentDAOImpl;


@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private SudentDAOImpl  sudeudentDAOImpl  ;
	
	@Override
	public List<StudentDTO> selectAll() {
		List<StudentDTO>  studentList= sudeudentDAOImpl.selectAll();
		return studentList;
	}

	@Override
	public void insert(StudentDTO student) {
		sudeudentDAOImpl.insert(student);
	}

	@Override
	public StudentDTO update(int id) {
		StudentDTO studentDTO=sudeudentDAOImpl.update(id);
		return studentDTO;
	}

	@Override
	public void updateStudentInformation(StudentDTO studentDTO) {
		sudeudentDAOImpl.updateStudentInformation(studentDTO);
	}

	public void delete(int id) {
		sudeudentDAOImpl.delete(id);
	}
}
