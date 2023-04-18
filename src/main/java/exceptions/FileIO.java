package exceptions;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileIO {
  public static void main(String[] args) throws IOException {
    BufferedReader keyboard = new BufferedReader(
        new InputStreamReader(System.in)
    );

    System.out.print("Enter filename ");
    String fn = keyboard.readLine();

    // br is now a "resource" and will be closed "reliably"
    // using "try-with-resources" FIRST exception will be thrown to caller
    // if not handled, addition (likely close...) exceptions
    // will be chained onto that first exception
    // "getSuppresed" gets array of Throwable
    // resource can be pre-declared, but must be final (or "effectively" final)
    // effectively final means "is never reassigned"
    // resources closed in reverse order of "mention" in the resource block
    // resources must "implement AutoCloseable"
    try (
        BufferedReader br = Files.newBufferedReader(Path.of(fn));
        FileWriter fr = new FileWriter("output.txt");) {
      String line;
      while ((line = br.readLine()) != null) {
        System.out.println("> " + line);
      }
      System.out.println("All done");
//      br.close(); // closes "down the pipeline" -- not reliable here
    } catch (FileNotFoundException fnfe) {
      System.out.println("File not found");
    } catch (IOException ioe) {
      System.out.println("Hmm, io problem");
//    } finally { // no finally needed when using "resources"
//      br.close();
    }
    // multi-catch can describe a list of non-parent-child type
    // exceptions and catch all of them for handling the same way
    // e.g.
    // catch (FileNotFoundException | SQLException ex)
  }
}
