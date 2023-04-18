package usinglists;

import java.time.LocalDate;
import java.util.*;

public class Example {
//  public static void showList(ArrayList<String> als) {
//  public static void showList(List<String> als) {
//  public static void showList(Collection<String> als) {
//  public static void showList(Iterable<String> als) {
  public static <E> void showList(Iterable<E> als) {
//  public static void showList(Object als) {
//    for (String s : als) {
//      System.out.println(">> " + s);
//    }

    Iterator<E> iter = als.iterator();
    while (iter.hasNext()) {
      E item = iter.next();
      System.out.println(">> " + item);
    }
  }

  public static void main(String[] args) {
//    var names = new ArrayList<String>(
    List<String> names = new ArrayList<>(
        List.of("Alice"/*, LocalDate.now()*/)
    );
    System.out.println(names);
    System.out.println(names.size());
    boolean success = names.add("Fred");
    names.add("Jim");
    names.add("Sheila");
    System.out.println(names);
    System.out.println(names.size());
//    names.add(LocalDate.now());
//    System.out.println(names);
//    System.out.println(names.size());

//    Object nameOne = names.get(0);
    String nameOne = names.get(0);
    System.out.println(nameOne);

    showList(names);
    List<String> n2 = new LinkedList<>();
    showList(n2);

  }
}
