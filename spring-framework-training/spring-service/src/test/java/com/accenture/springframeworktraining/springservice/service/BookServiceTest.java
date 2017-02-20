package com.accenture.springframeworktraining.springservice.service;

import java.util.List;
import java.util.function.Consumer;

import org.junit.Assert;
import org.junit.Test;

import com.accenture.springframeworktraining.datamodel.Book;
import com.accenture.springframeworktraining.springservice.ServiceContextTest;

public class BookServiceTest extends ServiceContextTest {

	@Test
	public void findByTitle() {

		final String titleExpected = "Java";

		List<Book> books = bookService.findByTitle(titleExpected);

		books.forEach(new Consumer<Book>() {
			public void accept(Book book) {
				String titleActual = book.getTitle();
				System.out.println(titleActual);
				Assert.assertTrue(titleActual.contains(titleExpected));
			}
		});

	}

}
