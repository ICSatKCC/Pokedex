
/**
 * PokeNode class for PokeTree.
 * @since 12/03/2020
 * @author Ujjwal Gautam
 * @param <Pokemon> The pokeObjtype held in Nodes.
 */
public class PokeNode<Pokemon> {
	// pokeObj fields
  /** Species held in Node. */
   private Pokemon pokeObj;
   /** Link to left child Node. */
   private PokeNode<Pokemon> left;
   /** Link to right child Node. */
   private PokeNode<Pokemon> right;
    /** Number of times the pokemon is caught. */
   private int numCaught = 1;
    /** Number of pokemon species. */
   private int num;

	/**
	 * Constructor.
	 * 
	 * @param d The address of the object that is stored by the node
     * @param numCaught The number of times the pokemon is caught
	 * @param l The address of the left child
	 * @param r The address of the right child
    * @param num The number of Pokemon species
	 */
   public PokeNode(Pokemon d, int numCaught, PokeNode<Pokemon> l,
   		PokeNode<Pokemon> r, int num) {
      pokeObj = d;
      left = l;
      right = r;
      this.numCaught = numCaught;
      this.num = num;
    
      
   }

	/**
	 * Automatically called by println() or print() method.
	 * 
	 * @return the item's string
	 */
   public String toString() {
      String display = pokeObj.toString();
      return display;
   }

	/**
	 * Accessor method.
	 * 
	 * @return the item's address
	 */
   public Pokemon getPokemon() {
      return pokeObj;
   }
   
   /**
	 * Accessor method.
	 * 
	 * @return the total number of times caught
	 */
   public int getNumCaught() {
      return numCaught;
   
   }

/**
	 * Accessor method.
	 * 
	 * @return the Pokemon's number
	 */
   public int getNum() {
      return this.num;
   
   }

/**
  * Increases the number of time same pokemon is caught.
  */
   public void increaseNumCaught() {
      numCaught++;
   
   }

/**
  * Decreases the number of time same pokemon is caught.
  */
   public void decreaseNumCaught() {
      numCaught--;
   
   }


	/**
	 * Mutator method.
	 * @param d sets the pokemon to Pokeobj, redundant method "not being used"
	 *            
	 */
   private void setPokemon(Pokemon d) {
      pokeObj = d;
   }

	/**
	 * Accessor method.
	 * 
	 * @return the left child's address
	 */
   public PokeNode<Pokemon> getLeftChild() {
      return left;
   }

	/**
	 * Mutator method.
	 * 
	 * @param l sets the left child
	 */
   public void setLeftChild(PokeNode<Pokemon> l) {
      left = l;
   }
 
	/**
	 * Accessor method.
	 * 
	 * @return the right child's address
	 */
   public PokeNode<Pokemon> getRightChild() {
      return right;
   }

	/**
	 * Mutator method.
	 * 
	 * @param r sets the right child's address
	 *            
	 */
   public void setRightChild(PokeNode<Pokemon> r) {
      right = r;
   }
   
}

