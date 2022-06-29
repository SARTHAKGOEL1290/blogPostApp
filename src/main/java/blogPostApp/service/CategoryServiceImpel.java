package blogPostApp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blogPostApp.dto.CategoriesDTO;
import blogPostApp.entity.Categories;
import blogPostApp.exception.ResourceNotFoundException;
import blogPostApp.repository.CategoriesRepository;

@Service
public class CategoryServiceImpel implements CategoreisService {

	@Autowired
	private CategoriesRepository categoryRepo;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Override
	public List<CategoriesDTO> getAllCategories() {
		// TODO Auto-generated method stub
		List<Categories> category = this.categoryRepo.findAll();
		List<CategoriesDTO> listOfCategory= category.stream().map((e)->this.modelmapper.map(e,CategoriesDTO.class)).collect(Collectors.toList());
		return listOfCategory;
	}

	@Override
	public CategoriesDTO createNewCategory(CategoriesDTO categoryDto) {
		// TODO Auto-generated method stub
		Categories category = this.modelmapper.map(categoryDto,Categories.class);
		Categories savedCategory = this.categoryRepo.save(category);
		return this.modelmapper.map(savedCategory,CategoriesDTO.class);
	}

	@Override
	public CategoriesDTO getCategoryByID(Integer CaategoryId) {
		// TODO Auto-generated method stub
		Categories category = this.categoryRepo.findById(CaategoryId).orElseThrow(()-> new ResourceNotFoundException("categgory","id",CaategoryId));
		return this.modelmapper.map(category,CategoriesDTO.class);
	}

	@Override
	public CategoriesDTO updateCategory(CategoriesDTO category, Integer id) {
		// TODO Auto-generated method stub
		
		Categories categeorry = this.categoryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("categgory","id",id));
		categeorry.setCategoryDescription("This is high level code");
		
		
		Categories savedCategory = this.categoryRepo.save(categeorry);
		return this.modelmapper.map(savedCategory,CategoriesDTO.class);
		
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		Categories cate = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("categgory","id",categoryId));
		this.categoryRepo.delete(cate);
	}

}
