package com.example.studentclass;

import jakarta.persistence.*; 
import lombok.AllArgsConstructor; 
import lombok.Data; 
import lombok.Getter; 
import lombok.NoArgsConstructor; 
import lombok.Setter; 

@Data 
@Entity 
@Getter 
@Setter 
@Table(name = "studentclass_new") 
@AllArgsConstructor 
@NoArgsConstructor 

public class Studentclass {
    @Id 
	private String id; 
	private String name; 
	private String email; 
	private Integer age;

}
