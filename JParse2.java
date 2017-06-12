import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JParse2 {
public static void main(String[]args){
	JSONParser p1 = new JSONParser();
	try{
		Object obj1=p1.parse(new FileReader("C:\\Users\\vibhor\\Desktop\\TreeChildren.json"));
		JSONObject jsonObject = (JSONObject) obj1;
		JSONArray arr = (JSONArray) jsonObject.get("treeTableJson");
		System.out.println(arr.size());
		for(int j=0;j<arr.size();j++){
			JSONObject treeTableJsonObj =(JSONObject) arr.get(j);
			JSONObject obj2 = (JSONObject) treeTableJsonObj.get("data");
			String nam = (String) obj2.get("name");
			String pv = (String)  obj2.get("pvs");
			System.out.println(nam);
			System.out.println(pv);
			if(((JSONArray)treeTableJson.get("data")).size()=0){
				JSONObject dataObj = (JSONObject) treeTableJsonObj.get("data");
				System.out.println(dataObj.get("flow").toString());
				System.out.println(dataObj.get("index").toString());
				else if((JSONArray)treeTableJson.get("data").size()>0){
					JSONObject dataObj = (JSONObject) treeTableJsonObj.get("data");
					System.out.println(dataObj.get("name").toString());
					System.out.println(dataObj.get("pvs").toString());
					else {
						System.out.println("Error")
					}
						
				}catch (FileNotFoundException e) {
					e.printStackTrace();
					
				}catch (IOException e) {
					e.printStackTrace();
		}catch (ParseException e) {
			e.printStackTrace();
	}
}
}
}
