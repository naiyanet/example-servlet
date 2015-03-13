/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.geniustree.intership.example.servlet;

import java.io.IOException;
import java.io.Writer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 *
 * @author M6500
 */
@WebServlet(urlPatterns = "/testscope")
public class TestScope extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username + " " + password);
        HttpSession session = req.getSession();
        if (session.getAttribute("username") == null) {
            if (username.equals(password)) {
                session.setAttribute("username", username);
                req.getRequestDispatcher("logincompleat.jsp").forward(req, resp);
            }else{
                req.getRequestDispatcher("login.html").forward(req, resp);
            }
        }else{
            req.getRequestDispatcher("logincompleat.jsp").forward(req, resp);
        }
    }

}
