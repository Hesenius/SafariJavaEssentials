package usingclasses;

interface Texable {
  // public and abstract by default
  String getAsText();
  // interfaces since Java 8 permit
  // static methods, public and private (nothing in between)
  // private instance methods
  // public default methods -- fallback defintions of instance method
  // public static final fields
}

public class Date {
  // label public "anywhere in the JVM" (except with Modules/JPMS)
  // label protected -- same package (as below) PLUS in subtypes (mostly)
  // label with "nothing"--accessible in the same package
  // label with private--accessible inside the enclosing TOP LEVEL curlies
//  class Other {
//    private int x;
//  }
//  class YesAnother {
//    private int x;
//  }


  // if your object contains mutable data, it should be private
  // simon's advice, not syntax!
  private int day = getDefaultDay();
  {
    System.out.println("instance initionalizer block");
  }
  private int month;
  private int year = 2023;
  {
    System.out.println("instance initionalizer block");
  }

  public static int getDefaultDay() {
    System.out.println("getting default day");
    return 1;
  }

  public static int MAX_MONTH = 11;
  static {
    MAX_MONTH++;
  }

  // object (zeroed) passed in here as implicit argument called "this"
  // BE CAREFUL, do NOT put a return type in this, otherwise you
  // created a method NOT a constructor
  public Date(int day, int month, int year) {
    // if you don't say this() nor super(), you get super(); from compiler
    System.out.println("in day, month, year constructor");
    if (!isValid(day, month, year)) {
      throw new IllegalArgumentException("Bad date value(s)");
    }
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public Date(int day, int month) {
    this(day, month, 2023);
    // validate??
//    this.day = day;
//    this.month = month;
  }

//  public Date() {
//    this.day = 1;
//    this.month = 1;
//    this.year = 1970;
//  }
// "this" is the "receiver parameter" (the thing before the dot
//  in the method invocation). Java allows explict declaration,
//  but that is optional, and NOT convetional
//  public void setDay(@NotNull Date this, int day) {
  public void setDay(int d) {
    if (!isValid(d, this.month, this.year)) {
      throw new IllegalArgumentException("Bad date values");
    }
//    day = d;
    this.day = d;
  }

  public int getDay() {
    return this.day;
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  @Override
  public String toString() {
    return "Date{" +
        "day=" + day +
        ", month=" + month +
        ", year=" + year +
        '}';
  }

  public static boolean isValid(int day, int month, int year) {
    // excellent opportunity for switch expression! (needs to know if leap year)
    int maxDaysInMonth = 31;// daysInMonth(month, year);
    return day > 0 && day <= maxDaysInMonth
        && month > 0 && month < 13;
  }
}

// class based, single inheritance.
class Holiday extends Date implements Texable {
  private String name;
  // if there are ZERO coded constructors, the compiler creates
  // a "default" constructor. For normal classes this is:
  // Zero args, accessibility matches the class, body is:
//  Holiday() {
//    super();
//  }
  Holiday(int day, int month, int year, String name) {
    super(day, month, year);
    // run instance initialization
    this.name = name;
  }

  @Override
  public String toString() {
    return "I'm a holiday called " + name
        + " on: " + super.toString();
  }

  public void sayHoliday() {
    System.out.println("Holiday");
  }

  @Override
  public String getAsText() {
    return "I'm a holiday!";
  }
}
/*
new allocates and zeros, and passes control the "matching" constructor
which is in the ultimate subtype
but FIRST THING is either super or this, if "this" chain until we reach
super, which means we "sidestep" a bit, but then we go up the hierarchy.
-immediately upon return from super(...), run the instance initialization
 */
class UseDate {

  public static void main(String[] args) {
//    Date d = new Date();
//    // oops, date is invalid!!!
//    d.day = 18;
//    d.month = 4;
//    d.year = 2023;

    Date d = new Date(18, 4, 2023);
//    d.day = -100;
//    d.setDay(-100); // EXCEPTION, invalid
    System.out.println(d);
    System.out.println(d.getDay());
//    Date d2 = new Date(18, 40, 2023);

    Date d3 = new Date(12, 6);
    System.out.println("year of d3 is " + d3.getYear());

//    Holiday nyd = new Holiday(1, 1, 2024, "New Year's Day");
    Date nyd = new Holiday(1, 1, 2024, "New Year's Day");
//    Holiday nyd = new Holiday(1, 1, 2024, "New Year's Day");
    System.out.println(nyd.toString());

//    if (nyd instanceof String) { // impossible, rejected by compiler
    if (nyd instanceof Holiday h && h.getDay() == 1) {
      System.out.println("It's a holiday!!");
//      Runnable h = (Runnable)nyd;
//      Holiday h = (Holiday)nyd;
      h.sayHoliday();
//    } else {
//      h.say // h is not available here!
    }
  }
}