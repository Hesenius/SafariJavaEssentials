package staticfunctions;

public class PassByValue {
  public static void addOne(int x) {
    x++;
  }

  public static void addOne(String x) {
    x += " world";
    System.out.println("x is " + x);
  }

  public static void addOne(StringBuilder x) {
    x.append(" world");
    System.out.println("SB x is " + x);
  }

  public static void update(/*final*/ StringBuilder x) {
    x = new StringBuilder("Goodbye");
    System.out.println("SB x is " + x);
  }

  public static void main(String[] args) {
    int y = 99;
    addOne(y);
    System.out.println(y);

    String s = "Hello";
    addOne(s);
    System.out.println("s after is " + s);

    StringBuilder sb = new StringBuilder("Hello");
    addOne(sb);
    System.out.println("sb after is " + sb);

    update(sb);
    System.out.println("sb after is " + sb);

  }
}
