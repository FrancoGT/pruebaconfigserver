package com.config.server.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ApplicationConfig {

    @ConfigurationProperties(prefix = "server")
    @Bean
    @Profile("default")
    public ServerProperties serverProperties() {
        return new ServerProperties();
    }

    public static class ServerProperties {
        private int port = 8091;

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }
    }
}