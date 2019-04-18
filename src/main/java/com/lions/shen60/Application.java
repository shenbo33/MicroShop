package com.lions.shen60;

import com.lions.shen60.header.base.factory.BaseRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.lions.shen60", repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class )
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(Application.class);
		springApplication.run(args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
		return builder.sources(Application.class);
	}

}
