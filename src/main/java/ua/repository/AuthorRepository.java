package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{
	
	Author findByLastName(String lastName);

}
