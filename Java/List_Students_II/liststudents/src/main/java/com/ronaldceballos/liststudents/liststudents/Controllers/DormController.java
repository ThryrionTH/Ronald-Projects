package com.ronaldceballos.liststudents.liststudents.Controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ronaldceballos.liststudents.liststudents.Models.Dorm;
import com.ronaldceballos.liststudents.liststudents.Models.Student;
import com.ronaldceballos.liststudents.liststudents.Services.DormService;
import com.ronaldceballos.liststudents.liststudents.Services.StudentService;

import jakarta.validation.Valid;

@Controller
public class DormController {
    private final DormService dormService;
    private final StudentService studentService;

    public DormController(DormService dormService, StudentService studentService) {
        this.dormService = dormService;
        this.studentService = studentService;
    }

    @RequestMapping("/dorms")
    public String dorms(Model model) {
        List<Dorm> dorms = dormService.getAllDorms();

        for (Dorm dorm : dorms) {
            dorm.setStudentCount(dorm.getStudents().size());
        }
        model.addAttribute("dorms", dorms);
        return "dorms";
    }

    @RequestMapping("/dorms/new")
    public String newDorm(@ModelAttribute("dorm") Dorm dorm) {
        return "newDorm";
    }

    @RequestMapping(value = "/dorms", method = RequestMethod.POST)
    public String createDorm(@Valid @ModelAttribute("dorm") Dorm dorm, BindingResult result) {
        if (result.hasErrors()) {
            return "newDorm";
        } else {
            dormService.createDorm(dorm);
            Long createdDormId = dorm.getId();
            return "redirect:/dorms/" + createdDormId;
        }
    }

    @RequestMapping("dorms/{id}")
    public String showDorm(@PathVariable("id") Long id, Model model) {
        Dorm dorm = dormService.findDorm(id);
        if (dorm == null) {
            return "error";
        }
        List<Student> studentsInDorm = studentService.getStudentsInDorm(dorm);
        List<Student> studentsWithoutDorm = studentService.getAllStudentsWithoutDorm();

        model.addAttribute("dorm", dorm);
        model.addAttribute("studentsInDorm", studentsInDorm);
        model.addAttribute("studentsWithoutDorm", studentsWithoutDorm);
        return "showDorm";
    }

    @RequestMapping(value = "/dorms/{dormId}", method = RequestMethod.POST)
    public String addStudentToDorm(@PathVariable("dormId") Long dormId, @RequestParam("studentId") Long studentId) {
        Dorm dorm = dormService.findDorm(dormId);
        Student student = studentService.findStudent(studentId);

        if (dorm != null && student != null) {
            student.setDorm(dorm);
            studentService.createStudent(student);
        }

        return "redirect:/dorms/" + dormId;
    }

    @RequestMapping(value = "/dorms/{dormId}/{studentId}/delete", method = RequestMethod.DELETE)
    public String removeStudentFromDorm(@PathVariable("dormId") Long dormId, @PathVariable("studentId") Long studentId) {
        Dorm dorm = dormService.findDorm(dormId);
        Student student = studentService.findStudent(studentId);
        if (dorm != null && student != null) {
            student.setDorm(null);
            studentService.createStudent(student);
        }
        return "redirect:/dorms/" + dormId;
    }

    @RequestMapping(value = "/dorms/{id}", method = RequestMethod.DELETE)
    public String destroyStudents(@PathVariable("id") Long id) {
        dormService.deleteDorm(id);
        return "redirect:/";
    }
}
