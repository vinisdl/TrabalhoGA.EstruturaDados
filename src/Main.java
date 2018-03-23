

public class Main {
	public static void main(String[] args) {
		BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>();
		
		int[] values = new int[10];

		for (int i = 0; i < values.length-1; i++) {
			values[i] = (int)((Math.random()*values.length)+1);			
		}
		inserItems(bst,values);	
		
		System.out.println(bst.toString());
		System.out.println(bst.countInternalNodes());
		
	}
	
	
	public void Trabalho1() {
		BinarySearchTreeAVL<Integer, Integer> avl = new BinarySearchTreeAVL<Integer, Integer>();
		BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>();
			
		
		int[] values = new int[10000000];
		//Random rand = new Random();
		for (int i = 0; i < values.length-1; i++) {
			values[i] = (int)((Math.random()*1000)+1);
			//System.out.println(values[i]+"    ");
		}

		long insertAvl = System.currentTimeMillis();
		inserItems(avl,values);	
		insertAvl = System.currentTimeMillis() - insertAvl;
		long insertBst = System.currentTimeMillis();		
		inserItems(bst,values);		
		insertBst = System.currentTimeMillis() - insertBst;
		System.out.println(insertBst +"\t"+ "bst");
		System.out.println(insertAvl +"\t"+ "avl");
		
		//Procura um elemento até a folha
		long untilLeafBst = System.nanoTime();
		bst.search(-1);
		untilLeafBst = System.nanoTime() - untilLeafBst;
		System.out.println(untilLeafBst +"\t"+ "bst até a folha");
		
		long untilLeafAvl = System.nanoTime();
		avl.search(-1);
		untilLeafAvl = System.nanoTime() - untilLeafAvl;
		System.out.println(untilLeafAvl +"\t"+ "avl até a folha");
		
		//Procura um elemento no meio do array
		int valor = values.length / 2;
		long middleBst = System.nanoTime();
		bst.search(values[valor]);
		middleBst = System.nanoTime() - middleBst;
		System.out.println(middleBst +"\t"+ "bst meio do array");
		
		long middleAvl = System.nanoTime();
		avl.search(values[valor]);
		middleAvl = System.nanoTime() - middleAvl;
		System.out.println(middleAvl +"\t"+ "avl meio do array");
		
		//Procura um elemento aleatorio no array
		int valor2 = ((int)(Math.random()*values.length-1)+1);
		long randomBst = System.nanoTime();
		bst.search(values[valor2]);
		randomBst = System.nanoTime() - randomBst;
		System.out.println(randomBst +"\t"+ "bst elemento aleatorio");
		
		long randomAvl = System.nanoTime();
		avl.search(values[valor2]);
		randomAvl = System.nanoTime() - randomAvl;
		System.out.println(randomAvl +"\t"+ "avl elemento aleatorio");			
	}
	
	
	private static void inserItems(IBinarySearchTreeADT<Integer, Integer>  tree, int[] values) {
		for (int i = 0; i < values.length; i++) {
			tree.insert(values[i], values[i]);
		}
	}
	
}	
