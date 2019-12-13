package io.levi.baeldung.demo.springcloudschemaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.schema.registry.EnableSchemaRegistryServer;

@SpringBootApplication
@EnableSchemaRegistryServer
public class SpringCloudSchemaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudSchemaServerApplication.class, args);
	}

}
