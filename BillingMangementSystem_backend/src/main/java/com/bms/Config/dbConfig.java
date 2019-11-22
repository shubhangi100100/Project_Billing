package com.bms.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Component
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages= {"com.bms"})
public class dbConfig {
	
	DriverManagerDataSource dataSource= new DriverManagerDataSource();
	
	@Bean(name="DataSource")
	public DataSource getDataSource() {
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("project");
		dataSource.setPassword("shubhangi");
		return dataSource;
		
		
		
				}

	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory() {
		Properties p= new Properties();
		p.setProperty("hibernate.dailect","org.hibernate.dialect.Oracle10gDialect");
		p.setProperty("hibernate.hbm2ddl.auto","update");
		p.setProperty("hibernate.show_sql","true");
		
		
		
		LocalSessionFactoryBuilder sb= new LocalSessionFactoryBuilder(getDataSource());
		sb.addProperties(p);
		sb.scanPackages("com.bms");
		
		SessionFactory sf= sb.buildSessionFactory();
		return sf;
		
		
	}

	@Bean(name="hibernateTransaction")
	@Autowired
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager= new HibernateTransactionManager(sessionFactory);
		return txManager;
		
	}
}
