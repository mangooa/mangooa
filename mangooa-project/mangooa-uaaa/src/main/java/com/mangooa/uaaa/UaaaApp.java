package com.mangooa.uaaa;

import com.mangooa.web.WebApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SpringBootApplication
@EnableConfigurationProperties({UaaaAppProperties.class})
public class UaaaApp extends WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(UaaaApp.class);
	}
}
