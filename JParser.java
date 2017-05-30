import org.json.simple.JSONObject;
public class JsonEncodeDemo {
	 public static void main(String[] args){
	      JSONObject obj = new JSONObject();

	      obj.put("name", "Block1>flow>index");
	      obj.put("data", "pvs",new Float(8.333334));
	      System.out.print(obj);
	   }
	}
