package com.project.Service;

import java.util.List;

import com.project.model.Recipe;
import com.project.model.User;

public interface RecipeService {
	
	public Recipe createRecipeO(Recipe recipe,User user);
	
	public  Recipe findRecipeById(Long id)throws Exception;
	
	public void deleteRecipe(Long id)throws Exception;
	
	public Recipe UpdateRecipe(Recipe recipe,Long Id)throws Exception;
	
	public List<Recipe>findAllRecipe();
	
	public Recipe likeRecipe(Long recipeId,User user)throws Exception;
}
