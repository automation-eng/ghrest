package com.apiresource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GitPayloads {
	private String gitCreatepayload=null;
	private String gitupdatepayload=null;
	private String gitaddfilepayload=null;
	
	public void setgitCreatepayload(String gitCreatepayload) throws IOException
	{
		byte[] b = Files.readAllBytes(Paths.get("./src/test/java/com/apiresource/gitcreate.json"));
        //convert byte array to string
		this.gitCreatepayload = new String(b);
         System.out.println("::::File pay load:::"+this.gitCreatepayload);
		
	}
	
	public String  getgitCreatepayload()
	{
		return this.gitCreatepayload;
	}
	
	public void setgitupdatepayload(String gitupdatepayload) throws IOException
	{
		byte[] b = Files.readAllBytes(Paths.get("./src/test/java/com/apiresource/gitupdate.json"));
        //convert byte array to string
		this.gitupdatepayload = new String(b);
         System.out.println("::::File pay load:::"+this.gitupdatepayload);
		
	}
	
	public String  getgitupdatepayload()
	{
		return this.gitupdatepayload;
	}
	
	public void setgitaddfilepayload(String gitaddfilepayload) throws IOException
	{
		byte[] b = Files.readAllBytes(Paths.get("./src/test/java/com/apiresource/addfile.json"));
        //convert byte array to string
		this.gitaddfilepayload = new String(b);
         System.out.println("::::addfilepayload pay load:::"+this.gitaddfilepayload);
		
	}
	
	public String  getgitaddfilepayload()
	{
		return this.gitaddfilepayload;
	}
	
	
	
	

}
