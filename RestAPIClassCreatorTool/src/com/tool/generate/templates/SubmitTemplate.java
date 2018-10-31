package com.tool.generate.templates;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SubmitTemplate {

	public void submitControllerCreation() throws IOException
	{
		System.out.println("START : submitControllerCreation");
		String destPath = "V:/MeenalSV/Workspaces/RestAPI//RestAPIDummy/src/resources/webservices/apis/controller";
		String importPath = "V:/MeenalSV/Workspaces/RestAPI/RestAPIClassCreatorTool/resources/templates/SubmitImport.txt";
		String sourcePath = "V:/MeenalSV/Workspaces/RestAPI/RestAPIClassCreatorTool/resources/templates/SubmitTemplate.txt";
		
		try {
			FileInputStream	FreadImport = new FileInputStream(importPath);
		
	        FileOutputStream Fwrite=new FileOutputStream(destPath + "/Submit.java") ; 
	        System.out.println("import File is Copied"); 
	        int c; 
	        while((c=FreadImport.read())!=-1) 
	        Fwrite.write((char)c);
	        FreadImport.close(); 
	        
	        FileInputStream	FreadSubmit = new FileInputStream(sourcePath);
	        System.out.println("submit File is Copied"); 
	        while((c=FreadSubmit.read())!=-1) 
	        Fwrite.write((char)c);
	        FreadSubmit.close(); 
	        
	        Fwrite.close(); 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("END : submitControllerCreation");
	}
}
