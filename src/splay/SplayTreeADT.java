package splay;

public interface SplayTreeADT<K, V> {
	   public void clear();
	   public boolean isEmpty();
	   public V search(K key);
	   public void insert(K key, V value);
	   public void delete(K key);
	}
