package variables;

public class Examples {
  public static void main(String[] args) {
//    long aLong;
//    Long anotherThing;

    int x = 99;
//    x = "Hello";
    long bigNum = 3_000_000_000L;

    double pi = 3.141;

    char a = 'a'; // single quotes for characters (double for text String)

    // since Java 10
    // type inference for *local* variables
    var name = "Fred"; // must be initialized
//    name = 99; //NO, still not permitted

    boolean isIt = true; // true / false literals

//    if (x) {} // NOPE, no "truthy/falsy" concept, must convert
    if (x != 0) {} // NOPE, no "truthy/falsy" concept, must convert

    // only "general" conversion in Java (other than "widening")
    // conversion to string is automatic if the "other operand" is String
    System.out.println("hello " + x);
    // order of operations is left to right (unless parens/precedence dictates)
    System.out.println("Hello " + 1 + 2 + 3);
    System.out.println(1 + 2 + 3 + "Hello ");

    // in Java 17 -- text blocks
    String jsCode = """
        Hello, this is text  \n""   ""\"""\"""   \\ 
           common indents are removed   """;
    System.out.println("string length is " + jsCode.length());
    System.out.println(jsCode + "XXX");

    int count = 99;
//    System.out.println(count++);
//    System.out.println(count++);
    System.out.println(++count);
    System.out.println(++count);
  }
}
