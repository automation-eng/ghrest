package com.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Logtest {
	static  Logger  log= LogManager.getLogger(Logtest.class.getName());  
	   public static void main(String[] args) {
		   
				  log.info("5 is in info");
				  log.debug("5 is in debug ");
		          log.error("5 is eligible for voting");
		     	  log.fatal("5 v good voting");
}
}
