package flowcontrol;

public class Conditions {
  public static void main(String[] args) {
    // simple if/else
    int x = (int) (Math.random() * 100);

    if (x > 50) { // must have parens, must be boolean expression
      System.out.println("it's big");
    } else if (x > 25) {
      System.out.println("it's medium");
    } else {
      System.out.println("it's small");
    }

    // conditional expression
    String message = (x > 50) ? "Big value" : "Small value";
    System.out.println(message);

    // var can create a "non-denotable" type :)
    var obj = (x > 50) ? "It's big" : 99;
//    Comparable obj = (x > 50) ? "It's big" : 99;
    System.out.println("obj is " + obj);
    System.out.println("obj type is " + obj.getClass().getName());

//    String s = "";
//    Integer i1 = 99;
  }
}
