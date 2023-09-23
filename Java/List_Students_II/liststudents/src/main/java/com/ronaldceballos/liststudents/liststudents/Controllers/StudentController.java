package com.ronaldceballos.liststudents.liststudents.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ronaldceballos.liststudents.liststudents.Models.Student;
import com.ronaldceballos.liststudents.liststudents.Services.StudentService;

import jakarta.validation.Valid;

@Controller
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students/new")
    public String newStudent(@ModelAttribute("student") Student student) {
        return "newStudent";
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public String createStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "newStudent";
        }
        studentService.createStudent(student);
        return "redirect:/";
    }
}
