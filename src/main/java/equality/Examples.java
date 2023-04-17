package equality;

public class Examples {
  public static void main(String[] args) {
    int x = 99;
    int y = 99;
    int z = 100;
    System.out.println(x == y);
    System.out.println(x == z);
    System.out.println(x != y);
    System.out.println(x != z);

    System.out.println("----------");
    String s1 = "Hello";
    String s2 = "He";
    System.out.println(s1 == s2);
//    s2.concat("llo"); // String in Java is IMMUTABLE
    String s3 = s2.concat("llo");
    System.out.println("s1 is " + s1);
    System.out.println("s2 is " + s2);
    System.out.println("s3 is " + s3);
    s2 = s2.concat("llo");
    System.out.println("s2 is " + s2);
    System.out.println("s1 == s2? " + (s1 == s2));

    System.out.println("s1.equals(s2) " + s1.equals(s2));

    String s4 = "Hello"; // constant pooling
    System.out.println(s1 == s4); // same object in memory

    // IF we believe that duplicates are likely, we can put our own
    // Strings in the pool:
    System.out.println("s1 == s2? " + (s1 == s2));
    s2 = s2.intern(); // look for this in the pool, add if not present
    System.out.println("s1 == s2? " + (s1 == s2));

    StringBuilder sb1 = new StringBuilder("Hello");
    StringBuilder sb2 = new StringBuilder("Hello");
    System.out.println("sb1 == sb2 " + (sb1 == sb2));
    // Most mutable data types do NOT provide equality testing...
    System.out.println("sb1.equals(sb2) " + sb1.equals(sb2));


    int a = 99;
//    a. // nope 'a' is not an object, doesn't have member behaviors...

    // Wrapper types:
//    long -> Long
//    int -> Integer
    // home for utility methods
//    Integer.
//    Integer ninetyNine = Integer.valueOf(99);
//    int nn = ninetyNine.intValue();
    // these are equivalent to the above
    // compiler writes the code "autoboxing" and "auto-unboxing"
    Integer ninetyNine = 99;
    int nn = ninetyNine;
    Integer ninetyNineAgain = Integer.valueOf(99);
    System.out.println(ninetyNineAgain == ninetyNine);
    Integer bigOne = 256;
    Integer bigAgain = 256;
    // pooling in range -128 + 127
    System.out.println(bigOne == bigAgain);

    // constructors are deprecated for these
    // because pooling doesn't happen AND OTHER REASONS
//    Integer nnThree = new Integer(99);
//    System.out.println(nnThree == ninetyNineAgain);
  }
}
