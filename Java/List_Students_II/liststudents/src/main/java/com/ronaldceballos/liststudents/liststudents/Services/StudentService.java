package com.ronaldceballos.liststudents.liststudents.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ronaldceballos.liststudents.liststudents.Models.Dorm;
import com.ronaldceballos.liststudents.liststudents.Models.Student;
import com.ronaldceballos.liststudents.liststudents.Repsositories.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudent(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            return optionalStudent.get();
        } else {
            return null;
        }
    }

    public List<Student> getAllStudentsWithoutContact() {
        return studentRepository.findByContactIsNull();
    }

    public List<Student> getAllStudentsWithoutDorm() {
        return studentRepository.findByDormIsNull();
    }

    public List<Student> getStudentsInDorm(Dorm dorm) {
    return studentRepository.findByDorm(dorm);
    }
}
