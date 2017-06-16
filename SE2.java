package pac1;
import java.servlet.*;
import  java.servlet.http.*;
import java.io.*;
import java.util.*;


public class FirstServlet {
	public void doGet(HttpServletRequest request, 
			  HttpServletResponse response) 
			  throws ServletException, IOException {
			  
			  PrintWriter out = response.getWriter();
			  System.out.println("<HTML>");
			  System.out.println("<HEAD>");
			  System.out.println("<Title> My First Servlet</Title>");
			  System.out.println("<HEAD>");
			  System.out.println("<BODY>");
			  System.out.println("<BODY>");
			  System.out.println("Hi my name is Vibhor . I am doing my internship in Cavisson");
			  System.out.println("</BODY>");
			  System.out.println("<HTML>");
}
}
