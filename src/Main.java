
public class Main {
	public static void main(String[] args) {
		BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>();
		bst.insert(4, 4);
		bst.insert(2, 2);
		bst.insert(1, 1);
		bst.insert(3, 3);
		bst.insert(6, 6);
		bst.insert(5, 5);
		bst.insert(7, 7);
		bst.levelOrder();
	}
}	
