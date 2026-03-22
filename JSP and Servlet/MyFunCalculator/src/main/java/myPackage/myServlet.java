package myPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class myServlet
 */
@WebServlet("/myServlet")
public class myServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//jokes 
	private String[] jokes = {
	        "Why do Java developers wear glasses? Because they don't C#.",
	        "I told my computer I needed a break, and now it won’t stop sending me KitKat bars.",
	        "Why don't programmers like nature? It has too many bugs.",
	        "How many programmers does it take to change a light bulb? None, it's a hardware problem."
	    };
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String str1 = request.getParameter("number1");
		String str2 = request.getParameter("number2");
		String str3 = request.getParameter("operation");
		
		//type casing 
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
//		int sum = num1+num2;
		
		//differet operations
		int ans;
		if(str3.equals("add")) ans=num1+num2;
		else if(str3.equals("sub")) ans=num1-num2;
		else if(str3.equals("mul")) ans=num1*num2;
		else ans=num1/num2;
		
		//print answer
//		response.getWriter().append("answer : "+ans);
		
		int randomIndex = (int) (Math.random() * jokes.length);
		String randomJokes = jokes[randomIndex];
		response.sendRedirect("NewFile.jsp?ans="+ans+"&joke="+randomJokes);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
