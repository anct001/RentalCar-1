package rentalcar.com.service;

import java.util.List;

import rentalcar.com.entity.Category;

public interface CategoryService {

	List<Category> findAll();

	boolean existsById(String id);

	Category findById(String id);

	List<Category> findByName(String kw);

	Category save(Category cate);

	void deleteById(String id);

}
