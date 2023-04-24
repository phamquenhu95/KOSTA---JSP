package ch05;

import java.sql.*;

public class JDBCDemo {
  public static void main(String[] args) {
    Connection conn = makeConnection();
    PreparedStatement ps = null;
    try {
      ps = conn.prepareStatement("insert into calc" +
          " values (?, ?, ?, ?)");
      ps.setInt(1, 1);
      ps.setString(2, "+");
      ps.setInt(3, 2);
      ps.setInt(4, 3);


      int i = ps.executeUpdate();
      if (i > 0) {
        System.out.println(i + "건 레코드 추가 성공되었습니다.");
      } else {
        System.out.println(i + "건 레코드 추가 실패되었습니다.");
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());

    }
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
}