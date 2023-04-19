package nestediterator;

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
    return new MyIterator<>(this);
  }

  private static class MyIterator<E> implements Iterator<E> {
    private int progess = 0;
    private MyArrayList<E> target;

    public MyIterator(MyArrayList<E> target) {
      this.target = target;
    }

    @Override
    public boolean hasNext() {
      return progess < target.count;
    }

    @Override
    public E next() {
      if (progess >= target.count) {
        throw new NoSuchElementException("next when not hasNext");
      }
      return target.data[progess++];
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

//    Iterator<String> iter = mls.iterator();
//    while (iter.hasNext()) {
//      String s = iter.next();
//      System.out.println("> " + s);
//    }
    for (String s : mls) {
      System.out.println("> " + s);
    }
    System.out.println("all done iterating");
  }
}
