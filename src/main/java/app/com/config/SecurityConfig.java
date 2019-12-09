package app.com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig 
	extends WebSecurityConfigurerAdapter
{
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private UserDetailsService service;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
		auth.userDetailsService(service)
		.passwordEncoder(encoder);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		 * Disable CSRF (cross site request forgery)
		 */
		 http.csrf().disable();
		/*
		 * if not disable then we will get Error like example >>> Description The server
		 * understood the request but refuses to authorize it.
		 */
		/*
		 * end
		 */
		http.authorizeRequests()
		.antMatchers("/user/login","/user/register","/user/save").permitAll()
				
				
				  .antMatchers("/uom/**").hasAnyAuthority("ADMIN","APPUSER")
				  .antMatchers("/ordermethod/**").hasAnyAuthority("ADMIN","APPUSER")
				  .antMatchers("/part/**").hasAnyAuthority("ADMIN","APPUSER")
				  .antMatchers("/ship/**").hasAnyAuthority("ADMIN","APPUSER")
				  .antMatchers("/whuser/**").hasAnyAuthority("ADMIN","APPUSER")
				  .antMatchers("/purchase/**").hasAnyAuthority("ADMIN","APPUSER")
				  .antMatchers("/grn/**").hasAnyAuthority("ADMIN","APPUSER")
				  .antMatchers("/sale/**").hasAnyAuthority("ADMIN","APPUSER")
				  .antMatchers("/shipping/**").hasAnyAuthority("ADMIN","APPUSER")
				  .antMatchers("/document/**").hasAnyAuthority("ADMIN","APPUSER")
				 
				 
		.anyRequest().authenticated()
		
		
		.and()
		.formLogin()
		.loginPage("/user/login") //It will show Login page 
		.loginProcessingUrl("/login") //on click login it will be called
		.defaultSuccessUrl("/uom/register",true) //on login success it wil be executed
		.failureUrl("/user/login?error").permitAll() //on login failure .. 
		
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) //Logout URL
		.logoutSuccessUrl("/user/login?logout").permitAll(); //on logout success
		
		
		
	
	}
	
	
	
}





