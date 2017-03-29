package ua.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
	
	@Query("SELECT b FROM Book b LEFT JOIN FETCH b.author LEFT JOIN FETCH b.category")
	List<Book> findAll();

	@Query("SELECT b FROM Book b LEFT JOIN FETCH b.author LEFT JOIN FETCH b.category WHERE b.id=:id")
	Book findOne(@Param("id")Long id);

	@Query(value="SELECT DISTINCT b FROM Book b LEFT JOIN FETCH b.author LEFT JOIN FETCH b.category", 
			countQuery="SELECT count (b.id) FROM Book b")
	Page<Book> findAll(Pageable pageable);
	
	

}
