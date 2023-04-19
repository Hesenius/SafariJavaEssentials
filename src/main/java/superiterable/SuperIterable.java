package superiterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class SuperIterable<E> implements Iterable<E> {
  private Iterable<E> self;

  public SuperIterable(Iterable<E> self) {
    this.self = self;
  }

  // this is "forEach" in Iterable
//  public void forEvery(SuperIterable<E> this,
//                       Consumer<E> op) {
//    for (E e : this.self) {
//      op.accept(e);
//    }
//  }

  public SuperIterable<E> filter(
      SuperIterable<E>this, Predicate<E> crit) {
    ArrayList<E> res = new ArrayList<>();
    for (E s : this.self) {
      if (crit.test(s)) {
        res.add(s);
      }
    }
    return new SuperIterable<>(res);
  }

  // a bucket o'stuff with a map like
  // this is typically called "Functor"
  public <F> SuperIterable<F> map(Function<E, F> op) {
    ArrayList<F> res = new ArrayList<>();
    for (E e : this.self) {
      F f = op.apply(e);
      res.add(f);
    }
    return new SuperIterable<>(res);
  }

  // a "bucket o'stuff" with a flatMap of this type
  // is typically called a "Monad" (monads have rules!!!)
  public <F> SuperIterable<F> flatMap(Function<E, SuperIterable<F>> op) {
    ArrayList<F> res = new ArrayList<>();
//    for(E e : this.self) {
//      SuperIterable<F> fs = op.apply(e);
//      fs.forEach(f -> res.add(f));
//    }

    this.self.forEach(e -> op.apply(e).forEach(f -> res.add(f)));
    return new SuperIterable<>(res);
  }

  public Iterator<E> iterator() {
    return self.iterator();
  }
}
