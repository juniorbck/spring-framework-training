package com.accenture.springframeworktraining.springservice;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.accenture.springframeworktraining.springdata.PersistenceContext;

@Configuration
@Import(PersistenceContext.class) //Import config class from spring-data
@ComponentScan(basePackages = "com.accenture.springframeworktraining.springservice.service")
public class ServiceContext {

}
