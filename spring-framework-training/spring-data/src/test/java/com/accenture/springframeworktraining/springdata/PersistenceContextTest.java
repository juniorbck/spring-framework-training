package com.accenture.springframeworktraining.springdata;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accenture.springframeworktraining.springdata.PersistenceContext;
import com.accenture.springframeworktraining.springdata.repository.BooksRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceContext.class)
public class PersistenceContextTest {

	@Autowired
	protected BooksRepository bookRepository;

	@Test
	public void testBookRepository() {
		Assert.assertNotNull(bookRepository);
	}
}
