package closure;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ExampleTwo {
  public static <E> List<E> filter(
      Iterable<E> roster, Predicate<E> crit) {
    ArrayList<E> res = new ArrayList<>();
    for (E s : roster) {
      if (crit.test(s)) {
        res.add(s);
      }
    }
    return res;
  }

  public static <E> Predicate<E> and(Predicate<E> first, Predicate<E> second) {
    return e -> {
      return first.test(e) && second.test(e);
    };
  }
  public static void main(String[] args) {
    List<String> words = List.of(
        "Aardvark", "Bicycle", "Me", "You", "Us", "Them", "Longerwords", "A");
    System.out.println(
        filter(filter(words, s -> s.length() > 4),
            s -> s.length() < 9));
    System.out.println("-------------");
    Predicate<String> longish = s -> s.length() > 4;
    Predicate<String> shortish = s -> s.length() < 9;
    System.out.println(
        filter(words,
            and(longish, shortish)));

    // in your own time:
    // or, negate
    // BUT, these are all part of the core api of Predicate
    // also look for behavior factories in Comparator
  }
}
