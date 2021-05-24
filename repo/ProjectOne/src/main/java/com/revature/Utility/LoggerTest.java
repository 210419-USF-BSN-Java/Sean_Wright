package com.revature.Utility;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
 

public class LoggerTest {
	
	
	public static class Log4jHelloWorld {
	 
	    final static Logger logger = Logger.getLogger(Log4jHelloWorld.class);
	 
	    public static void main(String[] args)
	    {
	        //Configure logger
	        BasicConfigurator.configure();
	        logger.debug("Hello World!");
	    }
	}

}
