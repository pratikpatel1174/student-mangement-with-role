package com.student.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.student.model.Student;
import com.student.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Student> listStudent = studentService.listAll();
		model.addAttribute("listStudent",listStudent);
		return "index";
	}
	
	@RequestMapping("/new")
	public String newStudentPage(Model model) {
		Student student=new Student();
		//model.addAttribute(student);
		
		studentService.save(student);
		
		
		return "new_student";
	}
	
	@RequestMapping(value = "/save", method =RequestMethod.POST)
	public String saveStudent(@ModelAttribute("Student") Student student) {
		studentService.save(student);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{sid}")
	public ModelAndView showEditStudentPage(@PathVariable(name="sid") Long sid) {
		ModelAndView mav=new ModelAndView("edit_student");
		Student student=studentService.get(sid);
		mav.addObject(student);
		return mav;
	}

	@RequestMapping("/delete/{sid}")
	public String deleteStudentPage(@PathVariable(name = "sid") Long sid) {
		studentService.delete(sid);
		return "redirect:/";
	}

}
