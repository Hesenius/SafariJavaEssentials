package sealedtypes;

enum Suit {
  HEARTS, DIAMONDS, SPADES {}, CLUBS;
  // Constructors, methods, fields blah blah
}

// sealed type hierarchies give us control, not of *instances* but of
// subtypes

// permits clause can be elided if (but only if)
// all these types are in the same source file
sealed interface Vehicle permits Car, Truck {}

//sealed class Car implements Vehicle permits XXX{}
non-sealed class Car implements Vehicle {} // probably not a great design
//final class Truck implements Vehicle {}
// record is implicitly final
record Truck(int payload) implements Vehicle {}
// enums are "kinda" final (all child types must be declared inside the type
//class Bicycle implements Vehicle {}

public class Example {
  public static void main(String[] args) {
    Vehicle v = new Car();

    if (v instanceof Car c) {
      // use a car
      System.out.println("it's a car");
    } else if (v instanceof Truck t) {
      // use the truck
      System.out.println("it's a truck");
    }
  }
}
