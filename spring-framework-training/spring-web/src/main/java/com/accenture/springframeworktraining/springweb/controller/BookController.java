package com.accenture.springframeworktraining.springweb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.springframeworktraining.datamodel.Book;
import com.accenture.springframeworktraining.springservice.service.BookService;

@Controller
@RequestMapping(value = {"/book/"})
public class BookController {
	private static Logger LOGGER = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookService bookService;
	
    @RequestMapping("/form")  
    public ModelAndView showform(){  
        return new ModelAndView("form","command",new Book());  
    }  

    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public ModelAndView save(@ModelAttribute("book") Book book){  

		Book bookSaved = bookService.save(book);  
		LOGGER.info("book saved", bookSaved); 
        return new ModelAndView("redirect:/list");
    }  
      
    @RequestMapping("/list")  
    public ModelAndView viewbooks(){  
        List<Book> list=bookService.findAll();  
        return new ModelAndView("list","list",list);  
    }  
 
    @RequestMapping(value="/edit/{id}")  
    public ModelAndView edit(@PathVariable int id){  
        Book book=bookService.getEmpById(id);  
        return new ModelAndView("editform","command",book);  
    }  
      
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public ModelAndView editsave(@ModelAttribute("book") Book book){  
    	Book bookSaved = bookService.save(book);  
		LOGGER.info("book edited", bookSaved); 
        return new ModelAndView("redirect:/list");  
    }  

    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)  
    public ModelAndView delete(@PathVariable int id){  
    	bookService.deleteById(id);  
		LOGGER.info("book id deleted", id); 
        return new ModelAndView("redirect:/list");  
    }  
  
}  
