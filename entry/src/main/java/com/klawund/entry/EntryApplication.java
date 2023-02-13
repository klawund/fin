package com.klawund.entry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EntryApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(EntryApplication.class, args);
	}
}
