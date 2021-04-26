package com.example.demo.securingweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("index");
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/hello").setViewName("hello");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/signout").setViewName("resgister");
		registry.addViewController("/add_img").setViewName("add_img");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	  if (!registry.hasMappingForPattern("/static/**")) {
	     registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	  }
	}

}