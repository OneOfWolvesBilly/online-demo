package io.github.oneofwolvesbilly.onlinedemo.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.ConnectionProperties;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * M2啟動設定與JPA設定
 * 
 * @author BillyChen
 *
 */


@Configuration
@EnableJpaRepositories(basePackages = "io.github.oneofwolvesbilly.onlinedemo.repository")
@PropertySource("classpath:application.yml")
@EnableTransactionManagement
public class ApplicationConfig {

	@Bean
	public DataSource dataSource() {
//return DataSourceBuilder.create().driverClassName(driverClassName).url(url).username(username).password(password).build();
		return new EmbeddedDatabaseBuilder()
			     .setType(EmbeddedDatabaseType.H2)
			     .setScriptEncoding("UTF-8")
			     .setName("devDB")
			     .addScript("db/schema.sql")
			     .addScript("db/data.sql")
			     .build();
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	
	  HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	  vendorAdapter.setGenerateDdl(true);
	  LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	  factory.setJpaVendorAdapter(vendorAdapter);
	  factory.setPackagesToScan("io.github.oneofwolvesbilly.onlinedemo.entity");
	  factory.setDataSource(dataSource());
	  return factory;
	}

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {

      JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
      jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
      return jpaTransactionManager;
    }

}
