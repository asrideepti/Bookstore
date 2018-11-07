import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class Registerdb extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String fname=request.getParameter("fname");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String mobile=request.getParameter("num");
		String city=request.getParameter("city");
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("psw");

		Connection con=null;
		Statement st=null;

		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			st=con.createStatement();
			int r=st.executeUpdate("insert into custdet values('"+fname+"','"+email+"','"+gender+"',"+mobile+",'"+city+"','"+uname+"','"+pwd+"')");
		  if(r==0)
			{
			  out.print("error");
			}
			else
			{
				response.sendRedirect("login.html");//out.print("Success");
			}
		
		}
		catch(Exception e)
		{
			out.print(e);
		}

	}
}