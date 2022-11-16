package com.steps;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GHCred {


	public static String token = "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";
	public static String reponame ="Rest5" ;
	
	public static String createrepo ="{\r\n"
			+ "    \"name\": \""+reponame+"\", \r\n"
			+ "    \"description\": \"This is Myfirst RESt3 first repository\",\r\n"
			+ "    \"homepage\": \"https://github.com\",\r\n"
			+ "    \"private\": false,\r\n"
			+ "    \"has_issues\": true,\r\n"
			+ "    \"has_projects\": true,\r\n"
			+ "    \"has_wiki\": true,\r\n"
			+ "    \"allow_squash_merge\": true\r\n"
			+ "\r\n"
			+ "}" ;
	
	public static String updaterepo ="{\r\n"
			+ "    \"name\": \""+reponame+"\",\r\n"
			+ "	\"description\": \"This is Myfirst Rest6 updated repository\",\r\n"
			+ "	\"homepage\": \"https://google.com\",\r\n"
			+ "	\"private\": false,\r\n"
			+ "	\"has_issues\": true,\r\n"
			+ "	\"has_projects\": true,\r\n"
			+ "	\"has_wiki\": true,\r\n"
			+ "    \"allow_squash_merge\" : true\r\n"
			+ "}" ;
	public static String content ="cGFja2FnZSBjb20uZ0h1YmFwcC5naGFwaTsKCmltcG9ydCBqdW5pdC5mcmFtZXdvcmsuVGVzdDsKaW1wb3J0IGp1bml0LmZyYW1ld29yay5UZXN0Q2FzZTsKaW1wb3J0IGp1bml0LmZyYW1ld29yay5UZXN0U3VpdGU7CgovKioKICogVW5pdCB0ZXN0IGZvciBzaW1wbGUgQXBwLgogKi8KcHVibGljIGNsYXNzIEFwcFRlc3QgCiAgICBleHRlbmRzIFRlc3RDYXNlCnsKICAgIC8qKgogICAgICogQ3JlYXRlIHRoZSB0ZXN0IGNhc2UKICAgICAqCiAgICAgKiBAcGFyYW0gdGVzdE5hbWUgbmFtZSBvZiB0aGUgdGVzdCBjYXNlCiAgICAgKi8KICAgIHB1YmxpYyBBcHBUZXN0KCBTdHJpbmcgdGVzdE5hbWUgKQogICAgewogICAgICAgIHN1cGVyKCB0ZXN0TmFtZSApOwogICAgfQoKICAgIC8qKgogICAgICogQHJldHVybiB0aGUgc3VpdGUgb2YgdGVzdHMgYmVpbmcgdGVzdGVkCiAgICAgKi8KICAgIHB1YmxpYyBzdGF0aWMgVGVzdCBzdWl0ZSgpCiAgICB7CiAgICAgICAgcmV0dXJuIG5ldyBUZXN0U3VpdGUoIEFwcFRlc3QuY2xhc3MgKTsKICAgIH0KCiAgICAvKioKICAgICAqIFJpZ291cm91cyBUZXN0IDotKQogICAgICovCiAgICBwdWJsaWMgdm9pZCB0ZXN0QXBwKCkKICAgIHsKICAgICAgICBhc3NlcnRUcnVlKCB0cnVlICk7CiAgICB9Cn0K";
	
	public static String addfile ="{\r\n"
			+ "	\"message\": \"my commit message\",\r\n"
			+ "	\"committer\": {\r\n"
			+ "		\"name\": \"Monalisa Octocat\",\r\n"
			+ "		\"email\": \"octocat@github.com\"\r\n"
			+ "	},\r\n"
			+ "	\"content\": \""+content+"\"\r\n"
			+ "}";
					
	
	
	
	public static void main(String[] args) {
		RestAssured.baseURI  = "https://api.github.com";
		GHCred gh=new GHCred();
		gh.create_repo_post("Rest5");
		gh.get_Repo_details("Rest5");
		gh.update_Repo_details_patch("Rest5");
		gh.add_file_repo_put("Rest5");
		gh.delete_Repo("Rest5");
		
	
	
		       
	     
	        

	}
	public void create_repo_post(String reponame) {
		  System.out.println(":::::::Strat::::create_repo_post::::::::::");
		Response responce = given().log().all().headers( "Authorization", "Bearer " + token, "Content-Type",
		           ContentType.JSON, "Accept",ContentType.JSON).body(createrepo).
		   when().post("/orgs/automation-eng/repos").
		 then().log().body().statusCode(201).extract().response();
		 System.out.println(":::::::End::::create_repo_post::::::::::");
		 
		// String usernames = responce.jsonPath().getString("username");
	}
	 
	 
	 public void get_Repo_details(String reponame) {
		 System.out.println(":::::::Strat::::get_Repo_details::::::::::");
		 given().headers( "Authorization", "Bearer " + token, "Content-Type",
		           ContentType.JSON, "Accept",ContentType.JSON).
		 when().get("repos/automation-eng/"+reponame).
		 then().log().body();
		 System.out.println(":::::::End::::get_Repo_details::::::::::");
		
		}

	 public void update_Repo_details_patch(String reponame) {
		 System.out.println(":::::::Strat::::update_Repo_details_patch::::::::::");
		 given().log().all().headers( "Authorization", "Bearer " + token, "Content-Type",
		           ContentType.JSON, "Accept",ContentType.JSON).body(updaterepo).
		   when().patch("repos/automation-eng/"+reponame).
		 then().log().body().statusCode(200);
		 System.out.println(":::::::End::::update_Repo_details_patch::::::::::");
		 
		 
		}
	 
	 public void add_file_repo_put(String reponame) {
		 System.out.println(":::::::Strat::::update_Repo_details_patch::::::::::");
		 given().log().all().headers( "Authorization", "Bearer " + token, "Content-Type",
		           ContentType.JSON, "Accept",ContentType.JSON).body(addfile).
		   when().put("repos/automation-eng/"+reponame+"/contents/javacode").
		 then().log().body().statusCode(201);
		 System.out.println(":::::::End::::update_Repo_details_patch::::::::::");
		 
		 
		}
	 public void delete_Repo(String reponame) {
		 System.out.println(":::::::Strat::::delete_Repo::::::::::");
		 given().log().all().headers( "Authorization", "Bearer " + token, "Content-Type",
		           ContentType.JSON, "Accept",ContentType.JSON).
		   when().delete("repos/automation-eng/"+reponame).
		 then().log().body().statusCode(204);
		 System.out.println(":::::::End::::delete_Repo::::::::::");
		}

}
