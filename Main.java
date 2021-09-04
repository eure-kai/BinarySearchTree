class Main {
  public static void main(String[] args) {
    	
    BST tree = new BST();
    System.out.println("Size: " + tree.size());
    System.out.println("isEmpty: " + tree.isEmpty() + "\n");
    
    for (int i = 1; i <= 7; i++) {
      int num = (int) (Math.random() * 10);
      tree.insert(num);
      System.out.println("Insert " + num + ": " + tree);
    }
    
    System.out.println("\nSize: " + tree.size());
    System.out.println("isEmpty: " + tree.isEmpty());
    
    
    System.out.println("Preorder: " + tree.printPre());
    System.out.println("Inorder: " + tree);
    System.out.println("Postorder: " + tree.printPost());
    
    
    System.out.println("\nTree has 3? " + tree.has(3));
    System.out.println("Tree has 20? " + tree.has(10));
    

    System.out.print("\nDelete 5: ");
    tree.remove(5);
    System.out.println(tree);
    
    System.out.print("Delete 9: ");
    tree.remove(9);
    System.out.println(tree);
    
    
    System.out.print("\nClear the tree: ");
    tree.clear();
    System.out.println(tree);
    
    System.out.println("isEmpty: " + tree.isEmpty() + "\n");
    
  }
}

