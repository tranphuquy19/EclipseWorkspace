package webPackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class HelloWorld
 */
@WebServlet(description = "hello", urlPatterns = { "/HelloWorld" })
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		excute(request, response);
	}
	private void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String name = request.getParameter("email");
		String pass = request.getParameter("pass");
		PrintWriter printWriter = response.getWriter();
		printWriter.println("Username is "+name+"</br>Password is:"+pass);
		System.out.println("name is"+name+" pass is:"+pass);
	}
}
