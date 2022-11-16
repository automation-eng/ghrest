package com.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.codec.binary.Base64;

import com.apiresource.GhResource;
import com.apiresource.GitPayloads;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;




import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReusableMthods {
	static Properties p;
	public static String ghtoken;
	public GhResource rsrc= new GhResource();
	
	public GitPayloads gpayload= new GitPayloads();
	
public String apiresourc(String act, String reponme)
{
	if(act.equalsIgnoreCase("read"))
	{
		System.out.println("Incide read repo");
		rsrc.setreadGitResource(reponme);
		return  rsrc.getreadGitResource();
	}
	else if(act.equalsIgnoreCase("create"))
	{
		rsrc.setcreategitResource(reponme);
		return  rsrc.getcreategitResource();
	}
	else if(act.equalsIgnoreCase("update"))
	{
		rsrc.setupdateGitResource(reponme);
		return  rsrc.getupdateGitResource();
	}
	else if(act.equalsIgnoreCase("addfile"))
	{
		rsrc.setaddfileResource(reponme);
		return  rsrc.getaddfileResource();
		
	}
	
	else if(act.equalsIgnoreCase("delete"))
	{
		rsrc.setdeletegitResource(reponme);
		return rsrc.getdeletegitResource();
		
	}
	else 
	return "enter Valid Resource";
	
	
	
}


public String apipayload(String payload) throws IOException
{
	if(payload.equalsIgnoreCase("create"))
	{
		gpayload.setgitCreatepayload(payload);;
		return  gpayload.getgitCreatepayload();
	}
	if(payload.equalsIgnoreCase("addfile"))
	{
		gpayload.setgitaddfilepayload(payload);
		return  gpayload.getgitaddfilepayload();
	}
	if(payload.equalsIgnoreCase("update"))
	{
		gpayload.setgitupdatepayload(payload);
		return  gpayload.getgitupdatepayload();
	}
	
		return payload;
	
	
	
}
	public void setapiinit() throws IOException {
		// TODO Auto-generated method stub
		System.out.println(":::ReusableMethod.setjsoninit::");
		FileReader reader = new FileReader("gitdata.properties");
		p = new Properties();
	
		p.load(reader);
		String endPoint = p.getProperty("EndPoint");
		RestAssured.baseURI = endPoint;
	    ghtoken = p.getProperty("GhToken");
		
	}
	public  JsonPath rawToJson(Response r)
	{ 
		String respon=r.asString();
		JsonPath x=new JsonPath(respon);
		return x;
	}
	
	public String j8B64decoder(String r)
	{ 
		
        Base64 base64 = new Base64();
         
        //String encodedVersion = new String(base64.encode(encodedString.getBytes()));
         
       // System.out.println("Encoded Version is " + encodedVersion);
         
        String decodedVersion = new String(base64.decode(r));
         
		
		return decodedVersion;
	         		
	}
	
	public  void hmcrastStringvalidation()
	{ 
		String first = "hello";
	    String second = "Hello";

	    assertThat(first, equalToIgnoringCase(second));
	    assertThat(first, blankString());
	    assertThat(first, blankOrNullString());
	    assertThat(second, blankOrNullString());
	    assertThat(first, emptyString());
	    assertThat(first, emptyOrNullString());
	    assertThat(second, emptyOrNullString());
	    assertThat(first, matchesPattern("[a-z]+"));
	    assertThat(first, containsString("lo"));
	    assertThat(first, containsStringIgnoringCase("EL"));
	    assertThat(first, stringContainsInOrder("e","l","o"));
	    assertThat(first, startsWith("he"));
	    assertThat(first, startsWithIgnoringCase("HEL"));
	    assertThat(first, endsWith("lo"));
	    assertThat(first, endsWithIgnoringCase("LO"));
	    assertThat(1.0, is(notANumber()));
	    assertThat(Math.sqrt(-1), is(notANumber())); 
	    Object theBiscuit = null;
		Object myBiscuit = null;
		assertThat(theBiscuit, equalTo(myBiscuit)); 
	    assertThat(theBiscuit, is(equalTo(myBiscuit))); 
	    assertThat(theBiscuit, is(myBiscuit));
	   
	}
}
