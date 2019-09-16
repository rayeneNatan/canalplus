package com.canalplus.blueprint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.Before;

/**
 * Class so the cucumber will use spring application context while running
 * cucumber
 */
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = SubscriberApplication.class, loader = SpringBootContextLoader.class)
public class SpringContextConfiguration {

    protected final Logger log = LogManager.getLogger(getClass());

    @Before
    public void setUp() {
	log.info("*** Spring Context Initialized For Executing Cucumber Tests ***");
    }

}
