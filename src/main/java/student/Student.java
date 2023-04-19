package student;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//interface CriterionOfStudent {
//  boolean test(Student s);
//}

class SmartStudent implements Predicate<Student> {
  @Override
  public boolean test(Student s) {
    return s.grade() > 65;
  }
}

//class EnthusiastiStudent implements CriterionOfStudent {
class EnthusiastiStudent implements Predicate<Student> {
  @Override
  public boolean test(Student s) {
    return s.courseCount() > 2;
  }
}

// args here are called "components" they create:
// - constructor that initializes the
// - private final fields that store the component values
// - equals and hashCode
// - toString
// - access methods with simple names name() grade()
// NO MUTATORS -- records are intended to be immutable
public record Student(String name, int grade, int courseCount) {
  @Override // this is NOT really overriding, it's replacing
  public String toString() {
    return "I'm a student with name " + name + " and grade " + grade
//        + super.toString() // NOPE, there is no super to invoke
        ;
  }

  // canonical constructor has parameter list declared by the opening line
  // auto-generated like this:
  // formal param names MUST match
//  public Student(String name, int grade, int courseCount) {
//    // only reason to do this would be validation
//    this.name = name;
//    this.grade = grade;
//    this.courseCount = courseCount;
//  }
  // Compact constructor, ONLY does "pre-work"
  // cannot refer to the fields, but can refer to the formal params
  public Student {
    if (name == null || name.length() < 0) throw new IllegalArgumentException();
    // rolls onto the canonical constructor after this is complet
    // DO NOT initialize the fields
  }

  // cannot define your own instance fields
//  int x;
  // can define static fields, static methods,
  // and arbitrary instance methods
}

class UseStudents {
  public static <E> void showAll(Iterable<E> is) {
    for (E s : is) {
      System.out.println("> " + s);
    }
    System.out.println("----------------------");
  }

//  public static List<Student> filter(
////      Iterable<Student> roster, int threshold) {
////      Iterable<Student> roster, CriterionOfStudent crit) {
//      Iterable<Student> roster, Predicate<Student> crit) {
//    ArrayList<Student> res = new ArrayList<>();
//    for (Student s : roster) {
////      if (s.grade() > threshold) {
//      if (crit.test(s)) {
//        res.add(s);
//      }
//    }
//    return res;
//  }

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

  public static void main(String[] args) {
    List<Student> roster = List.of(
        new Student("Fred", 74, 2),
        new Student("Jim", 52, 1),
        new Student("Sheila", 92, 4)
    );

    showAll(roster);
//    showAll(getSmart(roster, 65));
//    showAll(getSmart(roster, 45));
    showAll(filter(roster, new SmartStudent()));
    showAll(filter(roster, new EnthusiastiStudent()));
    showAll(filter(roster,
        new /*class SmartStudent implements */Predicate<Student>() {
          @Override
          public boolean test(Student s) {
            return s.grade() < 75;
          }
        }
    ));
//    showAll(getSmart(roster,
//        // MUST BE an interface context
//        // that interface declares EXACTLY ONE abstract method
//        // AND we only wish to implement THAT ONE method
//        /*new Predicate<Student>() { */
//          /*@Override
//          public boolean test*/(Student s) -> {
//            return s.grade() < 75;
//          }
//        /*}*/
//    ));
//    showAll(getSmart(roster,
// all formal params must be declared "the same way"
//        (Student s) -> {
//        (@Deprecated var s) -> {
//        s -> {
//          return s.grade() < 75;
//        }
//        s -> s.grade() < 75 ));

    showAll(filter(roster, s -> s.grade() < 75));

    Predicate<Student> obj = (Student s) -> {
      return s.grade() < 75;
    };

    System.out.println("obj class is " + obj.getClass().getName());
    Class<?> cl = obj.getClass();
    Method [] methods = cl.getMethods();
    for (Method m : methods) {
      System.out.println(">> " + m);
    }
  }
}
