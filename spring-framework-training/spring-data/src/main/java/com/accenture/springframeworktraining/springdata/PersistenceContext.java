package com.accenture.springframeworktraining.springdata;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:application.properties" })
@EnableJpaRepositories(basePackages = "com.accenture.springframeworktraining.springdata.repository")
// @ComponentScan({ "com.accenture.springframeworktraining" })
public class PersistenceContext {

	protected static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
	protected static final String PROPERTY_NAME_DATABASE_URL = "db.url";
	protected static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";
	protected static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";

	@Autowired
	private Environment env;

	@Autowired
	private Properties hibernateProperties;

	// beans

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "com.accenture.springframeworktraining.datamodel" });

		final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(hibernateProperties);

		return em;
	}

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		BoneCPDataSource dataSource = new BoneCPDataSource();

		dataSource.setDriverClass(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
		dataSource.setJdbcUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
		dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
		dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));

		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

}