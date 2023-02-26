package data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {

	public static Object[][] getJSONData(String JSONPath, String JSONData, int JSONAttributes) throws FileNotFoundException, IOException, ParseException {
		
		Object object = new JSONParser().parse(new FileReader(JSONPath));
		JSONObject jsonObject = (JSONObject) object;
		JSONArray  jsonArray  = (JSONArray) jsonObject.get(JSONData);
		
		Object[][] array = new String[jsonArray.size()][JSONAttributes];
		for (int i=0; i<jsonArray.size(); i++)
		{
			JSONObject obj = (JSONObject) jsonArray.get(i);
			array[i][0]= String.valueOf(obj.get("username"));
			array[i][1]= String.valueOf(obj.get("password"));
		}
				
		return array;
	
	}
 	
	
	
	
	
}
