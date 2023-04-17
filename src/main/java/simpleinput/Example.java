package simpleinput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Scanner;

public class Example {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String line = input.nextLine();
    System.out.println("You said: " + line);

    BufferedReader keyInput = new BufferedReader(
        new InputStreamReader(System.in/*, StandardCharsets.UTF_8*/)
    );
    try {
      String aLine = keyInput.readLine();
      System.out.println("And you typed: " + aLine);
    } catch (IOException ioe) {
      System.out.println("huh, the keyboard broke!");
    }

    LocalDate today = LocalDate.now();
    System.out.println(today);
    double pi = Math.PI;
    System.out.printf("Template: today is %s and pi is %09.5f\n",
        today, pi);

  }
}
