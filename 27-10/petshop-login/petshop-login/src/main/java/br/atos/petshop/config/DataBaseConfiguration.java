package br.atos.petshop.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataBaseConfiguration {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driverBanco = new DriverManagerDataSource();
		driverBanco.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driverBanco.setUrl("jdbc:mysql://bxwnpp8nokqze5fdme32-mysql.services.clever-cloud.com/bxwnpp8nokqze5fdme32");
		driverBanco.setUsername("uvcriwpsllcnited");
		driverBanco.setPassword("lyIhLOMX8kiTQU3Goir8");
		
		return driverBanco;
	}
	
	@Bean
	public JpaVendorAdapter hibernate() {
		HibernateJpaVendorAdapter hibernate = new HibernateJpaVendorAdapter();
		hibernate.setDatabase(Database.MYSQL);
		hibernate.setShowSql(true);
		hibernate.setGenerateDdl(true);
		hibernate.setDatabasePlatform("org.hibernate.dialect.MySQL8Dialect");
		hibernate.setPrepareConnection(true);
		
		return hibernate;
	}
}
