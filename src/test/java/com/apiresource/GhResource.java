package com.apiresource;

public class GhResource {
	/*
	 * String orgname=null; String repo=null;
	 */
	 private String creategitResource = null;
	 private String updateGitResource = null; 
	 private String addfileResource = null; 
	 private String deletegitResource = null; 
	 private String readGitResource = null;
	 private String org = "automation-eng"; 
	 
	 
	 public void setreadGitResource(String readGitResource) {
		    System.out.println("::readGitResource:::::::");
				this.readGitResource = "/repos/automation-eng/ghrest";
			
			//sample:  repos/shabbi123/Andriod
			
			System.out.println(":::Resource Path:::" + this.readGitResource);

		}
		public String getreadGitResource() {
			System.out.println("::::::::::::final readGitResource:::"+this.readGitResource);
			return this.readGitResource;
		  	}
	 
	 
	public void setcreategitResource(String creategitResource) {
	    System.out.println("::setjobp:::::::");
		this.creategitResource = "/orgs/"+org+"/repos";
		
		//sample:  orgs/automation-eng/repos
		
		System.out.println(":::Resource create" + this.creategitResource);

	}
	public String getcreategitResource() {
		System.out.println("::::::::::::final create::"+this.creategitResource);
		return this.creategitResource;
	  	}
	
	public void setupdateGitResource(String reponame) {
	    System.out.println("::setjobp:::::::");
	    
		this.updateGitResource = "/repos/"+org+"/"+reponame;
		
		//sample:  //repos/automation-eng/Rest5
		
		System.out.println(":::Resource Path" + this.updateGitResource);

	}
	public String getupdateGitResource() {
		System.out.println("::::::::::::final updateResource::"+this.creategitResource);
		return this.updateGitResource;
	  	}
	
	public void setaddfileResource(String reponamr) {
	    System.out.println("::setjobp:::::::");
	    
		this.addfileResource = "/repos/"+org+"/"+reponamr+"/contents/test3";
		
		//sample:  repos/automation-eng/Rest5/contents/test3
		
		System.out.println(":::Resource addfileResource:::" + this.addfileResource);

	}
	public String getaddfileResource() {
		System.out.println("::::::::::::final addfileResourfce::"+this.addfileResource);
		return this.addfileResource;
	  	}
	
	public void setdeletegitResource(String reponame) {
	    System.out.println("::setdeletegitResource:::::::");
	    
		this.deletegitResource = "/repos/"+org+"/"+reponame;
		
		//sample:  /repos/automation-eng/Rest5
		
		System.out.println(":::Resource Path" + this.deletegitResource);

	}
	public String getdeletegitResource() {
		System.out.println("::::::::::::final deletegitResource::"+this.deletegitResource);
		return this.deletegitResource;
	  	}


}
