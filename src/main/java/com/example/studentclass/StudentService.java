package com.example.studentclass;

import java.util.List; 

public interface StudentService { 
    Studentclass save(Studentclass student); 
    List<Studentclass> getAll(); 
    Studentclass getById(String id); 
    Studentclass update(String id, Studentclass student); 
    void delete(String id); 
}
