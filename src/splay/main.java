package splay;

public class main {
	public static void main(String[] args) {
		SplayTreeADT<Integer, Integer> splay = new SplayTree<>();
														
		splay.insert(9, 9);
		splay.insert(2, 2);
		splay.insert(90, 90);
		splay.insert(53, 53);
		splay.insert(4, 4);
		splay.insert(64, 64);
		splay.insert(95, 95);
		splay.insert(59, 59);
		System.out.println(splay);
	}		
}
