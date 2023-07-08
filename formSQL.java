package servelet;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class formSQL extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String n=request.getParameter("userName");  
            String p=request.getParameter("userPass");  
            String e=request.getParameter("userEmail");  
            String c=request.getParameter("userCountry");  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employees?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false","root","root");  
            PreparedStatement ps=con.prepareStatement("insert into Newforms values(?,?,?,?)");   
ps.setString(1,n);  
ps.setString(2,p);  
ps.setString(3,e);  
ps.setString(4,c);        
int i=ps.executeUpdate();  
if(i>0)  
out.print("Congratulations!!You have successfully been registered...");   
//request.getRequestDispatcher("frontend.html").include(request, response);  
}catch (Exception e2) {System.out.println(e2);}     
out.close();  
}  
}       
 
