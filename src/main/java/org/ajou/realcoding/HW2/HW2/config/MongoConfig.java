package org.ajou.realcoding.HW2.HW2.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {
    @Bean
    public MongoTemplate creatMongoTemplate(){
        return new MongoTemplate(new MongoClient(),"Lol-service");
    }
}
