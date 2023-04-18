package usingarrays;

import java.util.Arrays;

public class Example {
  public static void showAll(String[] names) {
    for (String n : names) {
      System.out.println(n);
    }
  }

  public static void main(String[] args) {
    int [] ia = new int[4];
    System.out.println(ia);
    System.out.println(Arrays.toString(ia));
    System.out.println(ia.length);
    ia[0] = 99;
    System.out.println(ia[0]);

    int [] newIa = new int[10];
    System.arraycopy(ia, 0, newIa, 0, ia.length);
    System.out.println(Arrays.toString(ia));
    System.out.println(Arrays.toString(newIa));
    ia = newIa; // seeminly reallocated the array

//    String [] names = new String[]{"Fred", "Jim", "Sheila"};
    String [] names = {
        "Fred",
        "Sheila",
        "Jim",
    };
//    ;
    showAll(names);
    showAll(new String[]{"Fred", "Jim", "Sheila"});
//    showAll({"Fred", "Jim", "Sheila"});

    int [][] ia2d = {
        { 1, 2, 3, 4 },
        { 5, 6 },
        { 7, 8, 9, 10, 11 }
    };

    System.out.println(Arrays.toString(ia2d));
    System.out.println(Arrays.deepToString(ia2d));
    System.out.println(Arrays.toString(ia2d[1]));
    System.out.println(ia2d[1][0]);
  }
}
