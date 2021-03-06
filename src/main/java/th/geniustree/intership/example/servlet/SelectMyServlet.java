package th.geniustree.intership.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/myselect")
public class SelectMyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        System.out.println(id + " " + " " + name + " " + sex);
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", null);
            Statement createStatement = connection.createStatement();
            ResultSet rs = createStatement.executeQuery("SELECT * FROM TEST ");
            PrintWriter writer = resp.getWriter();
            writer.append("<html><body>");
            writer.append("<table border = 1>");
                writer.append("<tr>");
                    writer.append("<th>");
                        writer.append("id :");
                    writer.append("</th>");
                    writer.append("<th>");
                        writer.append("name :");
                    writer.append("</th>");
                    writer.append("<th>");
                        writer.append("sex :");
                    writer.append("</th>");
                writer.append("</tr>");
            while (rs.next()) {
                id = rs.getString("id");
                name = rs.getString("name");
                sex = rs.getString("sex");
                
                writer.append("<tr>");
                    writer.append("<td>");
                        writer.append(id);
                    writer.append("</td>");

                    writer.append("<td>");
                        writer.append(name);
                    writer.append("</td>");

                    writer.append("<td>");
                        writer.append(sex);
                    writer.append("</td>");
                writer.append("</tr>");
            }

            writer.append("</table>");
            writer.append("</body></html>");
        } catch (Exception ex) {
            Logger.getLogger(MyServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SelectMyServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
