package com.accenture.springframeworktraining.springservice;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accenture.springframeworktraining.springservice.service.BookService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceContext.class)
public class ServiceContextTest {

	@Autowired
	protected BookService bookService;
	
	@Test
	public void testBookService() {
		Assert.assertNotNull(bookService);
	}

}