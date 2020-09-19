package com.project.roombook.resources;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.roombook.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	@Query(value="select sum(b.amount) from book b where b.user_id=?1", nativeQuery = true)
	public int total(int user_id);
}
