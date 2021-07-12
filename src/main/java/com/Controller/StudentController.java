package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.DTO.StudentDTO;
import com.StudentService.StudentServiceImpl;

@Controller
public class StudentController {
	
	@Autowired
	private StudentServiceImpl  studentServiceImpl;
	
	@GetMapping("/showstudent")
	public String studentShow(Model model) {
		
		List<StudentDTO>  studentList = studentServiceImpl.selectAll();
		 
		 for(StudentDTO  tempStudent:studentList) {
			 System.out.println(tempStudent);
		 }
		 model.addAttribute("userinfo", studentList);
		 
		 return "student-list";
	}
	
	@GetMapping("/show")
	public String addStudent(Model model ) {
		
		StudentDTO studentDTO=new StudentDTO();
		model.addAttribute("student", studentDTO);
		return "student-list1";
	}
	
	@PostMapping("/save-student")
	public String saveStudent(StudentDTO  studentDTO  ) {
		System.out.println(studentDTO);
		
		if(studentDTO.getId()==0) {
		     studentServiceImpl.insert(studentDTO);
		}
		else {
		     studentServiceImpl.updateStudentInformation(studentDTO);
		}
		  return "redirect:/showstudent";
	}
	
	@GetMapping("/updatestudent")
	public String update(@RequestParam("userId")  int id,@ModelAttribute("student")  StudentDTO studentDTO) {
		
		StudentDTO studentDTO1=studentServiceImpl.update(id);
		studentDTO.setId(studentDTO1.getId());
		studentDTO.setName(studentDTO1.getName());
		studentDTO.setMobile(studentDTO1.getMobile());
		studentDTO.setCountry(studentDTO1.getCountry());
		
		return "student-list1";
	}
	
	
	@GetMapping("/deletestudent")
	public String delete(@RequestParam("userId") int id) {
		
		studentServiceImpl.delete(id);
		System.out.println("deleted ");
		return "student-list";
	}
	
}
