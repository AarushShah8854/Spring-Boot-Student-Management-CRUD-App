package com.example.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.emp.domain.Student;
import com.example.emp.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		List<Student> students = studentService.listAll();
		model.addAttribute("studentList", students);
		return "index";
	}
	
	@GetMapping("/addUser")
	public String add(Model model) {
		model.addAttribute("student", new Student());
		return "addUser";
	}
	
	@PostMapping(value = "/save")
	public String saveStudent(@ModelAttribute("student") Student std) {
		studentService.save(std);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("updateuser");
		Student std = studentService.get(id);
		mav.addObject("student", std);
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteStudent(@PathVariable(name = "id") int id) {
		studentService.delete(id);
		return "redirect:/";
	}

}
