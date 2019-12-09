
package app.com.config;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.app.model.Document;
import com.app.model.Grn;
import com.app.model.OrderMethod;
import com.app.model.Purchase;
import com.app.model.Sale;
import com.app.model.ShipmentType;
import com.app.model.Shipping;
import com.app.model.Uom;
import com.app.model.WhUserType;

@Configuration
@PropertySource("classpath:app.properties")
@ComponentScan("com.app")
@EnableWebMvc //Active MVC Concept in Spring
@EnableTransactionManagement //Tx enabled
@Import(SecurityConfig.class)
public class AppConfig  implements WebMvcConfigurer{
	@Autowired
	private Environment env;

	//1. DataSource object
	@Bean
	public BasicDataSource dsObj() {
		BasicDataSource d=new BasicDataSource();
		d.setDriverClassName(env.getProperty("db.driver"));
		d.setUrl(env.getProperty("db.url"));
		d.setUsername(env.getProperty("db.un"));
		d.setPassword(env.getProperty("db.pwd"));
		return d;
	}
	//2. SessionFactory object
	@Bean
	public LocalSessionFactoryBean sf() {
		LocalSessionFactoryBean s=new LocalSessionFactoryBean();
		s.setDataSource(dsObj());//ref tag.
		s.setHibernateProperties(propObj());
		s.setAnnotatedClasses(Uom.class,ShipmentType.class,OrderMethod.class,WhUserType.class,Document.class,Purchase.class,Sale.class,Grn.class,Shipping.class);
		s.setPackagesToScan("com.app.model");
		return s;
	}
	//SAC
	@Bean
	public Properties propObj() {
		Properties p=new Properties();
		p.put("hibernate.dialect",env.getProperty("orm.dialect"));
		p.put("hibernate.show_sql",env.getProperty("orm.showsql"));
		p.put("hibernate.format_sql",env.getProperty("orm.fmtsql"));
		p.put("hibernate.hbm2ddl.auto",env.getProperty("orm.ddlauto"));
		return p;
	}

	//3. HibernateTemplate
	@Bean
	public HibernateTemplate ht() {
		HibernateTemplate ht=new HibernateTemplate();
		ht.setSessionFactory(sf().getObject());
		return ht;
	}

	//4. Hibernate Tx Manager
	@Bean
	public HibernateTransactionManager htxm() {
		HibernateTransactionManager h=new HibernateTransactionManager();
		h.setSessionFactory(sf().getObject());
		return h;
	}

	//5. View Resolver
	@Bean
	public InternalResourceViewResolver ivr() {
		InternalResourceViewResolver v=new InternalResourceViewResolver();
		v.setPrefix(env.getProperty("mvc.prefix"));
		v.setSuffix(env.getProperty("mvc.suffix"));
		return v;
	}

	//5.File uploading
	@Bean
	public CommonsMultipartResolver  multipartResolver() {
		return new CommonsMultipartResolver();

	}
	
	
	
	//7. Java Mail sender
		@Bean
		public JavaMailSenderImpl mailSender() {
			JavaMailSenderImpl m=new JavaMailSenderImpl();
			m.setHost(env.getProperty("email.host"));
			m.setPort(env.getProperty("email.port",Integer.class));
			m.setUsername(env.getProperty("email.un"));
			m.setPassword(env.getProperty("email.pwd"));
			m.setJavaMailProperties(emailProps());
			return m;
		}
		@Bean
		public Properties emailProps() {
			Properties p=new Properties();
			p.put("mail.smtp.auth", env.getProperty("email.auth"));
			p.put("mail.smtp.starttls.enable", env.getProperty("email.secure"));
			return p;
		}

	

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	//8. Password Encoder
		@Bean
		public BCryptPasswordEncoder encoder() {
			return new BCryptPasswordEncoder();
		}
		
		

}
