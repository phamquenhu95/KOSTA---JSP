//package ch08;
//
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet("/pcontrol")
//public class ProductController extends HttpServlet {
// ProductInterface service;
//  // Interface pService
//
//
//  @Override
//  public void init(ServletConfig config) throws ServletException {
//    super.init(config);
////    oracledao = new ProductOracleDAO();
//    // pService = new ProductDAO();
//  }
//
//  @Override
//  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    super.doGet(req, resp);
//  }
//
//  @Override
//  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    String action = req.getParameter("action");
//    String view = "";
////    System.out.println("view =" +view);
//
//    if (action == null) {
//      getServletContext().getRequestDispatcher("/pcontrol?action=list").forward(req, resp);
//    } else {
//      if (action.equals("list")) {
//        view = list(req, resp);
////      System.out.println(view);
////      System.out.println("view =" +view);
//      } else if (action.equals("info")) {
//        view = info(req, resp);
////      System.out.println(view);
////      System.out.println("view =" +view);
//      }
//      getServletContext().getRequestDispatcher("/ch08/" + view).forward(req, resp);
//    }
//  }
//
//  private String info(HttpServletRequest req, HttpServletResponse resp) {
//    req.setAttribute("p", service.find(req.getParameter("id")));
//    return "productInfo.jsp";
//  }
//
//  private String list(HttpServletRequest req, HttpServletResponse resp) {
//    req.setAttribute("products", service.findAll());
//    return "productList.jsp";
//  }
//  private String update(HttpServletRequest req, HttpServletResponse resp) {
//    req.setAttribute("products", service.update("101", "애플_update", 1300000,"2023-04-24"));
//    return "productUpdate.jsp";
//  }
//}
