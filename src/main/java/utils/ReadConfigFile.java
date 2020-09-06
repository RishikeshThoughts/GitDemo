package utils;

import java.io.IOException;
import java.io.InputStream;
//import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class ReadConfigFile {
	
	InputStream input=null;
	Properties prop = null;
	
	public ReadConfigFile() throws IOException
	{
		try
		{
		input=ReadConfigFile.class.getClassLoader().getResourceAsStream(Constant.CONFIG_PROPERTIES_DIRECTORY);
		prop = new Properties();
		prop.load(input);
		
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		
		}	
	}
	
	public String getBrowser()
	{
		if(prop.getProperty("browser")== null)
		{
		System.out.println("Couldn't load");
		  return "";
		}
		return prop.getProperty("browser");
	}
	
}
