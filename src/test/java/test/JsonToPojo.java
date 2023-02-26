package test;

import java.io.File;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToPojo {

	public static void main(String[] args) {
		
		try {
			 ObjectMapper objectMapper = new ObjectMapper();
			  
			 File fileObject = new File(System.getProperty("user.dir")+"\\src\\main\\java\\data\\PojoToJson.json");
			 
			 Map<String,Object> jsonData = objectMapper.readValue(fileObject, new TypeReference<Map<String,Object>>(){});
			 
			 System.out.println("Data From JSON is as follows:--");
			 System.out.println("Name- "+ jsonData.get("employeeName"));
			 System.out.println("City- "+ jsonData.get("city"));
			 System.out.println("Department- "+ jsonData.get("department"));
			 System.out.println("Designation- "+ jsonData.get("designation"));
			 
			 JsonNode jsonNode = objectMapper.readTree(fileObject);
			 
			 System.out.println("Data from JSONNode is as follows:--");
			 System.out.println(jsonNode.get("employeeName").asText());
			 System.out.println(jsonNode.get("city").asText());
			 System.out.println(jsonNode.get("department").asText());
			 System.out.println(jsonNode.get("designation").asText());
			 
			 objectMapper.writeValue(new File(System.getProperty("user.dir")+"\\src\\main\\java\\data\\JsonToPojo.txt"), jsonNode);
			 System.out.println("JSON Values written successfully to POJO Objects in TEXT file");
			 
	    	}catch(final Exception e)
		    {
			e.printStackTrace();
		    }

	}

}
