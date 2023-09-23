package com.ronaldceballos.liststudents.liststudents.Controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ronaldceballos.liststudents.liststudents.Models.Contact;
import com.ronaldceballos.liststudents.liststudents.Models.Student;
import com.ronaldceballos.liststudents.liststudents.Services.ContactService;
import com.ronaldceballos.liststudents.liststudents.Services.StudentService;

@Controller
public class HomeController {
    private final StudentService studentService;
    private final ContactService contactService;

    public HomeController(StudentService studentService, ContactService contactService) {
        this.studentService = studentService;
        this.contactService = contactService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Student> student = studentService.getAllStudents();
        List<Contact> contact = contactService.getAllContacts();
        List<Student> studentsWithoutContact = studentService.getAllStudentsWithoutContact();
        model.addAttribute("studentsWithoutContact", studentsWithoutContact);
        model.addAttribute("student", student);
        model.addAttribute("contact", contact);
        return "home";
    }
}
