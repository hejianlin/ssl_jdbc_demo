package com.hejianlin.ssl_jdbc_demo;

import com.hejianlin.ssl_jdbc_demo.config.Params;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.File;

@SpringBootApplication(scanBasePackages = {"com.hejianlin.ssl_jdbc_demo"})
public class SslJdbcApplication {

	@Autowired
	Params params;

	public static void main(String[] args) {
		SpringApplication.run(SslJdbcApplication.class, args);
	}

	@PostConstruct
	void postConstruct(){
		File trustStoreFilePath = new File(params.trustStorePath);
		String tsp = trustStoreFilePath.getAbsolutePath();
		System.setProperty("javax.net.ssl.trustStore", tsp);
		System.setProperty("javax.net.ssl.trustStorePassword", params.trustStorePassword);
		System.setProperty("javax.net.ssl.keyStoreType", params.defaultType);
		File keyStoreFilePath = new File(params.keyStorePath);
		String ksp = keyStoreFilePath.getAbsolutePath();
		System.setProperty("Security.KeyStore.Location", ksp);
		System.setProperty("Security.KeyStore.Password", params.keyStorePassword);
	}
}
