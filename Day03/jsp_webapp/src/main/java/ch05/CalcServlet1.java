package ch05;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet("/calc")
public class CalcServlet1 extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int num1 = Integer.parseInt(req.getParameter("num1"));
    int num2 = Integer.parseInt(req.getParameter("num2"));
    String op = req.getParameter("op");
    String message = "";
    int result = 0;
    switch (op) {
      case "+":
        result = num1 + num2;
        break;
      case "-":
        result = num1 - num2;
        break;
      case "*":
        result = num1 * num2;
        break;
      case "/":
        if (num2 == 0) {
          result = 0;
          message = "0으로 나눌 수 없습니다.";
        } else
          result = num1 / num2;
          break;
    }
    resp.setContentType("text/html; charset=UTF-8");
    resp.getWriter()
        .append("<h2>게산기 서블릿</h2>")
        .append("<p>계산결과 : " + result + "</p>")
        .append("<p> " + message + "</p>");
    saveData(num1, op, num2, result);
  }
  public static Connection makeConnection() {

    String url = "jdbc:mysql://localhost:3306/madang?serverTimezone=Asia/Seoul&useSSL=false&useUnicode=true&characterEncoding=UTF-8";
    Connection conn = null;

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      System.out.println("데이터베이스 연결중.........");
      conn = DriverManager.getConnection(url, "root", "1111");
      System.out.println("데이터베이스 연결 성공!");
    } catch (SQLException e) {
      System.out.println("데이터베이스 연결 실패!");
      System.out.println(e.getMessage());

    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
    return conn;
  }
  public static void saveData(int num1, String op, int num2, int result) {
    Connection conn = makeConnection();
    PreparedStatement ps = null;
    try {
      ps = conn.prepareStatement("insert into calc values (?, ?, ?, ?)");
      ps.setInt(1, num1);
      ps.setString(2, op);
      ps.setInt(3, num2);
      ps.setInt(4, result);

      int i = ps.executeUpdate();
//      if (i > 0) {
//        System.out.println(i + "건 레코드 추가 성공되었습니다.");
//      } else {
//        System.out.println(i + "건 레코드 추가 실패되었습니다.");
//      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
}
