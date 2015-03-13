package th.geniustree.intership.example.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/my")
public class MyServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String[] parameterValues = req.getParameterValues("check");
        String header = req.getHeader("User-Agent");
        System.out.println(header);
        System.out.println(parameterValues.length);
        System.out.println(id+" "+name+" "+sex);
        Connection connection = null;
        PrintWriter writer = resp.getWriter();
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa",null);
            Statement createStatement = connection.createStatement();
            int rs = createStatement.executeUpdate("INSERT INTO TEST (ID,NAME,SEX) VALUES ('"+id+"','"+name+"','"+sex+"')");
            
            writer.append("insert rows = "+rs);
        } catch (Exception ex) {
            Logger.getLogger(MyServlet.class.getName()).log(Level.SEVERE, null, ex);
            writer.append(ex.getMessage());
        }finally{
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MyServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    };

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp); 
    }
    
}
