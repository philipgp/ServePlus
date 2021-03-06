package com.serveplus;

import java.util.Properties;

import javax.sql.DataSource;
import javax.transaction.TransactionManager;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
@Configuration
public class DbConfig {
	
	/*@Bean()
	public DataSource dataSource(){
		DriverManagerDataSource dmDS = new DriverManagerDataSource();
		dmDS.setDriverClassName("org.h2.Driver");
		dmDS.setUrl("jdbc:h2:tcp://localhost/~/test2");
		dmDS.setUsername("sa");
		//dmDS.setPassword("test");
		return dmDS;
	}*/
	@Bean()
	public DataSource dataSource(){
		DriverManagerDataSource dmDS = new DriverManagerDataSource();
		dmDS.setDriverClassName("com.mysql.jdbc.Driver");
		dmDS.setUrl("jdbc:mysql://localhost:56167/serveplus");
		dmDS.setUsername("adminmgM4N9Z");
		dmDS.setPassword("byW3CqM8p4Hg");
		return dmDS;
	}
	
	@Bean()
	public HibernateTransactionManager txManager() throws Exception{
		HibernateTransactionManager hibernateTxManager = new HibernateTransactionManager();
		hibernateTxManager.setSessionFactory(sessionFactory());
		return hibernateTxManager;
	}
	@Bean
	public  SessionFactory sessionFactory() throws Exception{ 
		LocalSessionFactoryBean sessionFactory =  new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com");
		Properties hibernateProperties= new Properties();
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		//hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "auto");
		hibernateProperties.setProperty("hibernate.current_session_context_class", "thread");
		
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		sessionFactory.setHibernateProperties(hibernateProperties);
		String mappingResources;
/*		ClassPathResource classPathResource1 = new ClassPathResource("com/splus/pojo/User.hbm.xml");
		ClassPathResource classPathResource2 = new ClassPathResource("com/splus/pojo/Role.hbm.xml");
		ClassPathResource classPathResource3 = new ClassPathResource("com/splus/pojo/Department.hbm.xml");
		ClassPathResource classPathResource4 = new ClassPathResource("com/splus/pojo/Type.hbm.xml");
		ClassPathResource classPathResource5 = new ClassPathResource("com/splus/pojo/Registration.hbm.xml");
		ClassPathResource classPathResource6 = new ClassPathResource("com/splus/pojo/RegnStatus.hbm.xml");
		ClassPathResource classPathResource7 = new ClassPathResource("com/splus/pojo/UserSession.hbm.xml");
		
		ClassPathResource classPathResource8 = new ClassPathResource("com/splus/pojo/WorkerType.hbm.xml");
		ClassPathResource classPathResource9 = new ClassPathResource("com/splus/pojo/CompanyType.hbm.xml");
		
		
		ClassPathResource classPathResource10 = new ClassPathResource("com/splus/pojo/CompanyVoucher.hbm.xml");
		ClassPathResource classPathResource11 = new ClassPathResource("com/splus/pojo/UserCompany.hbm.xml");
		ClassPathResource classPathResource12= new ClassPathResource("com/splus/pojo/UserRegSession.hbm.xml");
		ClassPathResource classPathResource13 = new ClassPathResource("com/splus/pojo/ForgotUser.hbm.xml");
		ClassPathResource classPathResource14 = new ClassPathResource("com/splus/pojo/RegnHistory.hbm.xml");
		ClassPathResource classPathResource15= new ClassPathResource("com/splus/pojo/Feedback.hbm.xml");
		ClassPathResource classPathResource16 = new ClassPathResource("com/splus/pojo/RatingQuestion.hbm.xml");
		
		ClassPathResource classPathResource17 = new ClassPathResource("com/splus/pojo/Rating.hbm.xml");
		ClassPathResource classPathResource18 = new ClassPathResource("com/splus/pojo/NotificationKey.hbm.xml");
		ClassPathResource classPathResource19 = new ClassPathResource("com/splus/pojo/Notification.hbm.xml");
		ClassPathResource classPathResource20 = new ClassPathResource("com/splus/pojo/HostProp.hbm.xml");
		*/
		//sessionFactory.setMappingLocations(classPathResource1,classPathResource2,classPathResource3,classPathResource4,classPathResource5,classPathResource6,classPathResource7,classPathResource8,classPathResource9,classPathResource10,classPathResource11,classPathResource12,classPathResource13,classPathResource14,classPathResource15,classPathResource16,classPathResource17,classPathResource18,classPathResource19,classPathResource20);
		try{
			sessionFactory.afterPropertiesSet();
		}catch(Exception e){
			e.printStackTrace();
		}
		SessionFactory sessionF = (SessionFactory) sessionFactory.getObject();
		return sessionF;
	}
}
