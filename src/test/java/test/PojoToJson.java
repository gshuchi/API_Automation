package test;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;

import data.WritePojoToJson;

public class PojoToJson {

	public static void main(String[] args) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		WritePojoToJson pojoToJson = new WritePojoToJson("Gaurav Shuchi", "Mumbai","Quality Analysis","Senior Associate Engineer");
		
		try {
			objectMapper.writeValue(new File(System.getProperty("user.dir")+"//src//main//java//data//PojoToJson.json"), pojoToJson);
		    } catch (final Exception e) {
			e.printStackTrace();
		    }

		System.out.println("POJO written successfully to JSON");
	}

}
