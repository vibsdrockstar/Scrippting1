import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import JXLSProj.test1;

public class JParse2 {
	public static void main(String[] args) {
		JSONParser p1 = new JSONParser();
		try {
			Object obj1 = p1.parse(new FileReader("C:\\Users\\vibhor\\Desktop\\TreeChildren.json"));
			JSONObject jsonObject = (JSONObject) obj1;

			JSONArray arr = (JSONArray) jsonObject.get("treeTableJson");
            List<test1>testlist=new ArrayList<test1>();
           
			System.out.println(arr.size());
			for (int i = 0; i < arr.size(); i++) {
				JSONObject obj3 = (JSONObject) arr.get(i);
				JSONObject obj2 = (JSONObject) obj3.get("data");
				String name = (String) obj2.get("name");
				String pv = obj2.get("pvs") + "";
				test1 t1= new test1(name,"",pv);
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
				System.out.println("Pages" + tt.getPages());
				System.out.println("Previous"+tt.getPvs());
				System.out.println("Flows" +tt.getFlows());

			}

					}

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
