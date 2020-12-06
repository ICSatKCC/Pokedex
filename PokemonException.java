/**
 * An Eception for use with the Pokemon class.
 * @author Ujjwal Gautam
 */


public class PokemonException extends RuntimeException {
/**
 * Constructor.
 *
 * @param message Describes the cause of the error
 */
 
   public PokemonException(String message) {
   //calls super constructor
      super(message);
   }

}