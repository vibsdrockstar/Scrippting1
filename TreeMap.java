import java.util.*;
class Place {    
	int id;    
	String place,city;    
	int quantity;    
	public Place(int id, String place, String city, int quantity) {    
	    this.id = id;    
	    this.place = place;    
	    this.city = city;    
	    this.quantity = quantity;  
	}    
}  
public class TreeMap {
public static void main(String[]args){
	Map<Integer,Place> p =  new HashMap<Integer,Place>();


	Place p1=new Place(1, "Taj Mahal", "Agra", 80);
	Place p2=new Place(2 ,"Qutub Minar","Delhi",200);
	Place p3=new Place(3, "Chilika Lake","Bhubaneswar",120);
	p.put(4, p1);
	p.put(5, p2);
	
}
}
