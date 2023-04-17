package flowcontrol;

public class UsingOldSwitch {
  public static void main(String[] args) {
    int x = 98;
    switch (x) {
      case 98, 99: // this is new ...
//      case 99:
        System.out.println("it's 98 or ninetynine");
        break;
      case 100:
        System.out.println("one hundred");
        break;
      default:
        System.out.println("something else");
        break;
    }
  }
}
