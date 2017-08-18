package com.spring.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    String user = "dev";
    String pass = "developer";
    String url = "jdbc:mysql://p2.c5udk0ltfwse.us-west-1.rds.amazonaws.com:3306/picoria";
    String driver = "com.mysql.cj.jdbc.Driver";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            PrintWriter out = response.getWriter();
            out.println("Connecting to DB");
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, pass);

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from customer");
            while (rs.next())
                out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            out.println("Success");

            con.close();

//            response.getWriter().append("Served at : ").append(request.getContextPath());
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PrintWriter out = response.getWriter();
            out.println("Connecting to DB");
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, pass);

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from customer");
            while (rs.next())
                out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            out.println("Success");


            con.close();

//            response.getWriter().append("Served at : ").append(request.getContextPath());
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
