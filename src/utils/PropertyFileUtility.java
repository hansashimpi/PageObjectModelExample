package utils;

import java.io.FileInputStream;

import java.util.Properties;

public class PropertyFileUtility
{
	private  Properties p=null;
	
	public PropertyFileUtility(String propertyFile) throws Exception 
	{
		
		FileInputStream fis = new FileInputStream(propertyFile);
		 p = new Properties();
		p.load(fis);
		
	}
	
	
	


	public String getData(String parameter)
	{
		return p.getProperty(parameter);
	}

}
