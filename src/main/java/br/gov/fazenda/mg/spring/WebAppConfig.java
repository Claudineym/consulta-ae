package br.gov.fazenda.mg.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@Configuration
@EnableWebMvc
@EnableSpringDataWebSupport
@ComponentScan({"br.gov.fazenda.mg.spring","br.gov.fazenda.mg.controller","br.gov.fazenda.mg.service", "br.gov.fazenda.mg.domain"})
@Import({ WebSecurityConfig.class })
public class WebAppConfig implements WebMvcConfigurer{	
	
	/*@Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
       registry.jsp("/WEB-INF/pages/", ".jsp");       
    }*/
		
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		//viewResolver.setOrder(1);
		return viewResolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
		
}


