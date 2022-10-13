package com.joelmartinez.notificationservice.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;

@Configuration
public class AwsSnsConfiguration {

    @Value("${aws.sns.clientId}")
    private String clientId;

    @Value("${aws.sns.clientSecret}")
    private String clientSecret;

    private AwsBasicCredentials awsBasicCredentials() {
        return AwsBasicCredentials.create(clientId, clientSecret);
    }

    @Bean
    public SnsClient snsClient() {
        return SnsClient.builder()
                .credentialsProvider(this::awsBasicCredentials)
                .region(Region.US_EAST_2)
                .build();
    }

}
