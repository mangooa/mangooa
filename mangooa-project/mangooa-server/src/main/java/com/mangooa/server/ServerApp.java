package com.mangooa.server;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * 服务器应用。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Slf4j
@SpringBootApplication
@EnableConfigurationProperties({ServerAppProperties.class})
public class ServerApp {

	public static void main(String[] args) {
		SpringApplication.run(ServerApp.class, args);
	}
}
