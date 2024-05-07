package com.project.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Recipe {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  
  private String title;
  @ManyToOne
  private User user;
  
  private String image;
  
  private String Description;
	
 private boolean vegitarian;
	
 private LocalDateTime createdAt;
	
 private List<Long>likes = new ArrayList<>();

public Object getDescription() {
	// TODO Auto-generated method stub
	return null;
}

public Object getImage() {
	// TODO Auto-generated method stub
	return null;
}

public Object getTitle() {
	// TODO Auto-generated method stub
	return null;
}

public void setTitle(Object title2) {
	// TODO Auto-generated method stub
	
}

public void setImage(Object image2) {
	// TODO Auto-generated method stub
	
}

public void setDescription(Object description2) {
	// TODO Auto-generated method stub
	
}

public void setCreatedAt(LocalDateTime now) {
	// TODO Auto-generated method stub
	
}

public void setUser(User user2) {
	// TODO Auto-generated method stub
	
}

public List<Recipe> getLikes() {
	// TODO Auto-generated method stub
	return null;
}
}
