package config;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@EnableJpaRepositories(basePackages = {"system.dao"})
public class SpringDataJpaConfig {
  
//  @Bean
//  public DataSource dataSource() {
//	DruidDataSource dataSource = new DruidDataSource();
//	dataSource.setUrl("jdbc:mysql://localhost:3306/test");
//	dataSource.setPassword("");
//	dataSource.setUsername("root");
//    return dataSource;
//
//  }
  
//	@Bean
//	public JndiObjectFactoryBean dataSource() {
//	  JndiObjectFactoryBean jndiObjectFB = new JndiObjectFactoryBean();
//	  jndiObjectFB.setJndiName("jdbc/mysql");
//	  jndiObjectFB.setResourceRef(true);
//	  jndiObjectFB.setProxyInterface(javax.sql.DataSource.class);
//	  return jndiObjectFB;
//	}
  
//  @Bean
//  public HibernateJpaVendorAdapter jpaVendorAdapter() {
//    HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//    adapter.setDatabase(Database.MYSQL);
//    adapter.setShowSql(true);
//    adapter.setGenerateDdl(true);
//    adapter.setPrepareConnection(true);
//    return adapter;
//  }
//  
//  @Bean
//  public LocalContainerEntityManagerFactoryBean entityManagerFactory(
//          DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
//    LocalContainerEntityManagerFactoryBean emfb = 
//        new LocalContainerEntityManagerFactoryBean();
//    emfb.setDataSource(dataSource);
//    emfb.setJpaVendorAdapter(jpaVendorAdapter);
//    emfb.setPackagesToScan("system.entity");
//    return emfb;
//  }
//  
  @Bean
  public PersistenceAnnotationBeanPostProcessor paPostProcessor() {
    return new PersistenceAnnotationBeanPostProcessor();
  }
  
  @Bean
  public BeanPostProcessor persistenceTranslation() {
    return new PersistenceExceptionTranslationPostProcessor();
  }
//  @Bean
//  public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//	 JpaTransactionManager transactionManager = new JpaTransactionManager();
//	 transactionManager.setEntityManagerFactory(entityManagerFactory);
//	 return transactionManager;
//  }
}
