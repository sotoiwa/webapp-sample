package com.sample;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/session")
public class SessionServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public SessionServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    HttpSession session = request.getSession(false);

    // deleteボタンが押されたときはSessionを削除
    if (request.getParameter("delete") != null && session != null) {
      session.invalidate();
      session = null;
    }

    // incrementボタンが押されたときはカウントアップする
    if (request.getParameter("increment") != null) {
      Integer counter = null;
      if (session != null && session.getAttribute("counter") != null) {
        // セッションが取得できた場合はカウンタを取り出す
        counter = (Integer) session.getAttribute("counter");
      } else {
        // セッションが取得できなければ新規作成
        session = request.getSession(true);
        counter = 0;
      }
      counter += 1;
      session.setAttribute("counter", counter);
    }

    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>session</title>");
    out.println("</head>");
    out.println("<body>");

    out.println("<a href=\"./\">top</a>");

    // Sessionを表示する
    out.println("<h4>Session</h4>");
    out.println("<table border=1>");
    out.println("<tr>");
    out.println("<td>Session ID</td>");
    out.println("<td>");
    if (session != null) {
      out.println(session.getId());
    } else {
      out.println("null");
    }
    out.println("</td>");
    out.println("</tr>");
    out.println("<tr>");
    out.println("<td>Counter</td>");
    out.println("<td>");
    if (session != null && session.getAttribute("counter") != null) {
      out.println(session.getAttribute("counter"));
    } else {
      out.println("null");
    }
    out.println("</td>");
    out.println("</tr>");
    out.println("</table>");

    out.println("<form action=\"./session\" method=\"get\">");
    out.println("<input type=\"submit\" name=\"increment\" value=\"increment\">");
    out.println("<input type=\"submit\" name=\"delete\" value=\"delete\">");
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
