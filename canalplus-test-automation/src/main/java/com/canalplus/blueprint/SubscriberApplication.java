package com.canalplus.blueprint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.canalplus.blueprint")
public class SubscriberApplication extends SpringBootServletInitializer {

    protected final Logger log = LogManager.getLogger(getClass());

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	return application.sources(SubscriberApplication.class);
    }

    public static void main(String[] args) {
	SpringApplication.run(SubscriberApplication.class, args);
    }

}
