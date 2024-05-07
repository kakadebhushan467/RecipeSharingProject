package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe,Long>{

}
