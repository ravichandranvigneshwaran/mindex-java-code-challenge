package com.mindex.challenge.config;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import de.bwaldvogel.mongo.MongoServer;
import de.bwaldvogel.mongo.backend.memory.MemoryBackend;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

// NOTE: Enables MongoDB for the class
@EnableMongoRepositories(basePackageClasses = EmployeeRepository.class)
@Configuration
public class MongoConfig{
    // NOTE: Prinmary implmementation of MongoOperations interface where are basic set of MongoDB operation can be performed
    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient) {
        return new MongoTemplate(mongoDbFactory(mongoClient));
    }

    // NOTE: Provides MongoDB database instance
    @Bean
    public MongoDbFactory mongoDbFactory(MongoClient mongoClient) {
        return new SimpleMongoClientDbFactory(mongoClient, "test");
    }

    // NOTE: Default meomorybackend for faking MongoDB for testing
    @Bean(destroyMethod="shutdown")
    public MongoServer mongoServer() {
        MongoServer mongoServer = new MongoServer(new MemoryBackend());
        mongoServer.bind();
        return mongoServer;
    }

    // NOTE: Implemented for internal connection pooling
    @Bean(destroyMethod="close")
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb:/" + mongoServer().getLocalAddress());
    }
}


