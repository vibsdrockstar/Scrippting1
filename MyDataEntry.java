package JXLSProj;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Data {
	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("C:\\Users\\vibhor\\Desktop\\MyData.json"));

			JSONObject jsonObject = (JSONObject) obj;
			JSONArray arr = (JSONArray) jsonObject.get("data");
			List<MyData> putlist = new ArrayList<MyData>();
			System.out.println(arr.size());
			for(int i =0; i<arr.size();i++){
				
				
				JSONObject obj1 = (JSONObject) arr.get(i);
				
				Set<String> iterateSet = obj1.keySet();
                
				Iterator<String> keys = iterateSet.iterator() ;
				while( keys.hasNext() ){
					String key = (String) keys.next(); // First key in your json object
				   String value = (String) obj1.get(key);
				   System.out.println(value);
	       MyData md1= new MyData(key,value) ;       
	       putlist.add(md1);
				}
			}
			Iterator itr = putlist.iterator();

			while (itr.hasNext())

			{
				MyData md = (MyData) itr.next();
				System.out.println("Keys"+md.getKey());
				System.out.println("Values"+md.getValue());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}

				
				

