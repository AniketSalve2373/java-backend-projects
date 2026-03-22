package MyPackage;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String str1 = request.getParameter("name");
//		String str2 = request.getParameter("surname");
//		response.getWriter().append("doGet is calling : name is "+str1+" and surname is "+str2);
		
		//sending to servlet 2 
        //response.sendRedirect("https://www.youtube.com/watch?v=lo8kdf3WRx0&list=PLhvdldYcnZMku_viVb2tU7NuW5DZxwIfw&index=25");  // for outer calll
//		RequestDispatcher dispatcher = request.getRequestDispatcher("MyServlet2"); // myServlet2 load zala
//		dispatcher.forward(request, response); //forward kela aata. 
		
		//1. url parameter 
//		response.sendRedirect("MyServlet2?Data1="+str1+"&Data2="+str2);
		
		//2. request attributes 
//		request.setAttribute("Data1",str1+str2);
//		request.setAttribute("Data2", " he servlet 1 varun aala aahe ");
//   	response.sendRedirect("MyServlet2"); // not working here we need to use request dispatcher
//    	RequestDispatcher dispatcher = request.getRequestDispatcher("MyServlet2"); // myServlet2 load zala
//		dispatcher.forward(request, response); //forward kela aata.
		
		//3. session attribute 
		HttpSession session = request.getSession();
		session.setAttribute("Data1",str1+str2);
		session.setAttribute("Data2", " he servlet 1 varun aala aahe ");
		request.getRequestDispatcher("MyServlet2").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String str1 = request.getParameter("name");
		String str2 = request.getParameter("surname");
		//3. session attribute 
//				HttpSession request = request.getSession();
				request.setAttribute("Data1",str1+str2);
				request.setAttribute("Data2", " he servlet 1 varun aala aahe ");
				request.getRequestDispatcher("MyServlet2").forward(request,response);
				
		response.getWriter().append("doPost is calling");
	}

}
