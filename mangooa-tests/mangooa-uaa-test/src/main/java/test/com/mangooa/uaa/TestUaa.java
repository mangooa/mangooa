package test.com.mangooa.uaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@ComponentScan({"com.mangooa"})
@EntityScan({"com.mangooa.uaa"})
@SpringBootApplication
public class TestUaa {

	public static void main(String[] args) {
		SpringApplication.run(TestUaa.class, args);
	}
}
