package com.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)

 private Long id;
 private String email;
 private String password;
 private String fullName;
public String getEmail() {
	// TODO Auto-generated method stub
	return null;
   }
public Recipe getId() {
	// TODO Auto-generated method stub
	return null;
}
public String getPassword() {
	// TODO Auto-generated method stub
	return null;
}
public String getFullName() {
	// TODO Auto-generated method stub
	return null;
}
public void setFullName(String fullName2) {
	// TODO Auto-generated method stub
	
}
public void setEmail(String email2) {
	// TODO Auto-generated method stub
	
}
public void setPassword(String encode) {
	// TODO Auto-generated method stub
	
}


}
 




 
 
 
 
 

 
 

