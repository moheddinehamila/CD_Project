package com.example.app;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
@Entity
public class User {
    private Long id;
    private String name;
    private int age;
    protected User() {
    }
    
    
 


	public User(Long id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}





	public int getAge() {
		return age;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public void setAge(int age) {
		this.age = age;
	}





	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


 
}