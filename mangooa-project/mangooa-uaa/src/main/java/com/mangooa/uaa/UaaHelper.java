package com.mangooa.uaa;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Component
public class UaaHelper {

	private Environment environment;

	public UaaHelper(Environment environment){
		this.environment = environment;
	}



}
