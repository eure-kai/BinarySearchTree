public class BST {
  
  private final class Node {
    private int data;
    private Node left;
    private Node right;
    
    public Node(Node l, Node r, int v) {
      left = l;
      right = r;
      data = v;
    }
    
    public Node getLeft() { 
      return left;
    }
    
    public Node getRight() { 
      return right;
    }
    
    public int getData() {
      return data;
    }
    
    public void setLeft(Node n) {
      left = n;
    }
    
    public void setRight(Node n) {
      right = n;
    }
    
    public void setData(int d) {
      data = d;
    }
  }
  
  
  private Node root;
  
  public BST() {}
  
  public int size() {
    return sizeHelper(root);
  }
  
  public int sizeHelper(Node n) {
    if (n == null) return 0;
    return (sizeHelper(n.getLeft()) + sizeHelper(n.getRight()) + 1);
  }
  
  public boolean isEmpty() {
    return (root == null);
  }
  
  
  public void insert(int value) {
    if (has(value)) return;
    else root = insertHelper(root, value);
  }
  
  public Node insertHelper(Node current, int value) {
    
    if (current == null) {
      current = new Node(null, null, value);
      
    } else {
      Node left = current.getLeft();
      Node right = current.getRight();
      
      if (value < current.getData()) current.setLeft(insertHelper(left, value));
      else current.setRight(insertHelper(right, value));
    }
    
    return current;
  }
  
  public boolean has(int v) {
    
    Node n = root;
    
    while (true) {
      
      if (n == null) return false;
      else if (n.getData() == v) return true;
      
      else if (v < n.getData()) n = n.getLeft();
      else n = n.getRight();
    }
  }
  
  
  public String preOrder(Node n) {
    
    if (n == null) return "";
    
    String word = "";
    
    word += n.getData();
    if (n.getLeft() != null) word += preOrder(n.getLeft());
    if (n.getRight() != null) word += preOrder(n.getRight());
    
    return word;
  }
  
  
  public String inOrder(Node n) {
    
    if (n == null) return "";
    
    String word = "";
    
    if (n.getLeft() != null) word += inOrder(n.getLeft());
    word += n.getData();
    if (n.getRight() != null) word += inOrder(n.getRight());
    
    return word;
  }
  
  
  public String postOrder(Node n) {
    
    if (n == null) return "";
    
    String word = "";
    
    if (n.getLeft() != null) word += postOrder(n.getLeft());
    if (n.getRight() != null) word += postOrder(n.getRight());
    word += n.getData();
    
    return word;
  }
  
  
  public String printPre() {
    return preOrder(root);
  }
  
  public String toString() {
    return inOrder(root);
  }
  
  public String printPost() {
    return postOrder(root);
  }
  
}
