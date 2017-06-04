import java.util.*;    
class TestArrayList21{    
 public static void main(String args[]){    
     
  List<String> al=new ArrayList<String>();//creating arraylist    
  al.add("Sonoo");//adding object in arraylist    
  al.add("Michael");    
  al.add("James");    
  al.add("Andy");    
  //traversing elements using Iterator  
  Iterator itr=al.iterator();  
  while(itr.hasNext()){  
   System.out.println(itr.next());  
  }    
 }    
}    
