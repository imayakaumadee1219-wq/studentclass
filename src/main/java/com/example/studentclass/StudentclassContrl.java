package com.example.studentclass;

import lombok.RequiredArgsConstructor; 
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.*; 
import java.util.List; 

@RestController 

@RequestMapping("/studentclass") 
@RequiredArgsConstructor 

public class StudentclassContrl { 
    private final StudentService studentService; 
    
    @PostMapping 
    public ResponseEntity<Studentclass> create(@RequestBody Studentclass student) { 
        Studentclass saved = studentService.save(student); 
        return new ResponseEntity<>(saved, HttpStatus.CREATED); 
    } 
    
    @GetMapping 
    public ResponseEntity<List<Studentclass>> getAll() { 
        return ResponseEntity.ok(studentService.getAll()); 
    } 
    
    @GetMapping("/{id}") 
    public ResponseEntity<Studentclass> getById(@PathVariable String id) { 
        return ResponseEntity.ok(studentService.getById(id)); 
    } 
    
    @PutMapping("/{id}") 
    public ResponseEntity<Studentclass> update(@PathVariable String id, @RequestBody Studentclass student) { 
        return ResponseEntity.ok(studentService.update(id, student)); 
    } 
    
    @DeleteMapping("/{id}") 
    public ResponseEntity<Void> delete(@PathVariable String id) { 
        studentService.delete(id);
        return ResponseEntity.noContent().build(); 
    } 
}
