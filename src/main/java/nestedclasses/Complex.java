package nestedclasses;

public class Complex /*extends Object*/ {
  private String name;
  private int count;

  private Complex(String name, int count) {
    this.name = name;
    this.count = count;
  }

  public static class Builder {
    private String name;
    private int count;

    private Builder() {
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder count(int count) {
      this.count = count;
      return this;
    }

    public Complex build() {
      // can use "long name"
      if (/*Complex.*/isValid(name, count)) {
        return new Complex(name, count);
      } else {
        throw new IllegalArgumentException("invalid values for Complex");
      }
    }
  }

  @Override
  public String toString() {
    return "Complex: name=" + name + ", count=" + count;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static boolean isValid(String name, int count) {
    return name != null && name.length() > 0
        && count > 0;
  }
}

class TryIt {
  public static void main(String[] args) {
    Complex.Builder b = Complex.builder()
        .count(22)
        .name("Albert");
    Complex c1 = b.build();
    b.name("Freddy");
    Complex c2 = b.build();
    System.out.println("c1 is " + c1);
    System.out.println("c2 is " + c2);
  }
}
