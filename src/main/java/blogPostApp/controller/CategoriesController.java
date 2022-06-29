package blogPostApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import blogPostApp.dto.CategoriesDTO;
import blogPostApp.service.CategoryServiceImpel;

@RestController
@RestControllerAdvice
@RequestMapping("/categories")
public class CategoriesController {
	
	@Autowired
	private CategoryServiceImpel CategoryService;
	
	@PostMapping("/add")
	public ResponseEntity<CategoriesDTO> CreateNewCategoryController(@RequestBody CategoriesDTO categoryDto)
	{
		CategoriesDTO savedCategory = this.CategoryService.createNewCategory(categoryDto);
		return new ResponseEntity<CategoriesDTO>(savedCategory,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/CategoryID/{id}")
	private ResponseEntity<CategoriesDTO> getCategoryByIdController(@PathVariable("id") Integer id)
	{
		CategoriesDTO category = this.CategoryService.getCategoryByID(id);
		return new ResponseEntity<CategoriesDTO>(category,HttpStatus.FOUND);
	}
	
	@GetMapping("/getall")
	private ResponseEntity<List<CategoriesDTO>> getALLCategoryController(Integer id)
	{
		List<CategoriesDTO> category = this.CategoryService.getAllCategories();
		return new ResponseEntity<List<CategoriesDTO>>(category,HttpStatus.FOUND);
	}
	
	@PutMapping("/update/{id}")
	private ResponseEntity<CategoriesDTO> updateCategoryController(@RequestBody CategoriesDTO categoryDto,@PathVariable("id") Integer id)
	{
		CategoriesDTO category = this.CategoryService.updateCategory(categoryDto, id);
		return new ResponseEntity<CategoriesDTO>(category,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	private ResponseEntity<Void> deleteCategoryController(@PathVariable("id") Integer id)
	{
		 this.CategoryService.deleteCategory(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	

}
