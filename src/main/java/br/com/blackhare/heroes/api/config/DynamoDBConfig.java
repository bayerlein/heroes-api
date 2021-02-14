package br.com.blackhare.heroes.api.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class DynamoDBConfig {

    @Autowired
    private Environment environment;

    @Bean
    public DynamoDBMapper mapper() {
        return new DynamoDBMapper(amazonConfig());
    }

    private AmazonDynamoDB amazonConfig() {
        return AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration("dynamodb.sa-east-1.amazonaws.com", "sa-east-1"))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(environment.getProperty("access"), environment.getProperty("secret"))))
                .build();
    }
}
