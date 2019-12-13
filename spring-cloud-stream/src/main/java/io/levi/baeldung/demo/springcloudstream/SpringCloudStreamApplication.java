package io.levi.baeldung.demo.springcloudstream;

import io.levi.baeldung.demo.springcloudstream.productor.AvroProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.schema.registry.client.EnableSchemaRegistryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableBinding(Processor.class)
@EnableSchemaRegistryClient

public class SpringCloudStreamApplication {

	@Autowired
	private AvroProducer avroProducer;

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamApplication.class, args);
	}


	@PostMapping("/employees/{id}/{firstName}/{lastName}")
	public String producerAvroMessage(@PathVariable int id, @PathVariable String firstName,
									  @PathVariable String lastName) {
		avroProducer.produceEmployeeDetails(id, firstName, lastName);
		return "Sent employee details to consumer";
	}
}
