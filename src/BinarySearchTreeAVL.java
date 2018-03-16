public class BinarySearchTreeAVL<K extends Comparable<K>, V>  implements IBinarySearchTreeADT<K, V> {

	protected Node root;
	protected class Node {
	    private K key;
	    private V value;
	    private int height;
	    private Node left, right;

	    public Node(K key, V value) {
	        this.key = key;
	        this.value = value;
	    }

	    public Node next(K other) {
	        return other.compareTo(key) < 0 ? left : right;
	    }

	    public boolean isLeaf() {
	        return left == null && right == null;
	    }

	    @Override
	    public String toString() {
	        return root == null ? "[empty]" : printTree(new StringBuffer());
	    }
	    
	    private String printTree(StringBuffer sb) {
	        if (root.right != null) {
	            printTree(root.right, true, sb, "");
	        }
	        sb.append(root + "\n"); 
	        if (root.left != null) {
	            printTree(root.left, false, sb, "");
	        }
	            
	        return sb.toString();
	    }
	    private void printTree(Node node, boolean isRight, StringBuffer sb, String indent) {
	        if (node.right != null) {
	            printTree(node.right, true, sb, indent + (isRight ? "        " : " |      "));
	        }
	        sb.append(indent + (isRight ? " /" : " \\") + "----- " + node + "\n"); 
	        if (node.left != null) {
	            printTree(node.left, false, sb, indent + (isRight ? " |      " : "        "));
	        }
	    }
	}

	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public V search(K key) {
	   return search(root, key);
	}
	
	private V search(Node node, K key) {
	   if (node == null) {
	       return null;
	   } else if (key.compareTo(node.key) == 0) {
	       return node.value;
	   }
	   return search(node.next(key), key);
	}

	@Override
	public void insert(K key, V value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean delete(K key) {
	    if (search(key) != null) {
	        root = deleteByCopying(root, key);
	        return true;
	    }
	    return false;
	}
	private Node deleteByCopying(Node node) {
	    if (node.right == null) {
	        return node.left;
	    }
	    node.right = deleteByCopying(node.right);
	    node.height = 1 + Math.max(height(node.left), height(node.right));
	    return balance(node);
	}

	public Node deleteByCopying(Node node, K key) {
	    if (key.compareTo(node.key) < 0) {
	        node.left = deleteByCopying(node.left, key);
	     } else if (key.compareTo(node.key) > 0) {
	        node.right = deleteByCopying(node.right, key);
	     } else {
	        if (node.left == null) {
	            return node.right;
	        } else if (node.right == null) {
	            return node.left;
	        } else {
	            Node temp = node;
	            node = node.left;
	            while (node.right != null)
	                node = node.right;

	            node.left = deleteByCopying(temp.left);
	            node.right = temp.right;
	        }
	     }
	     node.height = 1 + Math.max(height(node.left), height(node.right));
	     return balance(node);
	}
	
	@Override
	public void preOrder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inOrder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postOrder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void levelOrder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int countNodes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countInternalNodes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countLeaves() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int degree(K key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int degreeTree() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int height(K key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int heightTree() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int depth(K key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String ancestors(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String descendents(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	private Node doRightRotation(Node k2) {
	    Node k1 = k2.left;
	    k2.left = k1.right;
	    k1.right = k2;
	    k2.height = 1 + Math.max(height(k2.left), height(k2.right));
	    k1.height = 1 + Math.max(height(k1.left), height(k1.right));
	    return k1;
	}

	private Node doLeftRotation(Node k1) {
	    Node k2 = k1.right;
	    k1.right = k2.left;
	    k2.left = k1;
	    k1.height = 1 + Math.max(height(k1.left), height(k1.right));
	    k2.height = 1 + Math.max(height(k2.left), height(k2.right));
	    return k2;
	}
	
	private int height(Node node) {
	    return node != null ? node.height : -1;
	}

	private int balanceFactor(Node node) {
	    return height(node.left) - height(node.right);
	}
	
	private Node balance(Node node) {
	    if (balanceFactor(node) < -1) {
	        if (balanceFactor(node.right) > 0) {
	            node.right = doRightRotation(node.right);
	        }
	        node = doLeftRotation(node);
	    } else if (balanceFactor(node) > 1) {
	        if (balanceFactor(node.left) < 0) {
	            node.left = doLeftRotation(node.left);
	        }
	        node = doRightRotation(node);
	    }
	    return node;
	}


}
