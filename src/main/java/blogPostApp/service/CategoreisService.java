package blogPostApp.service;

import java.util.List;

import blogPostApp.dto.CategoriesDTO;
import blogPostApp.entity.Categories;


public interface CategoreisService {
	
	List<CategoriesDTO>getAllCategories();
	 
	CategoriesDTO createNewCategory(CategoriesDTO category);
	 
	CategoriesDTO getCategoryByID(Integer CaategoryId);
	 
	CategoriesDTO updateCategory(CategoriesDTO category,Integer id);
	 
	 void deleteCategory(Integer categoryId);

}
