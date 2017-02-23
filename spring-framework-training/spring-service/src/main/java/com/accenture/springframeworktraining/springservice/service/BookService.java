package com.accenture.springframeworktraining.springservice.service;

import java.util.List;

import com.accenture.springframeworktraining.datamodel.Book;

public interface BookService {
	List<Book> findByTitle(String title);

	Book save(Book book);

	List<Book> findAll();

	Book getEmpById(int id);

	void deleteById(int id);
}
