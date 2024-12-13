package acc.br.demo.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import acc.br.demo.dto.StudentDto;
import acc.br.demo.entity.Student;
import acc.br.demo.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@ModelAttribute("registrationData")
	public StudentDto registrationData() {
		return new StudentDto();
	}

	@GetMapping("/student/form")
	public String showForm(@ModelAttribute("registrationData") StudentDto registrationDto) {
		return "form";
	}

	@PostMapping("/student/submit")
	public String submitForm(@ModelAttribute("registrationData") StudentDto registrationDto, @RequestParam String name,
			@RequestParam String course, @RequestParam String cep, @RequestParam("dateOfBirth") String dob) {
		registrationDto.setName(name);
		registrationDto.setCourse(course);
		registrationDto.setCep(cep);
		registrationDto.setNascimento(LocalDate.parse(dob));
		return "redirect:/student/review";
	}

	@GetMapping("/student/review")
	public String reviewRegistration(@ModelAttribute("registrationData") StudentDto registrationDto, Model model) {
		model.addAttribute("registrationData", registrationDto);
		return "review";
	}

	@PostMapping("/student/confirm")
	public String confirmRegistration(@ModelAttribute("registrationData") StudentDto registrationDto, Model model) {
		Student saved = studentService.create(registrationDto);
		model.addAttribute("registrationData", new StudentDto());
		return "success";
	}

	@PostMapping("/student/edit")
	public String editRegistration(@ModelAttribute("registrationData") StudentDto registrationDto, Model model) {
		return "form";
	}

	@PostMapping("/student/cancel")
	public String cancelRegistration(Model model) {
		model.addAttribute("registrationData", new StudentDto());
		return "form";
	}
}