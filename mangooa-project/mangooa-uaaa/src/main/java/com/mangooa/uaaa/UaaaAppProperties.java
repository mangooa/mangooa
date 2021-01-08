package com.mangooa.uaaa;

import com.mangooa.uaaa.radius.RadiusProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@ConfigurationProperties(prefix = "mangooa.uaaa")
public class UaaaAppProperties {

	@NestedConfigurationProperty
	private RadiusProperties radius = new RadiusProperties();

	public RadiusProperties getRadius() {
		return radius;
	}

	public void setRadius(RadiusProperties radius) {
		this.radius = radius;
	}
}
