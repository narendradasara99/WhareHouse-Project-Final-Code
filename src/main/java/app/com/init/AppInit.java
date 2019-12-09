package app.com.init;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import app.com.config.AppConfig;
public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {AppConfig.class};
	}

	
	  @Override protected Class<?>[] getServletConfigClasses()
	  { return null; }
	 
	 
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
