package test;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.JsonReader;

public class DataParams {

	@DataProvider(name="JSONData")
	public Object[][] readJSONData() throws IOException, ParseException{
		
		return JsonReader.getJSONData(System.getProperty("user.dir")+"/src/main/java/data/Data.json", "Data", 2);
		
	}
	
	@Test(dataProvider = "JSONData")
	public void printJSONData(String username, String password) throws Exception{
		System.out.println("Username- "+username);
		System.out.println("Password- "+password);
	}
	
}
