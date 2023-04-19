package closure;

import java.util.function.Function;

public class Examples {
  public static Function<Integer, Integer> getAdder() {
    return p -> p + 10;
  }

  public static Function<Integer, Integer> getAdder2(/*final*/ int x) {
    // "closured" variable must be final or "effectively final"
//    x++;
    return a -> {
//      x++;
      return a + x;
    };
  }

  public static void main(String[] args) {
    Function<Integer, Integer> addTen = getAdder();

    System.out.println("3 addTen is " + addTen.apply(3));

    var addThree = getAdder2(3);
    System.out.println("3 add 3 is " + addThree.apply(3));

    var addSeven = getAdder2(7);
    System.out.println("3 add 7 is " + addSeven.apply(3));

    // java can't do this:
//    System.out.println("5 add 3 is " + getAdder2(5)(3)); // Called "currying"
    // but can do this:
    System.out.println("5 add 3 is " + getAdder2(5).apply(3));

  }
}
