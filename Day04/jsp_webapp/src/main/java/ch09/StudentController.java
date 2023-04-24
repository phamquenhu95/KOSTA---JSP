package ch09;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/studentControl")
public class StudentController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  StudentDAO dao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    dao = new StudentDAO();
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    String action = req.getParameter("action");
    String view = "";
    if(action == null) {
      getServletContext().getRequestDispatcher("/studentControl?action=list").forward(req, resp);
    } else {
      if (action.equals("list")) {
        view = list(req, resp);
      } else if (action.equals("insert")) {
        view = insert(req, resp);
      }
      getServletContext().getRequestDispatcher("/ch09/" + view).forward(req, resp);
    }
  }
  public String list(HttpServletRequest req, HttpServletResponse resp) {
    req.setAttribute("students", dao.findAll());
    return "studentInfo.jsp";
  }

//  public String insert(HttpServletRequest req, HttpServletResponse resp) {
//
//    System.out.println(req.getParameter("username"));
//    System.out.println(req.getParameter("univ"));
//    System.out.println(req.getParameter("birth"));
//    System.out.println(req.getParameter("email"));
//
//    System.out.println(username);
//    System.out.println(univ);
//    System.out.println(birth);
//    System.out.println(email);
//    dao.insert(username, univ, birth, email);
//
//    return list(req, resp);
////    return "";
//  }

  public String insert(HttpServletRequest req, HttpServletResponse resp) {
    Student s = new Student();
    try {
      BeanUtils.populate(s, req.getParameterMap());
    } catch (Exception e) { e.printStackTrace(); }
    dao.insert(s);
    return list(req, resp);
  }
}
