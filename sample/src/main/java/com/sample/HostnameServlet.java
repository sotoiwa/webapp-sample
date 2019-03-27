package com.sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InfoServlet
 */
@WebServlet("/hostname")
public class HostnameServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public HostnameServlet() {
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
    out.println("<title>hostname</title>");
    out.println("</head>");
    out.println("<body>");
    
    out.println("<a href=\"./\">top</a>");

    // ホスト名とIPアドレスを表示する
    out.println("<h4>Hostname and IP Address</h4>");
    InetAddress inetAddress = InetAddress.getLocalHost();
    out.println("<table border=1>");
    out.println("<tr>");
    out.println("<td>HostName</td>");
    out.println("<td>" + inetAddress.getHostName() + "</td>");
    out.println("</tr>");
    out.println("<tr>");
    out.println("<td>HostAddress</td>");
    out.println("<td>" + inetAddress.getHostAddress() + "</td>");
    out.println("</tr>");
    out.println("</table>");

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
