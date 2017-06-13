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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

import JXLSProj.test1;

//import com.google.gson.Gson;


public class TestJXLS {
	public static void main(String[] args) {
		JSONParser p1 = new JSONParser();
		try {
			Object obj1 = p1.parse(new FileReader("C:\\Users\\vibhor\\Desktop\\TreeChildren.json"));
			JSONObject jsonObject = (JSONObject) obj1;

			JSONArray arr = (JSONArray) jsonObject.get("treeTableJson");
			List<test1> testlist = new ArrayList<test1>();
			List<MyData> inputList = new ArrayList<>();
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
				System.out.println("Previous"+tt.getPvs());
				System.out.println("Flows" +tt.getFlow());

			}

			
			MyData avgRespTime = new MyData("AVG RESPONSE TIME", "2.8");
			MyData avgPageThinkTime = new MyData("AVG PAGE THINK TIME", "1.5");
			MyData avgPageFailureRate = new MyData("AVG PAGE FAILURE RATE", "2%");
			MyData virtualUsers = new MyData("VUSERS", "5000");
			MyData sessPacingTime = new MyData("EXPECTED SESSION PACING TIME", "56");
			inputList.add(avgRespTime);
			inputList.add(avgPageThinkTime);
			inputList.add(avgPageFailureRate);
			inputList.add(virtualUsers);
			inputList.add(sessPacingTime);

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
					context.putVar("userData", inputList);
					// context.putVar("myData", myData);
					JxlsHelper.getInstance().processTemplate(is, os, context);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
