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
//public class ProductControllerVer1 extends HttpServlet {
//  ProductService pService;
//  // Interface pService
//
//
//  @Override
//  public void init(ServletConfig config) throws ServletException {
//    super.init(config);
//    pService = new ProductService();
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
//    req.setAttribute("p", pService.find(req.getParameter("id")));
//    return "productInfo.jsp";
//  }
//
//  private String list(HttpServletRequest req, HttpServletResponse resp) {
//    req.setAttribute("products", pService.findAll());
//    return "productList.jsp";
//  }
//}
