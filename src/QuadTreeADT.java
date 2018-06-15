public interface QuadTreeADT<K extends Comparable<K>, V> {
   public void clear();
   public boolean isEmpty();
   public void insert(K x, K y, V value);
   public void query2D(Interval2D<K> rect);
   public V search(K x, K y);
   public V search(Interval<K> interval);
   public Interval<K> mim();
}
