package com.sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class JDBCServlet
 */
@WebServlet("/jdbc")
public class JDBCServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public JDBCServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html; charset=UTF-8");

    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>jdbc</title>");
    out.println("</head>");
    out.println("<body>");

    out.println("<a href=\"./\">top</a>");

    DataSource dataSource = null;
    Connection conn = null;

    // String dataSourceName = System.getenv("DATASOURCE_NAME");
    String dataSourceName = "jdbc/mydb";

    try {
      Context context = new InitialContext();
      dataSource = (DataSource) context.lookup(dataSourceName);
    } catch (NamingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    try {
      conn = dataSource.getConnection();

      PreparedStatement statement = conn.prepareStatement("select * from member");
      ResultSet rs = statement.executeQuery();
      out.println("<h4>JDBC</h4>");
      out.println("<table border=1>");
      out.println("<tr>");
      out.println("<th>id</th>");
      out.println("<th>name</th>");
      out.println("</tr>");
      while (rs.next()) {
        out.println("<tr>");
        out.println("<td>" + rs.getInt("id") + "</td>");
        out.println("<td>" + rs.getString("name") + "</td>");
        out.println("</tr>");
      }
      out.println("</table>");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      try {
        if (conn != null)
          conn.close();
      } catch (SQLException e) {
      }
    }

    out.println("</body>");
    out.println("</html>");
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
