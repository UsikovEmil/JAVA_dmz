public class main04 {
    public class RedBlackTree<T extends Comparable<T>> {
    
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    
    private class Node {
        T key; 
        Node left;
        Node right;
        boolean color;
        
        public Node(T key, boolean color) {
            this.key = key;
            this.color = color;
            left = null;
            right = null;
        }
    }
    
    private Node root;
    
    public RedBlackTree() {
        root = null;
    }
    
    public boolean isEmpty() {
        return root == null;
    }
    
    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }
    
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }
    
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }
    
    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
    
    public void insert(T key) {
        root = insert(root, key);
        root.color = BLACK;
    }
    
    private Node insert(Node h, T key) {
        if (h == null) {
            return new Node(key, RED);
        }
        
        if (key.compareTo(h.key) < 0) {
            h.left = insert(h.left, key);
        } else if (key.compareTo(h.key) > 0) {
            h.right = insert(h.right, key);
        } else {
            h.key = key;
        }
        
        // Исправьте все красные ссылки.
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }
        
        return h;
    }
    
    private Node moveRedLeft(Node h) {
        flipColors(h);
        if (isRed(h.right.left)) {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
            flipColors(h);
        }
        return h;
    }
    
    private Node moveRedRight(Node h) {
        flipColors(h);
        if (isRed(h.left.left)) {
            h = rotateRight(h);
            flipColors(h);
        }
        return h;
    }
    
    private Node findMin(Node h) {
        if (h.left == null) {
            return h;
        } else {
            return findMin(h.left);
        }
    }
    
    public void deleteMin() {
        if (isEmpty()) {
            return;
        }
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }
        root = deleteMin(root);
        if (!isEmpty()) {
            root.color = BLACK;
        }
    }
    
    private Node deleteMin(Node h) {
        if (h.left == null) {
            return null;
        }
        
        if (!isRed(h.left) && !isRed(h.left.left)) {
            h = moveRedLeft(h);
        }
        h.left = deleteMin(h.left);
        return balance(h);
    }
    
    public void delete(T key) {
        if (isEmpty()) {
            return;
        }
        
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }
        
        root = delete(root, key);
        
        if (!isEmpty()) {
            root.color = BLACK;
        }
    }
    
    private Node delete(Node h, T key) {
        if (key.compareTo(h.key) < 0) {
            if (!isRed(h.left) && !isRed(h.left.left)) {
                h = moveRedLeft(h);
            }
            h.left = delete(h.left, key);
        } else {
            if (isRed(h.left)) {
                h = rotateRight(h);
            }
            if (key.compareTo(h.key) == 0 && h.right == null) {
                return null;
            }
            if (!isRed(h.right) && !isRed(h.right.left)) {
                h = moveRedRight(h);
            }
            if (key.compareTo(h.key) == 0) {
                Node x = findMin(h.right);
                h.key = x.key;
                h.right = deleteMin(h.right);
            } else {
                h.right = delete(h.right, key);
            }
        }
        return balance(h);
    }
    
    private Node balance(Node h) {
        if (isRed(h.right)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }
        return h;
    }
    
    // Распечатать дерево в порядке обхода
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }
    
    private void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.key + " ");
        inOrderTraversal(node.right);
    }
    

    public static void main(String[] args) {
        RedBlackTree<Integer> tree = new RedBlackTree<>();

        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        tree.insert(9);

        System.out.println("Обход по прядку построенноо дерева:");
        tree.inOrderTraversal();

        tree.delete(6);
        System.out.println("\nПосле удаления зачение 6 ветки:");
        tree.inOrderTraversal();
    }
}
}
