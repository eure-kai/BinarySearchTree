public class BST {
  
  private final class Node {
    private int data;
    private Node left;
    private Node right;
    
    //constructor with one parameter
    public Node(int v) {
      data = v;
    }
    
    //get left child
    public Node getLeft() {
      return left;
    }
    
    //get right child
    public Node getRight() { 
      return right;
    }
    
    //get data
    public int getData() {
      return data;
    }
    
    //set left child to a node
    public void setLeft(Node n) {
      left = n;
    }
    
    //set right child to a node
    public void setRight(Node n) {
      right = n;
    }
    
    //set data to an integer
    public void setData(int d) {
      data = d;
    }
  }
  
  
  private Node root; //root (instance variable)
  
  //returns how many nodes
  public int size() {
    return sizeHelper(root);
  }
  
  //recursion to calculate size
  private int sizeHelper(Node n) {
    if (n == null) return 0;
    return (sizeHelper(n.getLeft()) + sizeHelper(n.getRight()) + 1);
  }
  
  //returns whether tree is empty
  public boolean isEmpty() {
    return (root == null);
  }
  
  
  //method to check whether the tree has a node with a specific value
  public boolean has(int v) {
    
    Node n = root;
    
    while (true) {
      
      if (n == null) return false; //if the node is null, obviously false
      else if (n.getData() == v) return true; //if node's data equals v, obviously true
      
      else if (v < n.getData()) n = n.getLeft(); //use left since it is less
      else n = n.getRight(); //use right since it is greater
    }
  }
  
  
  //inserts a new node with a specific value
  public void insert(int value) {
    if (has(value)) return;
    else root = insertHelper(root, value);
  }
  
  //uses recursion to find the spot where the new node will be placed
  private Node insertHelper(Node current, int value) {
    
    if (current == null) {
      current = new Node(value);
      return current;
    }
    
    Node left = current.getLeft(); //values less than current
    Node right = current.getRight(); //values greater than current
    
    if (value < current.getData()) current.setLeft(insertHelper(left, value)); // < equals left
    else current.setRight(insertHelper(right, value)); // > equals right
    
    return current;
  }
  
  
  //removes a node with a specific value
  public void remove(int value) {
    if (has(value) == false) return;
    else root = removeHelper(root, value);
  }
  
  //uses recursion to find the spot to remove the node, and also replaces with an adequate replacement
  private Node removeHelper(Node current, int value) {
    
    if (current == null) return current;
    
    Node left = current.getLeft();
    Node right = current.getRight();
    
    //finding the node to remove by using left = less than and right = greater than
    if (value < current.getData()) current.setLeft(removeHelper(left, value));
    else if (value > current.getData()) current.setRight(removeHelper(right, value));
    
    
    //if value = current.getData() then current is the node to remove
    else {

      //if left child == null, replace it with right child (which could either also be null or the only child). if right child == null, replace it with left child (by vice versa).
      if (left == null) return right;
      else if (right == null) return left;
      
      //if both childs != null, then replace its data with the data of the predecessor
      current.setData(predecessor(left).getData());
      
      //use recursion to delete the predecessor (spot = left subtree of current, data = current's data)
      current.setLeft(removeHelper(left, current.getData()));
    }
    
    return current; //return current
  }
  
  //calculates the LARGEST (most right) node from the LEFT subtree
  public Node predecessor(Node n) {
    
    //replace n with n.getRight() to get the largest node
    while (n.getRight() != null) {
      n = n.getRight();
    }
    
    return n;
  }
  
  
  //clear the tree
  public void clear() {
    clearHelper(root);
  }
  
  //recursion to clear left side, right side, then remove root
  private void clearHelper(Node n) {
    if (n == null) return;
    
    clearHelper(n.getLeft());
    clearHelper(n.getRight());
    remove(n.getData());
  }
  
  
  //preOrder (node, left, right)
  private String preOrder(Node n) {
    
    if (n == null) return "";
    
    String word = "";
  
    word += n.getData();
    if (n.getLeft() != null) word += preOrder(n.getLeft());
    if (n.getRight() != null) word += preOrder(n.getRight());
    
    return word;
  }
  
  
  //inOrder (left, node, right)
  private String inOrder(Node n) {
    
    if (n == null) return "";
    
    String word = "";
    
    if (n.getLeft() != null) word += inOrder(n.getLeft());
    word += n.getData();
    if (n.getRight() != null) word += inOrder(n.getRight());
    
    return word;
  }
  
  
  //postOrder (left, right, node)
  private String postOrder(Node n) {
    
    if (n == null) return "";
    
    String word = "";
    
    if (n.getLeft() != null) word += postOrder(n.getLeft());
    if (n.getRight() != null) word += postOrder(n.getRight());
    word += n.getData();
    
    return word;
  }
  
  //print preOrder
  public String printPre() {
    return preOrder(root);
  }
  
  //print inOrder (which overrides toString())
  @Override
  public String toString() {
    return inOrder(root);
  }
  
  //print postOrder
  public String printPost() {
    return postOrder(root);
  }
}
