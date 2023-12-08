//package com.project.springboot.security;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//import java.util.function.Function;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SpringSecurityConfiguration {
//	//LDAP or InMemory
//	// in Memory
//	//InMemoryUserDetailsManager 
//	//InMemoryUserDManager(UserDetails users)
//	public SpringSecurityConfiguration() {
//		System.out.println("____________________________________________________________________Hello i am in SpringSecurityConfiguration Class_________________+-=___________________________________");
//	}
//	
//	
//    @Bean
//    public UserDetailsManager userDetailsManager() {
//    	
//    	System.out.println("-------------------------------------------------------------------------In userDetailsManager method");
//    	
//        UserDetails build1 = createNewUser("anupam", "kumar");
//        UserDetails build2 = createNewUser("root", "root");
//        return new InMemoryUserDetailsManager(build1,build2);
//    }
//
//
//	private UserDetails createNewUser(String username, String password) {
//		Function<String, String> passwordEncoder
//				= input -> passwordEncoder().encode(input);
//
//		UserDetails build = User.builder()
//					        .passwordEncoder(passwordEncoder)		
//					        .username(username)
//					        .password(password)
//					        .roles("USER","ADMIN")
//					        .build();
//		return build;
//	}
//    
//	
//	 @Bean 
//	 public PasswordEncoder passwordEncoder() {
//		 return	new BCryptPasswordEncoder(); 
//	}
//	 
//	 @Bean
//	 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		 http.authorizeHttpRequests(
//				 auth -> auth.anyRequest().authenticated());
//		 http.formLogin(withDefaults());
//		 
//		 http.csrf().disable();
//		 http.headers().frameOptions().disable();
//		 
//		 return http.build();
//	 }
//	 
//	/*
//	 * @Bean public InMemoryUserDetailsManager createUserDetailsManager() {
//	 * UserDetails build = User.withDefaultPasswordEncoder() .username("anupam")
//	 * .password("kumar") .roles("USER","ADMIN") .build(); return new
//	 * InMemoryUserDetailsManager(build); }
//	 */	
//}
//
//
