package com.rohit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.rohit.Alien;
import com.rohit.Computer;
import com.rohit.Desktop;
import com.rohit.Laptop;

@Configuration
@ComponentScan("com.rohit")
public class AppConfig {

//	@Bean
//	public Alien alien(@Qualifier("laptop") Computer com) {
//		Alien obj = new Alien();
//		obj.setAge(25);
//		obj.setCom(com);
//		return obj;
//	}
//	
//	@Bean
//	@Scope("prototype")
//	public Desktop desktop() {
//		return new Desktop();
//	}
//	
//	@Bean
//	@Primary
//	public Laptop laptop() {
//		return new Laptop();
//	}

}
