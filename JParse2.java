import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JParse2 {
	public static void main(String[] args) {
		JSONParser p1 = new JSONParser();
		try {
			Object obj1 = p1.parse(new FileReader("C:\\Users\\vibhor\\Desktop\\TreeChildren.json"));
			JSONObject jsonObject = (JSONObject) obj1;
			JSONArray arr = (JSONArray) jsonObject.get("treeTableJson");
			System.out.println("The size - " + arr.size());
			for (int j = 0; j < arr.size(); j++) {
          JSONObject treeTableJsonObj=(JSONObject) arr.get(j);
          JSONObject obj2=(JSONObject) treeTableJsonObj.get("data");
          String nam= (String) obj2.get("name");
          String pv =obj2.get("pvs")+"";
          System.out.println(pv);
          System.out.println(nam);
          if(arr.size()<0){
        	  JSONObject dataob =(JSONObject) treeTableJsonObj.get("data");
        	  System.out.println(dataob.get("pvs").toString());
        	  System.out.println(dataob.get("name").toString());
        	  
          }
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
