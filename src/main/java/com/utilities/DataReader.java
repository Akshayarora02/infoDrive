package com.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class DataReader {

	
	public static String propertyFileReader() throws IOException
	{
		String data="";
		  FileReader reader;
		try {
			reader = new FileReader("Data.properties");
	
	      
		    Properties p=new Properties();  
		    p.load(reader);  
		      
		     data =p.getProperty("data");
		}
		    catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}  
		return data;
	}
	public static HashMap<String, String> credentialsReader() throws IOException
	{
		String[] credentials =null;
		String username="";
		String password="";
		HashMap<String,String> map =new HashMap<String,String>();
		  FileReader reader;
		try {
			reader = new FileReader("Credentials.properties");
	
	      
		    Properties p=new Properties();  
		    p.load(reader);  
		      
		     username =p.getProperty("username");
		     password=p.getProperty("password");
		}
		    catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}  
		
		map.put(username, password);
		return map;
	}
	public static String generateUrl() throws IOException
	{
		String data="";
		  FileReader reader;
		try {
			reader = new FileReader("Data.properties");
	
	      
		    Properties p=new Properties();  
		    p.load(reader);  
		      
		     data =p.getProperty("url");
		}
		    catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}  
		return data;
	}
	public static String propertyFileReader(String fileName,String fieldName) throws IOException
	{
		String data="";
		  FileReader reader;
		try {
			reader = new FileReader(fileName);
	
	      
		    Properties p=new Properties();  
		    p.load(reader);  
		      
		     data =p.getProperty(fieldName);
		}
		    catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}  
		return data;
	}
	public static Object[][] propertyFileReader(String fileName) throws IOException
	{
		String[][] data = new String [1][2];
		  FileReader reader;
		try {
			reader = new FileReader(fileName);
	
	      
		    Properties p=new Properties();  
		    p.load(reader);  
		      
		     data[0][0] =p.getProperty("NewUserEmail");
		     data[0][1]=p.getProperty("password");
		}
		    catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}  
		return data;
	}
	
}
