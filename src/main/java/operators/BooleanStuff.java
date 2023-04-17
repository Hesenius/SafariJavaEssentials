package operators;

public class BooleanStuff {
  public static boolean getTrue() {
    System.out.println("Evaluating true!");
    return true;
  }

  public static void main(String[] args) {
    int x = 10;
    int y = 20;
    int z = 30;
    System.out.println(x > y || y < z);
    System.out.println(x > y && y < z);
    System.out.println(x > y | y < z);
    System.out.println(x > y & y < z);
    System.out.println("------------");
    System.out.println(x > y || getTrue());
    System.out.println(x > y && getTrue());
    System.out.println(x > y | getTrue());
    System.out.println(x > y & getTrue());
  }
}
