package config;

import org.apache.kafka.streams.StreamsConfig;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public StreamsConfig getStreamConfig(KafkaProperties properties){
        return new StreamsConfig(properties.buildStreamsProperties());
    }
}
