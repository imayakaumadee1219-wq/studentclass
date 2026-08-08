package com.example.studentclass;

import lombok.RequiredArgsConstructor; 
import org.springframework.stereotype.Service; 
import java.util.List; 

@Service 
@RequiredArgsConstructor 

public class StudentServiceImpl implements StudentService { 
    
    private final StudentclassRepo studentRepository; 
    
    @Override 
    public Studentclass save(Studentclass student) { 
        
        return studentRepository.save(student); 
    } 
    
    @Override 
    public List<Studentclass> getAll() { 
        return studentRepository.findAll(); 
    } 
    
    @Override 
    public Studentclass getById(String id) { 
        return studentRepository.findById(id) .orElseThrow(() -> new RuntimeException("Student not found with id: " + id)); 
    } 
    
    @Override 
    public Studentclass update(String id, Studentclass student) { 
        Studentclass existing = getById(id); 
        existing.setName(student.getName()); 
        existing.setEmail(student.getEmail()); 
        existing.setAge(student.getAge()); 
        return studentRepository.save(existing); 
    } 
    
    @Override 
    public void delete(String id) { 
        studentRepository.deleteById(id); 
    }
}
