package com.ronaldceballos.liststudents.liststudents.Controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ronaldceballos.liststudents.liststudents.Models.Contact;
import com.ronaldceballos.liststudents.liststudents.Models.Student;
import com.ronaldceballos.liststudents.liststudents.Services.ContactService;
import com.ronaldceballos.liststudents.liststudents.Services.StudentService;

import jakarta.validation.Valid;

@Controller
public class ContactController {
    private final StudentService studentService;
    private final ContactService contactService;

    public ContactController(StudentService studentService, ContactService contactService) {
        this.studentService = studentService;
        this.contactService = contactService;
    }

    @GetMapping("/contacts/new")
    public String newContact(@ModelAttribute("contact") Contact contact, Model model) {
        List<Student> studentsWithoutContact = studentService.getAllStudentsWithoutContact();
        model.addAttribute("studentsWithoutContact", studentsWithoutContact);
        return "newContact";
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.POST)
    public String createContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Student> studentsWithoutcontact = studentService.getAllStudentsWithoutContact();
            model.addAttribute("studentsWithoutContact", studentsWithoutcontact);
            return "newContact";
        }
        Student selectedstudent = studentService.findStudent(contact.getStudent().getId());
        Contact newcontact = new Contact(contact.getAddress(), contact.getCity(), contact.getState());
        newcontact.setStudent(selectedstudent);
        contactService.createContact(newcontact);
        return "redirect:/";
    }
}
