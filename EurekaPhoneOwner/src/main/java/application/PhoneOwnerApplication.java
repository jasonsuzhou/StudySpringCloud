package application;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
public class PhoneOwnerApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(PhoneOwnerApplication.class).web(true).run(args);
	}

}
