package flowcontrol;

import java.util.List;

public class SimpleLoops {
  public static void main(String[] args) {
    int x = 0;
    while (x < 4) {
      System.out.println("x is now " + x);
      x++;
    }

    System.out.println("currently x is " + x);
    do {
      System.out.println("in the do loop x is " + x);
    } while(x != 4);

    // comma separated: statement expressions or variable
    // declarations of the same base type in part 1
    // comma separated statement expressions in part 3
    // but ... don't (probably)
    for (int idx = 0;
         idx < 4;
         idx++, System.out.println("Badd!!!")) {
      System.out.println("in for loop, idx is " + idx);
    }

    List<String> names = List.of("Fred", "Jim", "Sheila");
    for (String n : names) { // either an Iterable or array
      // this loop does NOT have any index
      System.out.println("foreach type has n is " + n);
    }

    for (int idx = 0; idx < names.size(); idx++) {
      System.out.println("Bad: item is " + names.get(idx));
    }

    System.out.println("foreach with skipping ---------------------");
    int index = 0;
    for (String n : names) { // either an Iterable or array
      if (index++ % 2 == 0) continue; // skip the rest of this iteration
      System.out.println("foreach type has n is " + n);
    }

    System.out.println("for with skipping ---------------------");
    int limit = names.size();
    for (int idx = 1; idx < limit; idx += 2) {
      System.out.println("Bad: item is " + names.get(idx));
    }

    // Java does recursion, but NOT tail recursion or other optimizations
    // therefore we don't usually use recursion for looping.
  }
}
