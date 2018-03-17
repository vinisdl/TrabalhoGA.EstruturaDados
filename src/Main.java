import java.util.Random;

public class Main {
	public static void main(String[] args) {
		BinarySearchTreeAVL<Integer, Integer> avl = new BinarySearchTreeAVL<Integer, Integer>();
		BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>();
			
		System.out.println(bst.toString());
		
		System.out.println(avl.toString());
		
		int[] values = new int[5000];
		Random rand = new Random();
		for (int i = 0; i < 5000; i++) {
			values[i] =  rand.nextInt((0 - 5000) + 1) + 1;
		}
		
		long insertAvl = System.currentTimeMillis();		
		inserItems(avl,values);		
		insertAvl = System.currentTimeMillis() - insertAvl;
		
		long insertBst = System.currentTimeMillis();		
		inserItems(bst,values);		
		insertBst = System.currentTimeMillis() - insertBst;
		
		
	}
	
	
	private static void inserItems(IBinarySearchTreeADT<Integer, Integer>  tree, int[] values) {
		for (int i = 0; i < values.length; i++) {
			tree.insert(values[i], values[i]);
		}
	}
	
}	
