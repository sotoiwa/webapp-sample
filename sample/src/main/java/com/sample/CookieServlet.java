package com.sample;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet
 */
@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public CookieServlet() {
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
    out.println("<title>cookie</title>");
    out.println("</head>");
    out.println("<body>");

    out.println("<a href=\"./\">top</a>");

    // Cookieを表示する
    out.println("<h4>Cookies</h4>");
    Cookie[] cookies = request.getCookies();
    // Cookieがある場合は表示
    if (cookies != null) {
      out.println("<table border=1>");
      for (Cookie cookie : cookies) {
        out.println("<tr>");
        out.println("<td>" + cookie.getName() + "</td>");
        out.println("<td>" + cookie.getValue() + "</td>");
        out.println("</tr>");
      }
      out.println("</table>");
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
