package com.hejianlin.ssl_jdbc_demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("params")
@Data
public class Params {
    public String trustStorePath="config/truststore.jks";
    public String trustStorePassword="123456";
    public String keyStorePath = "config/keystore.jks";
    public String keyStorePassword = "123456";
    public String defaultType = "JKS";
}
