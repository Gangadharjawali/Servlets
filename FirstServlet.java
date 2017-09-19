import java.io.*;  
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;  

@WebServlet("/myurl")
public class FirstServlet extends HttpServlet 
{  
  
  public void doPost(HttpServletRequest request, HttpServletResponse response)
  {  
    try
    {  
  
    	response.setContentType("text/html");  
    	PrintWriter out = response.getWriter();  
          
    	String n=request.getParameter("userName");     	
    	out.print("Welcome "+n);  
  
    	Cookie ck=new Cookie("uname",n);//creating cookie object  
    	response.addCookie(ck);//adding cookie in the response  
  
    	//creating submit button  
    	out.print("<form action='myurl'>");  
    	out.print("<input type='submit' value='go'>");  
    	out.print("</form>");  
          
    	out.close();  
  
       }
    	catch(Exception e){System.out.println(e);}  
  }  
  
  @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
} 