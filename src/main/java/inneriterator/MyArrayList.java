package inneriterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

interface MyList<E> extends Iterable<E> {
  void add(E element);
  E get(int idx);
}

public class MyArrayList<E> implements MyList<E> {
  private E[] data = (E[])new Object[10];
  private int count = 0;

  @Override
  public void add(E element) {
    data[count++] = element; // overflow not checked!
  }

  @Override
  public E get(int idx) {
    return data[idx]; // validity not checked
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("MyArrayList [");
    for (int idx = 0; idx < count; idx++) {
      sb.append(data[idx] + ", ");
    }
    sb.setLength(sb.length() - 2);
    sb.append("]");
    return sb.toString();
  }

  public Iterator<E> iterator() {
//    return this.new MyIterator<>();
    return new MyIterator();
  }

  public static void wontWork() {
    new MyArrayList().new MyIterator();
  }

  // remove static.
  private class MyIterator implements Iterator<E> {
    private int progess = 0;

    // IMPLICIT enclosing type reference, and this is now default constructor
    // but can declare the "receiver parameter" if you wish
//    MyIterator(MyArrayList<E> MyArrayList.this) {
    MyIterator() {
    }

    @Override
    public boolean hasNext() {
//      return progess < MyArrayList.this.count;
      return progess < count;
    }

    @Override
    public E next() {
      if (progess >= count) {
        throw new NoSuchElementException("next when not hasNext");
      }
      return data[progess++];
    }
  }
}

class TryTheList {
  public static void main(String[] args) {
    MyList<String> mls = new MyArrayList<>();
    mls.add("Alex");
    mls.add("Bob");
    mls.add("Charlie");
    System.out.println(mls.get(0));
    System.out.println(mls);

    for (String s : mls) {
      System.out.println("> " + s);
    }
    System.out.println("all done iterating");
  }
}
