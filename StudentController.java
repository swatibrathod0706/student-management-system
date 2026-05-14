package com.student.controller;

import com.student.entity.Student;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("students", service.getAllStudents());
        return "index";
    }

    @GetMapping("/add")
    public String addStudentPage(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student) {
        service.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
        return "redirect:/";
    }
}
