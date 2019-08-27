package br.gov.fazenda.mg.spring;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

@Order(1)
public class MyWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		// Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class);
        
        DelegatingFilterProxy filter1 = new DelegatingFilterProxy("springSecurityFilterChain");
        filter1.setServletContext(container);
        filter1.setContextAttribute("org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcher");        
        //container.addFilter("springSecurityFilterChain", filter1).addMappingForUrlPatterns(null, true, "/*");
        
        Dynamic securityFilter = container.addFilter(AbstractSecurityWebApplicationInitializer.DEFAULT_FILTER_NAME, filter1);
        securityFilter.addMappingForUrlPatterns(null, false, "/*");
        EnumSet<DispatcherType> setDispType = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD);
        securityFilter.addMappingForServletNames(setDispType, false, "");
               
        

        // Manage the lifecycle of the root application context
        container.addListener(new ContextLoaderListener(rootContext));
        
        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(WebAppConfig.class);
                              
        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher =  container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");     
	}
}