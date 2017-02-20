package com.accenture.springframeworktraining.springservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.springframeworktraining.datamodel.Book;
import com.accenture.springframeworktraining.springdata.repository.BooksRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BooksRepository bookRepository;

	public List<Book> findByTitle(String title) {
		return bookRepository.findByTitleLike(title);
	}

}
