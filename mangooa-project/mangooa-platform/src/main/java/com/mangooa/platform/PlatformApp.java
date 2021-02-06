package com.mangooa.platform;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@EnableConfigurationProperties(value = {PlatformProperties.class})
@SpringBootApplication
public class PlatformApp {
}
