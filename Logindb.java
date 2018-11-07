import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class Logindb extends HttpServlet
{
	public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		int flag=2;
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String name=request.getParameter("uname");
		String pwd=request.getParameter("psw");
		Connection con=null;
		Statement st=null;

		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			st=con.createStatement();
			ResultSet rs=st.executeQuery("select uname,pwd,gender,fname from custdet");
			while(rs.next())
			{
				String n=rs.getString(1);
				String p=rs.getString(2);
				if((n.equals(name))&&p.equals(pwd))
				{
					flag=1;
					break;
				}
			}
			if(flag!=1)
			{
				out.print("<html><script>alert('Invalid Username/Password');</script>");
				out.print("<h1 align='center' style='color:blueviolet'><i>Book_your_book.com</i></h1> <hr  size=5px color='forestgreen'><marquee><h2 style='color:crimson'>Welcome to our online bookstore</h2></marquee><br><br><table align='center'><tr><td><a href='login.html'>Try Again<a></td></tr></table></html>");
			}
			else
			{
				out.print("<html>");
				out.print("<style>");
				out.print("a:link{color:white;background-color:transparent; text-decoration:none;}");
				out.print("a:visited{ color:cyan; background-color:transparent;text-decoration:none;}");
				out.print("a:hover{ color:red; background-color:transparent; text-decoration:none;}");
				out.print("a:active{  color:yellow;  background-color:transparent;text-decoration:none;}");
				out.print("body{background:url('book2.gif');background-size:cover;}");
				out.print(".dropbtn {width: 150px;height: 100px;border-radius: 50%;font-size: 20px;color: black;line-height: 100px;text-align: center;background: blue}");
				out.print(".dropdown { position: relative; display: inline-block;}");
				out.print(".dropdown-content {display: none;position: absolute;background-color: #f9f9f9;min-width: 160px;box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);z-index: 1;}");
				out.print(".dropdown-content a {color: black;padding: 12px 16px;text-decoration: none;display: block;}");
				out.print(".dropdown-content a:hover {background-color: #f1f1f1}.dropdown:hover .dropdown-content {display: block;}.dropdown:hover .dropbtn { background-color: #3e8e41;}");
				out.print("</style>");
				out.print("<body>");
				out.print("<h1 align=center style=color:yellow><i>Book_your_book.com</i></h1> <hr  size=5px color=forestgreen><marquee><h2 style=color:blanchedalmond>Welcome to our online bookstore</h2></marquee>");
				out.print("<h3 style='background-color:black;color:white;' align=center>");
				if(rs.getString(3).equals("male"))
				{
					out.print("<font color='gold' face='broadway'> Hello Mr."+rs.getString(4)+"!!</font>");
				}
				else
				{
					out.print("<font color='gold' face='broadway'> Hello Ms."+rs.getString(4)+"!!</font>");
				}
				out.print("<a href=aboutus.html style='float:left'>About us</a>&nbsp &nbsp &nbsp &nbsp<a href=bookstore.html style='float:right'>Logout</a></h3>");
				out.print("<br><br>");
				out.print("<h1 style=color:blue>Select Category: </h1>");
				out.print("<table><tr><td><div class='dropdown'><button class=dropbtn>Mystery</button><div class=dropdown-content><a href='my1details.html'>Sherlock Holmes</a><a href='my2details.html'>The History of Mystery</a><a href='my3details.html'>The Moonstone</a></div></div></td></tr>");
				out.print("<tr><td><div class='dropdown'><button class=dropbtn>Comedy</button><div class=dropdown-content><a href='c1details.html'>Funny the Book</a><a href='c2details.html'>Comedy of Doom</a><a href='c3details.html'>Bossypants</a></div></div></td></tr>");
				out.print("<tr>	<td><div class='dropdown'><button class='dropbtn'>Thriller</button><div class=dropdown-content><a href='t1details.html'>Writing a Killer Thriler</a><a href='t2details.html'>Thriller</a><a href='t3details.html'>The Girl on the train</a></div></div></td></tr>");
				out.print("<tr><td><div class='dropdown'><button class='dropbtn'>Fiction</button><div class=dropdown-content><a href='f1details.html'>Harry Potter</a><a href='f2details.html'>The Hunger Games</a><a href='f3details.html'>All The Light That We Cannot See</a></div></div></td></tr>");
				out.print("<tr><td><div class='dropdown'><button class='dropbtn'>Horror</button><div class=dropdown-content><a href='h1details.html'>The Walking Dead</a><a href='h2details.html'>Zombie Apocalyse</a><a href='h3details.html'>Ruined</a></div></div></td></tr>");
				out.print("<tr><td><div class='dropdown'><button class='dropbtn'>Romantic</button><div class=dropdown-content><a href='r1details.html'>Twilight</a><a href='r2details.html'>Fallen In Love</a><a href='r3details.html'>Pride and Prejudice</a></div></div></td></tr>");
				out.print("<tr><td><div class='dropdown'><button class='dropbtn'>Mythology</button><div class=dropdown-content><a href='m1details.html'>Mahabharata</a><a href='m2details.html'>Hanuman</a><a href='m3details.html'>The Complete World of Greek Mythology</a></div></div></td></tr>");
				out.print("</table>");
				out.print("<h3  align='center'>");
				out.print("<a href='#' title='Facebook'><img src='fb1.jpg' style='width:50px;height:50px' title='Facebook'></a>&nbsp &nbsp &nbsp &nbsp <a href='https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1' title='bookyourbook3@gmail.com'><img src='gmail.png' style='width:50px;height:50px' title='bookyourbook3@gmail.com'></a>&nbsp &nbsp &nbsp &nbsp <a href='https://twitter.com/bookyourbook' title='Twitter'><img src='twitter.png' style='width:50px;height:50px' title='Twitter'></a>&nbsp &nbsp &nbsp &nbsp<a href='#' title='1800 2323 2424'><img src='call.jpg' style='width:50px;height:50px'></a>&nbsp &nbsp &nbsp &nbsp<a href='#' title='6-3-354/1, Shop No. A/B, Nagarjuna Circle Road, Road No.1, Punjagutta, Hyderabad, Telangana Zipcode-500034'><img src='loc.jpg' style='width:50px;height:50px'></a>");
				out.print("</h3></body></html>");
			}
			
		}

		catch(Exception e)
		{
			out.print(e);
		}

	}
}