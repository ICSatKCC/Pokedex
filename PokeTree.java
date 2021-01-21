/**
 * Generic class for a PokeTree.
 * 
 * @author Ujjwal Gautam
 * @param <Pokemon> the type held in tree.
 */
@SuppressWarnings("unchecked")
public class PokeTree<Pokemon extends java.lang.Comparable<Pokemon>> {

  /** Root node instance variable. */
   private PokeNode<Pokemon> root = null;
   /** numCaught instance variable. */
   private int numCaught = 1;
   /** Instance variable for determining Pokemon's number. */
  // private int num = 0;
   /** Instance variable for Pokemon object. */
   private Pokemon p = null;

  /** No parameter constructor. */
   public PokeTree() {
      // root already initialized
   }

  /**
   * Adds an pokemon to the tree.
   * Non-recursive wrapper method 
   * @param poke The object to be added
   * @param number The pokemon's number
   */
   public void add(Pokemon poke, int number) {
   // calls a recursive, private method
   // cannot get direct access to the root outside the class
   
      root = add(root, poke, number);
      
   }
   
  
  /**
   * Recusively adds an pokemon to the tree.
   * 
   * @param node The root of the tree/subtree
   * @param poke The object to be added
    * @param number The number of the Pokemon
   * @return The current node
   */
   public PokeNode<Pokemon> add(PokeNode<Pokemon> node, Pokemon poke, int number) {
   // base case: empty tree or end of a leaf
      if (node == null) {
         PokeNode<Pokemon> temp = new PokeNode(poke, numCaught, null, null, number);
         return new PokeNode(poke, numCaught, null, null, number);
         
      }
      // base case: duplicate node, so throw exception
      else if (node.getNum() == number) {
         node.increaseNumCaught();
         System.out.println("Total number caught: " + node.getNumCaught());
         return node;
      }
      // recursive case: if poke is less than current node
      // then move to left child node
      else if (number < node.getNum()) {
      // set the node's left child to the
      // left subtree with poke added
         node.setLeftChild(add(node.getLeftChild(), poke, number));
         return node;
      }
      // recursive case: if poke is greater than current node
      // then traverse to right child node
      else {
      // set the node's right child to the
      // right subtree with poke added
         node.setRightChild(add(node.getRightChild(), poke, number));
         return node;
      }
   
   
   }

 /**
   * called automatically by println/print method.
   * 
   * @return an inorder String of the tree
   */
   public String toString() {
      return this.inOrder(root);
   }

  /**
   * inOrder display of nodes, with newline between each node.
   * 
   * @param node The root of the tree/subtree
   * @return an inorder String of the tree
   */
   private String inOrder(PokeNode<Pokemon> node) {
      String inOrderPrint = "";
      if (node != null) {
         inOrderPrint = inOrderPrint 
            + this.inOrder(node.getLeftChild());
         inOrderPrint = inOrderPrint + (node.getPokemon()).toString() 
            + "\nCaught: " + node.getNumCaught() + "\n";    
         inOrderPrint = inOrderPrint 
            + this.inOrder(node.getRightChild());
      }
      return inOrderPrint;
   }
   
   
   
   
    /**
   * Removes an item from the tree.
   * @param poke the item to be removed
   * @param number the number of the pokemon item to be removed
   */
   public void remove(Pokemon poke, int number) {
      root = this.remove(root, poke, number);
   }

  /**
   * Recursively removes an item from the tree.   
   * @param node The root of the tree/subtree
   * @param poke the item to be removed
   * @param number the number of the pokemon item to be removed
   * @return root of current subtree.
   * @throws TreeException if item not found in tree.
   */
   private PokeNode<Pokemon> remove(PokeNode<Pokemon> node, Pokemon poke, int number) {
   // if item not found, throw exception
      if (node == null) {
         throw new PokeException("Item not found!");
      }
      // if search key is less than node's search key,
      // continue to left subtree
      else if (number < node.getNum()) {
         node.setLeftChild(this.remove(node.getLeftChild(), poke, number));
         return node;
      }
      // if search key is greater than node's search key,
      // continue to right subtree
      else if (number > node.getNum()) {
         node.setRightChild(this.remove(node.getRightChild(), poke, number));
         return node;
      }
      //if found node containing pokemon but the number caught is > 1
      //decrease number caught
      else if (node.getNumCaught() > 1) { 
         node.decreaseNumCaught();
         return node;
      }
      
      // found node containing object with same search key,
      // so delete it
      else {
      // call private method remove
         node = this.remove(node);
         return node;
      }
      //return node;
   }

  /**
   * Helper method that takes a node out of tree.
   * 
   * @param node The node to remove
   * @return The node that replaces removed node or null.
   */
   private PokeNode<Pokemon> remove(PokeNode<Pokemon> node) {
   // if node is a leaf,return null
      if (node.getLeftChild() == null && node.getRightChild() == null) {
         return null;
      }
      // if node has a single right child node,
      // then return a reference to the right child node
      else if (node.getLeftChild() == null) {
         return node.getRightChild();
      }
      // if node has a single left child node,
      // then return a reference to the left child node
      else if (node.getRightChild() == null) {
         return node.getLeftChild();
      }
      // if the node has two child nodes
      else {
      // get next Smaller Item, which is Largest Item in Left Subtree
      // The next Smaller Item is stored at the rightmost node in the left
      // subtree.
         PokeNode<Pokemon> largestItemInLeftSubtree = this.getItemWithLargestSearchKey(node
             .getLeftChild());
             //largestItemInLeftSubtree.getNumber();
             // replace the node's item with this item
         node = largestItemInLeftSubtree; //.setPokemon(largestItemInLeftSubtree);
      // delete the rightmost node in the left subtree
         node.setLeftChild(this.removeNodeWithLargestSearchKey(node
             .getLeftChild()));
         return node;
      }
   }

  /**
   * Returns the item with the largest search key in the (sub)tree.
   * Helper method for removing interior nodes.
   * @param node The root of the tree/subtree
   * @return The data item with largest key
   */
   private PokeNode<Pokemon> getItemWithLargestSearchKey(PokeNode<Pokemon> node) {
   // if no right child, then this node contains the largest item
      if (node.getRightChild() == null) {
         return node; //  .getPokemon();
      }
      // if not, keep looking on the right
      else {
         return this.getItemWithLargestSearchKey(node.getRightChild());
      }
   }

  /**
   * Removes the node with the largest search key.
   * Helper method for removing interior nodes.
   * Remove the node formerly occupied by item with largest search key.
   * To be called after item is moved to new node location.
   * 
   * @param node The root of the tree/subtree
   * @return root of (sub)tree with node removed.
   */
   private PokeNode<Pokemon> removeNodeWithLargestSearchKey(PokeNode<Pokemon> node) {
   // if no right child, then this node contains the largest item
   // so replace it with its left child
      if (node.getRightChild() == null) {
         return node.getLeftChild();
      }
      // if not, keep looking on the right
      else {
         node.setRightChild(this.removeNodeWithLargestSearchKey(node
             .getRightChild()));
         return node;
      }
   }


}