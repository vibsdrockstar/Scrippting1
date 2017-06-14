package pac1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;


public class TestJXLS {
	public static void main(String[] args) {
		JSONParser p1 = new JSONParser();
		JSONParser parser = new JSONParser();
		try {
			Object obj1 = p1.parse(new FileReader("C:\\Users\\vibhor\\Desktop\\TreeChildren.json"));
			
			JSONObject jsonObject = (JSONObject) obj1;

			JSONArray arr = (JSONArray) jsonObject.get("treeTableJson");
			List<test1> testlist = new ArrayList<test1>();
			List<MyData> inputlist = new ArrayList<>();
			System.out.println(arr.size());
			for (int i = 0; i < arr.size(); i++) {
				JSONObject obj3 = (JSONObject) arr.get(i);
				JSONObject obj2 = (JSONObject) obj3.get("data");
				String name = (String) obj2.get("name");
				String pv = obj2.get("pvs") + "";
				test1 t1 = new test1(name, "", pv);
				testlist.add(t1);
				JSONArray arrchild = (JSONArray) obj3.get("children");
				System.out.println(pv);
				System.out.println(name);

				System.out.println(arrchild.size());
				if (arrchild.size() > 0) {
					for (int j = 0; j < arrchild.size(); j++) {
						JSONObject treeTableJsonObj = (JSONObject) arrchild.get(j);
						JSONObject dataob = (JSONObject) treeTableJsonObj.get("data");
						test1 t2 = new test1("", name, pv);
						testlist.add(t2);

					}

				}
			}
			// loop array for displaying tables

			Iterator itr = testlist.iterator();

			while (itr.hasNext())

			{
				test1 tt = (test1) itr.next();
				System.out.println("Pages" + tt.getPage());
				System.out.println("Previous" + tt.getPvs());
				System.out.println("Flows" + tt.getFlow());

			}

			try {
				Object obj = parser.parse(new FileReader("C:\\Users\\vibhor\\Desktop\\MyData.json"));

				JSONObject jsonObject1 = (JSONObject) obj;
				JSONArray arr2 = (JSONArray) jsonObject1.get("data");
				
				System.out.println(arr.size());
				for(int k =0; k<arr.size();k++){
					
					
					JSONObject obj4 = (JSONObject) arr.get(k);
					
					Set<String> iterateSet = obj4.keySet();
	                
					Iterator<String> keys = iterateSet.iterator() ;
					while( keys.hasNext() ){
						String key = (String) keys.next(); // First key in your json object
					   String value = (String) obj4.get(key);
					   System.out.println(value);
		       MyData md1= new MyData(key,value) ;       
		       inputlist.add(md1);
					}
				}
				Iterator itr2 = inputlist.iterator();

				while (itr2.hasNext())

				{
					MyData md = (MyData) itr2.next();
					System.out.println("Keys"+md.getKey());
					System.out.println("Values"+md.getValue());
				}

			// newClass myData = new newClass(inputList, testList);

			// Gson gson = new Gson();

			// 1. Java object to JSON, and save into a file

			// 2. Java object to JSON, and assign to a String
			// String jsonInString = gson.toJson(myData);
			// System.out.println(jsonInString);
			// try (InputStream is =
			// TestJXLS.class.getResourceAsStream("object_collection_template.xls"))
			try (InputStream is = new FileInputStream(new File("C:\\Users\\vibhor\\Desktop\\newfile.xls"))) {
				try (OutputStream os = new FileOutputStream("C:\\Users\\vibhor\\Desktop\\Final.xls")) {
					Context context = new Context();
					context.putVar("listData", testlist);
					context.putVar("userData", inputlist);
					// context.putVar("myData", myData);
					JxlsHelper.getInstance().processTemplate(is, os, context);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
} catch (Exception e){
	e.printStackTrace();
}
	}
}
