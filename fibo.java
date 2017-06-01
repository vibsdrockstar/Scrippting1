import java.util.Scanner;
public class Fibonacci {
public static void main(String args[]){
	int a=0, b=0, c=1, i;
	System.out.println("Fibonacci series");
	for(i=1;i<=100;i++)
	{
		a=b+c;
		a=b;
		b=c;
		
	}
	System.out.println(a+"");
}
}