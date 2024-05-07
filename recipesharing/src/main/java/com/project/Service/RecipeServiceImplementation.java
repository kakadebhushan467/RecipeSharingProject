package com.project.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Recipe;
import com.project.model.User;
import com.project.repository.RecipeRepository;

@Service
public class RecipeServiceImplementation implements RecipeService{
	
    @Autowired
	private RecipeRepository recipeRepository;

	@Override
	public Recipe createRecipeO(Recipe recipe, User user) {
		Recipe createdRecipe=new Recipe();
		createdRecipe.setTitle(recipe.getTitle());
		createdRecipe.setImage(recipe.getImage());
		createdRecipe.setDescription(recipe.getDescription());
		createdRecipe.setUser(user);
		createdRecipe.setCreatedAt(LocalDateTime.now());
		return recipeRepository.save(createdRecipe);
	}

	@Override
	public Recipe findRecipeById(Long id) throws Exception {
		Optional<Recipe> opt=recipeRepository.findById(id);
		
		if(opt.isPresent()) {
			return opt.get();
			}
		throw new Exception("recipe not found with id"+id);
		
	}

	@Override
	public void deleteRecipe(Long id) throws Exception {
     findRecipeById(id);
     recipeRepository.deleteById(id);
		
	}

	@Override
	public Recipe UpdateRecipe(Recipe recipe, Long id) throws Exception {
		Recipe oldRecipe=findRecipeById(id);
		
		if(recipe.getTitle()!=null) {
			oldRecipe.setTitle(recipe.getTitle());
		}
		
		if(recipe.getImage()!=null) {
			oldRecipe.setImage(recipe.getImage());
			}
		
		if(recipe.getDescription()!=null) {
			oldRecipe.setDescription(recipe.getDescription());
		}
		return recipeRepository.save(oldRecipe);
	}

	@Override
	public List<Recipe> findAllRecipe() {
		// TODO Auto-generated method stub
		return recipeRepository.findAll();
	}

	@Override
	public Recipe likeRecipe(Long recipeId, User user) throws Exception {
		Recipe recipe=findRecipeById(recipeId);
		
		if(recipe.getLikes().contains(user.getId())) {
			recipe.getLikes().remove(user.getId());
		}
		else {
			recipe.getLikes().add( user.getId());
		}
		return recipeRepository.save(recipe);
	}
}
