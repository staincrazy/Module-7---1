package org.epam.piatrenka.unit6.test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LoggerTest {
	
	@Test
	public void myLocalLOgger(){
		Logger logger = LogManager.getRootLogger();
		
		logger.debug("Debug message");
		logger.info("Info Message");
		logger.error("Error message");
		logger.fatal("Fatality");
		logger.warn("OMG");
		logger.trace("trace msg");
		
	}

}
