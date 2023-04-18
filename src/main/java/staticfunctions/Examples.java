package staticfunctions;

public class Examples {
//  public static void doStuff(int [] xs) {
  public static void doStuff(int ... xs) {
    for (int x : xs) {
      System.out.println("> " + x);
    }
  }

  public static void doStuff(int x) {
    System.out.println("doStuff(int) x is " + x);
  }

  public static void doStuff(long x) {
    System.out.println("doStuff(long) x is " + x);
  }

  public static void doStuff() {
    doStuff(99); // is this a default argument?
  }

  public static void doStuff(long x, int y) {
    System.out.println("doStuff(long) x is " + x);
  }

  public static void doStuff(int x, long y) {
    System.out.println("doStuff(long) x is " + x);
  }

  public static Integer add(Integer x, Integer y) {
    return x + y;
  }

  // Java does NOT have "named" argument passing, ONLY positional
  // NOR default arguments (but can often use overloading instead)

  public static void main(String[] args) {
    staticfunctions.Examples.doStuff(99);
    Examples.doStuff(99);
    doStuff(99);
    doStuff(99L);

//    doStuff(1, 2); // Ambiguous invocation fails to compile
//    doStuff(1L, 2L); // there is no (long, long) version :)

    doStuff(new int[]{1,2,3});
    doStuff(5,4,3,2); // varargs must be last in the parameter list

    int sum = add(1, 2);
  }
}
