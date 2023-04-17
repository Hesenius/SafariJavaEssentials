package flowcontrol;

public class UsingArrowSwitch {
  public static void main(String[] args) {
    int x = 98;
    switch (x) {
      case 98, 99 -> {
        System.out.println("it's 98 or ninetynine");
        // only break from arrows in a block
        if (Math.random() > 0.5) break; //UGLY But legal ;)
        System.out.println("single statement!!");
      }
      case 100 ->
        System.out.println("one hundred");
      default ->
        System.out.println("something else");
    }
  }
}
