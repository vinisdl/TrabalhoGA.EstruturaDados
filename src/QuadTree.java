
public class QuadTree<K extends Comparable<K>, V> implements QuadTreeADT<K, V> {
   private Node root;

   // Classe Node (slide seguinte)
   private class Node {
       private K x, y;              
       private Node NW, NE, SE, SW;   
       private V value;           

       public Node(K x, K y, V value) {
           this.x = x;
           this.y = y;
           this.value = value;
       }
   }

   @Override
   public void clear() {
      root = null;
   }

   @Override
   public boolean isEmpty() {
      return root == null;
   }
   public void insert(K x, K y, V value) {
	   root = insert(root, x, y, value);
	}

	private Node insert(Node node, K x, K y, V value) {
	   if (node == null)
	      return new Node(x, y, value);
	   else if (less(x, node.x) && !less(y, node.y))
	      node.NW = insert(node.NW, x, y, value);
	   else if (less(x, node.x) && less(y, node.y))
	      node.SW = insert(node.SW, x, y, value);
	   else if (!less(x, node.x) && !less(y, node.y))
	      node.NE = insert(node.NE, x, y, value);
	   else if (!less(x, node.x) && less(y, node.y))
	      node.SE = insert(node.SE, x, y, value);
	   
	   return node;
	}
	
	private boolean less(K k1, K k2) {
		   return k1.compareTo(k2) < 0;
	}
	
	public void query2D(Interval2D<K> rect) {
		  query2D(root, rect);
		}

	private void query2D(Node node, Interval2D<K> rect) {
	  if (node == null)
	     return;
	  K xMin = rect.intervalX.min();
	  K yMin = rect.intervalY.min();
	  K xMax = rect.intervalX.max();
	  K yMax = rect.intervalY.max();
	  if (rect.contains(node.x, node.y))
	      System.out.println("    (" + node.x + ", " + node.y + ") " + node.value);
	  if ( less(xMin, node.x) && !less(yMax, node.y)) query2D(node.NW, rect);  
	  if ( less(xMin, node.x) &&  less(yMin, node.y)) query2D(node.SW, rect);
	  if (!less(xMax, node.x) && !less(yMax, node.y)) query2D(node.NE, rect);  
	  if (!less(xMax, node.x) &&  less(yMin, node.y)) query2D(node.SE, rect);
	}

	@Override
	public V search(K x, K y) {			
		Node result = search(root,x,y);		
		if(result != null)
			return result.value;
		return null;
	}
	
	private Node search(Node node, K x, K y) {
		if(node == null)
			return null;
		if(node.x.equals(x) && node.y.equals(y))
			return node;
		if ( less(x, node.x) && !less(y, node.y)) return search(node.NW, x,y);  
		if ( less(x, node.x) &&  less(y, node.y)) return search(node.SW, x,y);
		if (!less(x, node.x) && !less(y, node.y)) return search(node.NE, x,y);  
		if (!less(x, node.x) &&  less(y, node.y)) return search(node.SE, x,y);

		return null;			
	}
	

	@Override
	public V search(Interval<K> interval) {
		return search(interval.min(), interval.max());
	}

	@Override
	public Interval<K> mim() {
		Node result = min(root);
		if(result == null)
			return null;
		return new Interval<K>(result.x, result.y);
	}
	
	
	private Node min(Node node) {
		if(node == null)
			return null;
		
		if ( less(root.x, node.x) && !less(root.y, node.y) && node.NE != null) return min(node.NW);  
		if ( less(root.x, node.x) &&  less(root.y, node.y) && node.SW != null) return min(node.SW);
		if (!less(root.x, node.x) && !less(root.y, node.y) && node.NE != null) return min(node.NE);  
		if (!less(root.x, node.x) &&  less(root.y, node.y) && node.SE != null) return min(node.SE);
		
		
		if(node.NW == null && node.SW == null && node.NE == null)
			return node.SE;
		if(node.SE == null && node.SW == null && node.NE == null)
			return node.NW;
		if(node.SE == null && node.SW == null && node.NE == null)
			return node.SW;
		if(node.NW == null && node.SW == null && node.SE == null)
			return node.NE;
		
		
		return null;
		
	}
	

}
