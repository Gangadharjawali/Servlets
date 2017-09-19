// Loading required libraries
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
@WebServlet("/database")
public class DatabaseExample extends HttpServlet
{

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException 
   {
	   String JDBC_driver="com.mysql.jdbc.Driver";
  
      // Set response content type
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Database Result";
      String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
      
      out.println(docType +
         "<html>\n" +
         "<head><title>" + title + "</title></head>\n" +
         "<body bgcolor = \"#f0f0f0\">\n" +
         "<h1 align = \"center\">" + title + "</h1>\n");
      try 
      {
         // Register JDBC driver
         Class.forName("com.mysql.jdbc.Driver");

         // Open a connection
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TEST","root","root");

         // Execute SQL query
         Statement stmt = conn.createStatement();
         String sql;
         sql = "SELECT * FROM Employees";
         ResultSet rs = stmt.executeQuery(sql);

         // Extract data from result set
         while(rs.next()){
            //Retrieve by column name
            int id  = rs.getInt("id");
            int age = rs.getInt("age");
            String fname = rs.getString("fname");
            String lname = rs.getString("lname");

            //Display values
            out.print("ID: \t" + id + "<br>");
            out.println("Age: \t" + age + "<br>");
            out.println("First: \t" + fname + "<br>");
            out.println("Last: \t" + lname + "<br>");
            
         }
         out.println("</body></html>");

         // Clean-up environment
         rs.close();
         stmt.close();
         conn.close();
      } 
      catch(SQLException se) 
      {
         //Handle errors for JDBC
         se.printStackTrace();
      } 
      catch(Exception e) 
      {
         //Handle errors for Class.forName
         e.printStackTrace();
      } 
      finally 
      {
       
      } 
   }
} 