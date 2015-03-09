package th.geniustree.intership.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import th.geniustree.intership.example.model.Student;

@WebServlet(urlPatterns = "/myselect1")
public class SelectMyServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = null;
        List<Student> students = new ArrayList<>();
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", null);
            Statement createStatement = connection.createStatement();
            ResultSet rs = createStatement.executeQuery("SELECT * FROM TEST ");
            
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("ID"));
                s.setName(rs.getString("NAME"));
                s.setSex(rs.getString("SEX"));
                s.setBod(rs.getDate("BOD"));
                students.add(s);
            }
        } catch (Exception ex) {
            Logger.getLogger(MyServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SelectMyServlet1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        req.setAttribute("students", students);
        req.getRequestDispatcher("/test-jsp.jspx").forward(req, resp);
        
    }

}
