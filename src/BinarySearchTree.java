import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
 *  Número do grupo: 8
 *  Integrantes: Marco Vinicius Soares Dalalba, Marlon Gsuik, Taiyki So
 * 
 */
public class BinarySearchTree<K extends Comparable<K>,V> implements IBinarySearchTreeADT<K, V>{
    protected Node root;

    protected class Node {
        private K key;
        private V value;
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
        public String toString() { return "" + key; }
    }

    @Override
    public void clear() { root = null; }

    @Override
    public boolean isEmpty() { return root == null; }
    
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
    
    private Node searchNode(Node node, K key) {
        if (node == null) {
            return null;
        } else if (key.compareTo(node.key) == 0) {
            return node;
        }
        return searchNode(node.next(key), key);
    }
    
    @Override
    public void insert(K key, V value) {
        root = insert(root, key, value);
    }

    private Node insert(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = insert(node.right, key, value);
        } else if (key.compareTo(node.key) < 0) {
            node.left = insert(node.left, key, value);
        }

        return node;
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
    
    private boolean deleteByCopying(K key) {
        Node parent = null, current = root;
        for (; current != null && key.compareTo(current.key) != 0; parent = current, current = current.next(key));
        
        if (current == null) 
            return false;
        else if (current.left != null && current.right != null) {
            // Caso 3
            Node tmp = current.left;     
            while (tmp.right != null) tmp = tmp.right;
            deleteByCopying(tmp.key); 
            current.key = tmp.key; 
        } else {
            // Caso 1 ou Caso 2
            Node nextNode = current.right == null ? current.left : current.right;
            if (current.equals(root)) root = nextNode;
            else if (parent.left.equals(current)) parent.left = nextNode;
            else parent.right = nextNode;
        }

        return true;
    }
    
    @Override
    public boolean delete(K key) {
       return deleteByCopying(key);
    }

    @Override
    public void preOrder() {
       preOrder(root);
    }

    private void preOrder(Node node) {
       if (node != null) {
           System.out.print(node + " ");
           preOrder(node.left);
           preOrder(node.right);
       }
    }
    
    @Override
    public void postOrder() {
       postOrder(root);
    }

    private void postOrder(Node node) {
       if (node != null) {
         postOrder(node.left);
         postOrder(node.right);
         System.out.print(node + " ");
       }
    }

    @Override
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
       if (node != null) {
          inOrder(node.left);
          System.out.print(node + " ");
          inOrder(node.right);
       }
    }


    //Implementações do trabalho
    
    @Override
    public void levelOrder() {
       levelOrder(root);
    }
       
    private void levelOrder(Node node) {
	  if (node != null) {
          Queue<Node> queue = new ArrayDeque<>();
          queue.add(node);
          while (!queue.isEmpty()) {
              Node current = queue.remove();
              System.out.print(current + " ");

              if (current.left != null) queue.add(current.left);
              if (current.right != null) queue.add(current.right);
          }
      }    	
    }
    
	@Override
	public int countNodes() {
		return countNodes(root);
	}

	private int countNodes(Node node) {
		//prevent
		if( node == null )
			return 0;
		//é uma folha
		if( node.left == null && node.right == null ) {
			return 1;
		} else {
			return 1 + countNodes(node.left) + countNodes(node.right);
		}
	}
	
	@Override
	public int countInternalNodes() {
		return countInternalNodes(root);
	}
	
	private int countInternalNodes(Node node) {
		//prevent
		if( node == null )
			return 0;
		//é uma folha
		if( node.left == null && node.right == null ) {
			return 0;
		} else {
			return 1 + countInternalNodes(node.left) + countInternalNodes(node.right);
		}
	}
	
	@Override
	public int countLeaves() {		
		return countLeaves(root);
	}

	private int countLeaves(Node node) {
		//prevent
		if( node == null )
			return 0;
		//é uma folha
		if( node.left == null && node.right == null ) {
			return 1;
		} else {
			return countLeaves(node.left) + countLeaves(node.right);
		}
	}
	
	// Faltam
	@Override
	public int degree(K key) {		
		Node result = degree(root, key);
		if(result == null)
			return -1;		
		int degree = 0;
		if(result.left != null)
			degree++;
		if(result.right != null)
			degree++;
		return degree;
	}

	private Node degree(Node node, K key) {		
		if (node == null) {
            return null;
        } else if (key.compareTo(node.key) == 0) {
            return node;
        }
	  
	  	Node left = degree(node.left, key);
	  	Node rigth = degree(node.right, key);
	  
        return left == null ? rigth : left;
	}
	
	@Override
	public int degreeTree() {
		List<Integer> all = new LinkedList<>();
		
		degreeTree(root, all);
		
		return Collections.max(all);
	}
	
	
	private Node degreeTree(Node node, List<Integer> lst) {		
		if (node == null) {
            return null;
        }	  
		
		int degree = 0;
		if(node.left != null)
			degree++;
		if(node.right != null)
			degree++;
		if(degree == 0)
			degree = -1;
		lst.add(degree);
		
	  	Node left = degreeTree(node.left, lst);
	  	Node rigth = degreeTree(node.right, lst);
	  
        return left == null ? rigth : left;
	}
	
	@Override
	public int height(K key) {
		Node node = searchNode(root,key);
		return heigthTree(node);
	}

	@Override
	public int heightTree() {
		return heigthTree(root);
	}

	private int heigthTree(Node node) {
		if(node == null)
			return 	0;
		else 
		  return 1 + Math.max(heigthTree(node.left),
				  heigthTree(node.right));
	}
	
	@Override
	public int depth(K key) {
		Node node = searchNode(root, key);
		return depth(node);
	}

	private int depth(Node node) {
		if ( node == null )
	        return 0;
	    return 1 + depth(node.left) + depth(node.right);
	}
	
	@Override
	public String descendents(K key) {
		List<K> result = new ArrayList<K>();		
		descendents(root, key, result);	    
		String s = "";
		for (K k : result) {
			s+= k.toString() + " ";
		}
		
		return null;
	}

	private boolean descendents(Node node, K target, List<K> result) {
	    if (node == null) {
	        return false;
	    }
	    if (node.value == target) {
	        return true;
	    }
	    if (descendents(node.left, target, result) || descendents(node.right, target, result)) {
	        result.add(node.key);
	        return true;
	    }

	    return false;
	}
	
	@Override
	public String ancestors(K key) {
		List<Node> nodes = new LinkedList<>();
		antecestors(root, key, nodes);
		String s = "";
		for (Node node : nodes) {
			s += node.key.toString() + " ";
		}
		return s;
	}

	private Node antecestors(Node node, K key, List<Node> nodes) {
        if (node == null) {
            return null;
        } else if (key.compareTo(node.key) == 0) {
            return node;
        }
        
        Node result = antecestors(node.next(key), key, nodes);
        if(result != null)
        	nodes.add(node);
        
        return result;
    }
}
