package flowcontrol;

public class ArrowSwitchExpression {
  public static void main(String[] args) {
    int x = 98;
    // no break in switch EXPRESSION (it wouldn't produce a value)
    // currently switch works on int and smaller numerics
    // String, and enums (future will have type matching, field extraction
    // and a bunch of other stuff on arbitrary object types!)
    String message = switch (x) {
// if you can use this, why use colon??
//      case 98, 99: yield "it's 98 or ninetynine";
//      case 100: yield "one hundred";
//      default: yield "something else";

      case 98, 99 -> {
        String msg = "it's 98";
        msg +=  "or ninetynine";
//        return; // NOT ALLOWED -- would return from the function
        yield msg;
      }
      case 100 -> "one hundred";
      default -> throw new IllegalArgumentException("Bad input value");
    };
    System.out.println("message is " + message);
  }
}
