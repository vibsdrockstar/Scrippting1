import java.util.*;  
enum month {  
  JAN ,FEB, MARCH, APRIL,MAY,JUNE, JULY
}  
public class Enum {
	public static void main(String[] args) {  
	    Set<month> set1 = EnumSet.allOf(month.class);  
	      System.out.println("Month:"+set1);  
	      Set<month> set2 = EnumSet.noneOf(month.class);  
	      System.out.println("Month:"+set2);
}
}
