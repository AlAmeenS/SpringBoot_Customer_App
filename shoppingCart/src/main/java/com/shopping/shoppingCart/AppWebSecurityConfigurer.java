package com.shopping.shoppingCart;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.shopping.shoppingCart.filters.NewFilter;

@Configuration
/*@EnableWebSecurity*/
public class AppWebSecurityConfigurer extends WebSecurityConfigurerAdapter {
	
	
	@Bean
    @Override
	protected UserDetailsService userDetailsService() {
		// TODO Auto-generated method stub
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		User.UserBuilder userBuilder = User.builder().passwordEncoder(encoder :: encode);
		
		UserDetails user2 = userBuilder
				.username("AlAmeenS")
				.password("AlAmeenS")
				.roles("USER")
				.build();
		
		UserDetails user1 = userBuilder
				.username("AdminUser")
				.password("adminuser")
				.roles("USER", "ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user1,user2);
	}

	/*@Override
    protected void configure(HttpSecurity http) throws Exception {    
        http
            .csrf().disable()
            .authorizeRequests()
                .anyRequest().permitAll();
        http.headers().frameOptions().disable();
        }*/
    
    @Bean
    public FilterRegistrationBean<NewFilter> registrationBean(){
    	FilterRegistrationBean<NewFilter> filterRegistrationBean = new FilterRegistrationBean<NewFilter>();
    	filterRegistrationBean.setFilter(new NewFilter());
    	filterRegistrationBean.addUrlPatterns("/customer/addCustomer/*");
    	return filterRegistrationBean;
    }
}