
public class BinarySearchTreeADT<K,V> implements IBinarySearchTreeADT<K, V>{
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


}
