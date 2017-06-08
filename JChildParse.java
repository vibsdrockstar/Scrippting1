import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JChildrenParse {
	public static void main(String[] args) {
		JSONParser p = new JSONParser();
		try {
			Object obj = p.parse(new FileReader("C:\\Users\\vibhor\\Desktop\\Treechildren.json"));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray arrchild = (JSONArray) jsonObject.get("treeTableJson");
			System.out.println(arrchild.size());
			for (int i = 0; i < arrchild.size(); i++) {
				JSONObject treeTableJsonObj = (JSONObject) arrchild.get(i);
				JSONObject obj2 = (JSONObject) treeTableJsonObj.get("data");
				String name = (String) obj2.get("name");
				String pvs = obj2.get("pvs") + "";
				System.out.println(pvs);
				System.out.println(name);
				if (((JSONArray)treeTableJsonObj.get("children")).size() > 0) {
					JSONObject dataObj = (JSONObject) treeTableJsonObj.get("data");
					System.out.println(dataObj.get("flow").toString());
					System.out.println(dataObj.get("index").toString());
				}
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
