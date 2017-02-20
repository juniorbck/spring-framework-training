package com.accenture.springframeworktraining.springdata.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.accenture.springframeworktraining.datamodel.Book;
import com.accenture.springframeworktraining.springdata.PersistenceContextTest;

public class BooksRepositoryTest extends PersistenceContextTest {

	@Test
	public void count() {

		long numberBooks = bookRepository.count();
		Assert.assertTrue(numberBooks > 0);
	}

	@Test
	public void findAllBooks() {
		List<Book> books = bookRepository.findAll();
		Assert.assertFalse(books.isEmpty());
	}

	@Test
	public void findByTitle() {
		String titleExpected = "Java";
		List<Book> books = bookRepository.findByTitle(titleExpected);
		String titleActual = books.get(0).getTitle();
		Assert.assertTrue(titleActual.contains(titleExpected));
	}
}
