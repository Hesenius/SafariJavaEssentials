package superiterable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class UseSuperIterable {
  public static void main(String[] args) {
    List<String> nameData = List.of("Alice", "Charlie", "Bob", "Devon");
    SuperIterable<String> names = new SuperIterable<>(nameData);

    for (String s : names) {
      System.out.println("> " + s);
    }
    System.out.println("---------------");

    names
        .filter(s -> s.length() > 3)
        .forEach(s -> System.out.println("> " + s));
    System.out.println("---------------");

    names
        .filter(s -> s.length() > 3)
        .map(s -> s.toUpperCase())
        .forEach(s -> System.out.println("> " + s));
    System.out.println("---------------");

    names
        .filter(s -> s.length() > 3)
        .map(s -> s.length())
        .forEach(s -> System.out.println("> " + s));
    System.out.println("---------------");

    names
        .flatMap(s -> {
          ArrayList<String> als = new ArrayList<>();
          for (int idx = 0; idx < s.length() - 1; idx++) {
            als.add(s.substring(idx));
          }
          return new SuperIterable<>(als);
        })
        .forEach(s -> System.out.println("> " + s));
    System.out.println("Streams: ---------------");

    nameData.stream()
        .filter(s -> s.length() > 3)
        .forEach(s -> System.out.println("> " + s));
    System.out.println("---------------");

    nameData.stream()
        .filter(s -> s.length() > 3)
        .map(s -> s.toUpperCase())
        .forEach(s -> System.out.println("> " + s));
    System.out.println("---------------");

    nameData.stream()
        .filter(s -> s.length() > 3)
        .map(s -> s.length())
        .forEach(s -> System.out.println("> " + s));
    System.out.println("---------------");

    nameData.stream()
        .flatMap(s -> {
          ArrayList<String> als = new ArrayList<>();
          for (int idx = 0; idx < s.length() - 1; idx++) {
            als.add(s.substring(idx));
          }
          return als.stream();
        })
        .forEach(s -> System.out.println("> " + s));
    System.out.println("---------------");

    boolean res = nameData.stream()
//        .peek(s -> System.out.println(s))
        .map(s -> { // equivalent to above peek :)
          System.out.println(s);
          return s;
        })
        .allMatch(s -> s.length() > 4)
//        .forEach(s -> System.out.println(">> " + s))
    ;
    System.out.println(res);

    System.out.println("---------------");
    // example infinite stream!
//    IntStream.iterate(0, x -> x + 1)
//        .forEach(s -> System.out.println(s));

    int total = IntStream.iterate(1, x -> x + 1)
        .limit(10)
        .reduce(0, (a, b) -> a + b);
    System.out.println("total is " + total);
    // look up a collect(Collector) method on Stream
    // and Collectors (class full of static factorires for Collector object)

  }
}
