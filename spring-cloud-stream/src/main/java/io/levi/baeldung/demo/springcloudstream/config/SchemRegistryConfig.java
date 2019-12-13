package io.levi.baeldung.demo.springcloudstream.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.schema.registry.client.ConfluentSchemaRegistryClient;
import org.springframework.cloud.schema.registry.client.SchemaRegistryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchemRegistryConfig {

    @Bean
    public SchemaRegistryClient schemaRegistryClient(@Value("${spring.cloud.stream.kafka.binder.producer-properties.schema.registry.url}") String endPoint) {
        ConfluentSchemaRegistryClient client = new ConfluentSchemaRegistryClient();
        client.setEndpoint(endPoint);
        return client;
    }
}
