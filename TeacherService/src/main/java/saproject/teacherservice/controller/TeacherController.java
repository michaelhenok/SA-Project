package saproject.teacherservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import saproject.teacherservice.ExceptionHandling.TeacherException;
import saproject.teacherservice.domain.Teacher;
import saproject.teacherservice.service.TeacherService;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;



    @Autowired
    private TeacherService teacherService;

    @PostMapping("/add")
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher) {
            return new ResponseEntity<>(teacherService.addTeacher(teacher), HttpStatus.OK);
//            String message = teacher.getFirstName() + "," + teacher.getLastName() + "," + teacher.getContact().getEmail();
//            kafkaTemplate.send("teacher", message);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable int id) {
        return new ResponseEntity<>(teacherService.deleteTeacher(id), HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher) {
        return new ResponseEntity<>(teacherService.updateTeacher(teacher), HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable int id) {
        Teacher teacher = teacherService.getTeacher(id);
        if (teacher == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers() ;
    }
    @GetMapping("/get/allNumber")
    public ResponseEntity<Integer> getNumberOfTeachers() {
        return new ResponseEntity<>(teacherService.getNumberOfTeachers(), HttpStatus.OK);
    }
}
