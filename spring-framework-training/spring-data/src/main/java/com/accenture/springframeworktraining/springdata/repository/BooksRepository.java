package com.accenture.springframeworktraining.springdata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.springframeworktraining.datamodel.Book;

public interface BooksRepository extends JpaRepository<Book, Integer> {

	public Book findByIsbn(String isbn);

	public List<Book> findByTitle(String title);

	public List<Book> findByTitleLike(String nombre);

}
