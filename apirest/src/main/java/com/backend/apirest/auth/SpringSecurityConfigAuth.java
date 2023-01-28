package com.backend.apirest.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SpringSecurityConfigAuth extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserDetailsService usuarioService;
  
  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
	  return new BCryptPasswordEncoder();
  }

  @Override
  @Autowired
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(this.usuarioService).passwordEncoder(passwordEncoder());
  }

  @Bean
  @Override
  protected AuthenticationManager authenticationManager() throws Exception {
	return super.authenticationManager();
  }
  
	@Override
	public void configure(HttpSecurity http) throws Exception {
      http
      .authorizeRequests().antMatchers(HttpMethod.POST,"/oauth/token").permitAll()
      .anyRequest().authenticated()      
      .and()
      .csrf().disable()
      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); 
	
	}
  


//    @Bean
//CorsConfigurationSource corsConfigurationSource() {
//	CorsConfiguration cc = new CorsConfiguration();
//           cc.setAllowedHeaders(Arrays.asList("Origin,Accept", "X-Requested-With", "Content-Type", "Access-Control-Request-Method", "Access-Control-Request-Headers","Authorization"));
//           cc.setExposedHeaders(Arrays.asList("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));                
//	cc.setAllowedOrigins(Arrays.asList("/*"));
//	cc.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS", "PUT","PATCH"));
//           cc.addAllowedOrigin("*");
//           cc.setMaxAge(Duration.ZERO);
//           cc.setAllowCredentials(Boolean.TRUE);
//	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	source.registerCorsConfiguration("/**", cc);
//	return source;
//}
  
}
