package com.steps;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.*;


import com.utils.ReusableMthods;



public class JunitTester {
	
	static ReusableMthods reuseMethod;
	
	 @Test
	    public void test_method_2() throws IOException {
	        System.out.println("@Test - test_method_2");
	     

	        //read data from local JSON file then store in byte array
	        byte[] b = Files.readAllBytes(Paths.get("./src/test/java/com/apiresource/gitcreate.json"));
           //convert byte array to string
	        String bdy = new String(b);
            System.out.println("::::File pay load:::"+bdy);
	     		
	     	}
	
   
 @Before
	public void before_setup() throws Exception {
		System.out.println(":::::::::Test data setup ready::::::::");
		
			try {
				//reuseMethod = new ReusableMthods();
				//reuseMethod.setapiinit();
				/*
				 * System.out.println("GH Token ::"+reuseMethod.ghtoken);
				 * System.out.println("End point ::"+RestAssured.baseURI );
				 */
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
 }
			@BeforeClass
		    public static void runOnceBeforeClass() {
		        System.out.println("@BeforeClass - runOnceBeforeClass");
		    }

		    // Run once, e.g close connection, cleanup
		    @AfterClass
		    public static void runOnceAfterClass() {
		        System.out.println("@AfterClass - runOnceAfterClass");
		    }

		    // Should rename to @BeforeTestMethod
		    // e.g. Creating an similar object and share for all @Test
		    @Before
		    public void runBeforeTestMethod() {
		        System.out.println("@Before - runBeforeTestMethod");
		    }

		    // Should rename to @AfterTestMethod
		    @After
		    public void runAfterTestMethod() {
		        System.out.println("@After - runAfterTestMethod");
		    }

}
