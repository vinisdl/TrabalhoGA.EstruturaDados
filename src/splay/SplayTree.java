package splay;
import java.util.Stack;

public class SplayTree<K extends Comparable<? super K>, V> implements SplayTreeADT<K, V> {
	   private enum Rotation {
	      ZIG, ZAG, ZIG_ZIG, ZAG_ZAG, ZIG_ZAG, ZAG_ZIG
	   };

	   private Node root;

	   private class Node {
	      private K key;
	      private V value;
	      private Node left, right;
	      private int height;


	      public Node(K key, V value) {
	         this.key = key;
	         this.value = value;
	      }

	      public Node next(K other) {return other.compareTo(key) < 0 ? left : right; }

	      @Override
	      public String toString() { return "" + key; }
	   }

	   @Override
	   public void clear() {
	      root = null;
	   }

	   @Override
	   public boolean isEmpty() {
	      return root == null;
	   }
	   @Override
	   public V search(K key) {
	      if (!isEmpty()) {
	         root = splay(key);
	         if (key.compareTo(root.key) == 0)
	            return root.value;
	      }
	      return null;
	   }

	   @Override
	   public void insert(K key, V value) {
	      root = insert(root, key, value);
	      root = splay(key);
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
	   public void delete(K key) {
	      if (isEmpty())
	         return;

	      Node parent = parent(root, key);
	      if (key.compareTo(root.key) == 0) {
	         deleteByCopying(parent, root, key);
	      } else if (parent != null) {
	         deleteByCopying(parent, 
	   	parent.next(key), key);
	         root = splay(parent.key);
	      } else {
	         root = splay(key);
	      }
	   }
	   private void deleteByCopying(Node p, Node h, K key) {
		   if (h == null)
		       return;
		   else if (key.compareTo(h.key) == 0) {
		   if (h.left != null && h.right != null) {
		       Node parent = h, tmp = h.left;
		       for (; tmp.right != null; parent = tmp, tmp = tmp.right);
		       h.key = tmp.key;
		       deleteByCopying(parent, tmp, tmp.key); 
		    } else {
		       Node next = h.right == null ? h.left : h.right;
		       if (h == root)
		          root = next;
		       else if (p.left == h)
		          p.left = next;
		       else
		          p.right = next;
		    }
		  }
		}
	   private Node parent(Node h, K key) {
		   if (h == null || key.compareTo(h.key) == 0 || h.next(key) == null)
		      return null;
		   if (key.compareTo(h.next(key).key) == 0)
		      return h;
		   return parent(h.next(key), key);
		 }
	   
	   private Node splay(K key) {
	        return splay(new Stack<>(), root, key);
	   }
	   
	   private Node splay(Stack<Node> parents, Node h, K key) {
		   if (key.compareTo(h.key) == 0 || h.next(key) == null) {
		      while (!parents.isEmpty()) {
		         Node gg = null, g = null, p = parents.pop();
		        if (!parents.isEmpty()) {
		           g = parents.pop();
		           if (!parents.isEmpty())
		              gg = parents.peek();
		        }
		        switch (getRotation(g, p, h)) {
		        case ZIG:
		           h = doRightRotation(p);
		           break;
		        case ZAG:
		           h = doLeftRotation(p);
		           break;
		        case ZIG_ZIG:
		           h = doRightRotation(g);
		           h = doRightRotation(h);
		          break;
		        case ZAG_ZAG:
		          h = doLeftRotation(g);
		          h = doLeftRotation(h);
		          break;
		        case ZIG_ZAG:
		            g.right = doRightRotation(p);
		            h = doLeftRotation(g);
		            break;
		         case ZAG_ZIG:
		            g.left = doLeftRotation(p);
		            h = doRightRotation(g);
		            break;
		         }
		         if (gg != null) {
		             if (h.key.compareTo(gg.key) < 0)
		                gg.left = h;
		             else
		                gg.right = h;
		            }
		        }
		        return h;
		     } else {
		        parents.push(h);
		        return splay(parents, h.next(key), key);
		     }
		    }
	   private Rotation getRotation(Node g, Node p, Node h) {
		   Rotation first = p.left == h ? Rotation.ZIG : Rotation.ZAG;
		   Rotation second = g != null ? g.left == p ? Rotation.ZIG : Rotation.ZAG : null;

		   return second == null ? first : 
		        Rotation.valueOf(first.toString() + "_" + second.toString());
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
