package exceptions;

import java.sql.SQLException;

public class Examples {
  public static void main(String[] args) throws SQLException {
    System.out.println("Hello");
    try {
      System.out.println("in try");
      if (Math.random() > 0.5) {
        throw new RuntimeException("Busted");
      }
      if (Math.random() > 0.2) {
        throw new SQLException("BANG!");
      }
      System.out.println("try completing normally");
    } catch (RuntimeException re) {
      System.out.println("re " + re.getMessage());
//    } catch (Exception e) {
//      System.out.println("e " + e.getMessage());
    } finally {
      System.out.println("in finally");
    }
    System.out.println("finishing method");
  }
}
