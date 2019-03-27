package com.sample;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SleepServlet
 */
@WebServlet("/sleep")
public class SleepServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public SleepServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // sleepボタンが押されたとき
    if (request.getParameter("sleep") != null) {
      try {
        Thread.sleep(Integer.parseInt(request.getParameter("sleep")) * 1000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        throw new ServletException(e);
      }
    }

    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>sleep</title>");
    out.println("</head>");
    out.println("<body>");

    out.println("<a href=\"./\">top</a>");

    out.println("<h4>Sleep</h4>");

    out.println("<form action=\"./sleep\" method=\"get\">");
    out.println("<input type=\"text\" name=\"sleep\" size=\"4\">");
    out.println("<input type=\"submit\" value=\"sleep\">");
    out.println("</form>");

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
