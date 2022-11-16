package com.steps;

import java.io.IOException;

import com.utils.ReusableMthods;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GHTest {
	
	ReusableMthods reuse= null;
	@Before
	public void setupdata() throws IOException
	{
		reuse=new ReusableMthods();
		reuse.setapiinit();
		System.out.println("Base URI:::::"+RestAssured.baseURI);
		
	}
	@Given("check the given {string} in github")
	public void check_the_given_in_github(String string) {
	    System.out.println(":::::::check_the_given_in_github:::::");
	    System.out.println("::::::::::");
	   /* given().headers( "Authorization", "Bearer " + reuse.ghtoken, "Content-Type",
		           ContentType.JSON, "Accept",ContentType.JSON).
		   when().get(reuse.apiresourc("read", string)).
		   then().log().body().statusCode(200);*/
	   
	}
	@When("{string} does not exist")
	public void does_not_exist(String string) {
		
		given().headers( "Authorization", "Bearer " + reuse.ghtoken, "Content-Type",
		           ContentType.JSON, "Accept",ContentType.JSON).
		   when().get(reuse.apiresourc("read", string)).
		   then().log().body().statusCode(200);
		System.out.println(":::::::does_not_exist:::::");
	}
	@Then("create the give {string}")
	public void create_the_give(String string) throws IOException {
		  System.out.println(":::::::create_the_give:::::");
			Response responce = given().log().all().headers( "Authorization",  "Bearer " + reuse.ghtoken, "Content-Type",
			           ContentType.JSON, "Accept",ContentType.JSON).body(reuse.apipayload("create")).
			   when().post(reuse.apiresourc("create", string)).
			 then().log().body().statusCode(201).extract().response();
								  System.out.println(":::::::End::::create_repo_post::::::::::"); }

	@Then("Add file to {string}")
	public void add_file_to(String string) throws IOException {
		  System.out.println(":::::::add_file_to:::::");
		  given().log().all().headers( "Authorization", "Bearer " + reuse.ghtoken, "Content-Type",
		           ContentType.JSON, "Accept",ContentType.JSON).body(reuse.apipayload("addfile")).
		   when().put(reuse.apiresourc("addfile", string)).
		 then().log().body().statusCode(201);
   	
		
	 
	}
	@Then("modift the {string}")
	public void modift_the(String string) throws IOException {
		  System.out.println(":::::::modift_the:::::");
		  given().log().all().headers( "Authorization", "Bearer " + reuse.ghtoken, "Content-Type",
		           ContentType.JSON, "Accept",ContentType.JSON).body(reuse.apipayload("update")).
		 when().patch(reuse.apiresourc("update", string)).
		 then().log().body().statusCode(200);
	  
	}
	@Then("Delete the {string}")
	public void delete_the(String string) throws IOException {
		  System.out.println(":::::::delete_the:::::");
		  
			 System.out.println(":::::::Strat::::delete_Repo::::::::::");
			 given().log().all().headers( "Authorization", "Bearer " + reuse.ghtoken, "Content-Type",
			           ContentType.JSON, "Accept",ContentType.JSON).
			   when().delete(reuse.apiresourc("delete", string)).
			 then().log().body().statusCode(204);
			  System.out.println(":::::::End::::delete_Repo::::::::::");
	}

}
