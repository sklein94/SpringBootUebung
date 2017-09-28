package com.yourname.controller;

import com.yourname.Entity.Student;
import com.yourname.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @RequestMapping(value= "/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable int id){
       return studentService.getStudentById(id);
    }

    @RequestMapping(value= "/{id}", method = RequestMethod.DELETE)
    public void deleteStudentById(@PathVariable int id){
       studentService.removeStudentById(id);
        //TODO 28.09.2017, 10:12 [sklein]: Wenn hier ein Return gemacht wird, dann wird der wert zurücckgegeben
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertStudent(@RequestBody Student student){
        studentService.insertStudent(student);
    }



}
