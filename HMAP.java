import java .util.HashMap;
public class HMap {
public static void main(String[] args){
	System.out.println("Hashing");
	HashMap<Integer,String> Hmap = new HashMap<Integer,String>();
	Hmap.put(60, "Tandoori Chicken");
	Hmap.put(130, "Malai Kofta");
	Hmap.put(150, "Chilly Chicken");
	Hmap.put(200, "Veg Thali");
	Hmap.put(260, "Butter Chicken");
	System.out.println(Hmap.size());
