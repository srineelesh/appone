package com.intv.appone;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Path;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.ResourceProvider;
import org.apache.cxf.jaxrs.spring.SpringResourceFactory;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import com.intv.appone.util.TomcatConfigurationUtil;

@SpringBootApplication
@ImportResource({ "classpath:META-INF/cxf/cxf.xml", "classpath:META-INF/cxf/cxf-servlet.xml" })
@Import({TomcatConfigurationUtil.class})
public class ApponeApplication {

	private static final String SERVICE_CONTEXT = "service";
	

	@Autowired
	private ApplicationContext ctx;

	public static void main(String[] args) {
		SpringApplication.run(ApponeApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean cxfServletRegistrationBean() {
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new CXFServlet(),
				"/" + SERVICE_CONTEXT + "/*");
		registrationBean.setAsyncSupported(true);
		registrationBean.setLoadOnStartup(1);
		registrationBean.setName("CXFServlet");
		return registrationBean;
	}

	@Bean
	public Server jaxRsServer() {
		List<ResourceProvider> resourceProviders = new LinkedList<ResourceProvider>();
		for (String beanName : ctx.getBeanDefinitionNames()) {
			if (ctx.findAnnotationOnBean(beanName, Path.class) != null) {
				SpringResourceFactory factory = new SpringResourceFactory(beanName);
				factory.setApplicationContext(ctx);
				resourceProviders.add(factory);
			}
		}
		if (resourceProviders.size() > 0) {
			JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
			factory.setBus(ctx.getBean(SpringBus.class));
			factory.setProviders(Arrays.asList(new JacksonJsonProvider()));
			factory.setResourceProviders(resourceProviders);
			return factory.create();
		} else {
			return null;
		}
	}

}
