package MyPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class MyServlet2
 */
@WebServlet("/MyServlet2")
public class MyServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String str1 = request.getParameter("Data1");
//		String str2 = request.getParameter("Data2");
		
		//2. request attribute to get data attribute
		//data is in obj form hece we did type casting here (String)
//		String str1 = (String) request.getAttribute("Data1");
//		String str2 = (String) request.getAttribute("Data2");
//		
//		response.getWriter().append("calling from servlet 2"+str1+" "+str2);
		
//		//3. Session attribute 
//		HttpSession session = request.getSession();
//		String str1 = (String) session.getAttribute("Data1");
//		String str2 = (String) session.getAttribute("Data2");		
//		response.getWriter().append("calling from servlet 2"+str1+" "+str2);
		
		String str1 = (String) request.getAttribute("Data1");
		String str2 = (String) request.getAttribute("Data2");		
		response.getWriter().append("calling from servlet 2"+str1+" "+str2);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
				
		doGet(request, response);
	}

}
