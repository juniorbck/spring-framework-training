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

	public Book save(Book book) {
		return bookRepository.save(book);
	}

	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	public Book getEmpById(int id) {
		return bookRepository.findOne(id);
	}

	public void deleteById(int id) {
		bookRepository.delete(id);
		return;
	}

}
