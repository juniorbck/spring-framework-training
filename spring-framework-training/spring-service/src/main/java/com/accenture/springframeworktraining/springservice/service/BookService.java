package com.accenture.springframeworktraining.springservice.service;

import java.util.List;

import com.accenture.springframeworktraining.datamodel.Book;

public interface BookService {
	List<Book> findByTitle(String title);
}
