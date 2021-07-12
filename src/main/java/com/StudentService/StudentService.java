package com.StudentService;

import java.util.List;

import com.DTO.StudentDTO;

public interface StudentService {
	
	
	List<StudentDTO>  selectAll();
	void insert(StudentDTO  student);
	
	StudentDTO update(int id);
	
	void updateStudentInformation(StudentDTO  studentDTO);
	
	public void delete(int id);

}
