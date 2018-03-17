
public class Main {
	public static void main(String[] args) {
		BinarySearchTreeAVL<Integer, Integer> avl = new BinarySearchTreeAVL<Integer, Integer>();
		BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>();

		for (int i = 0; i < 6; i++) {
			avl.insert(i, i);
			bst.insert(i, i);
		}
		
		System.out.println(bst.toString());
		
		System.out.println(avl.toString());

	}
}	
