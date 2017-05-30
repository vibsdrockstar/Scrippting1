import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser {
	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("C:\\Users\\vibhor\\Desktop\\Tree.json"));

			JSONObject jsonObject = (JSONObject) obj;

			JSONArray arr = (JSONArray) jsonObject.get("treeTableJson");
			System.out.println(arr.size());
			
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
