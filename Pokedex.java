import java.util.Scanner;
/**
 * Add and remove Pokemon using BST.
 * @since: 12/02/2020
 * @author Ujjwal Gautam
 */
@SuppressWarnings("unchecked")
public class Pokedex {
 /**
    * Driver code to test class.
    * 
    * @param args not used
    *            
    */
   public static void main(String[] args) {
   //declaration and instatiation of PokeTRee object
      PokeTree<Pokemon> tree = new PokeTree();
      Scanner userIn = new Scanner(System.in);
      boolean loop = true;
   //Setting object poke as null
      Pokemon poke = null;
   //pokemon number
      int num;
   
   //while loop is true, user doesn't qui the program
      while (loop) {
         System.out.println("Please choose the following options: (1, 2, 3, 0)");
         System.out.println("1 to catch pokemon");
         System.out.println("2 to trade pokemon");
         System.out.println("3 to print pokedex");
         System.out.println("0 to quit");
         int input = userIn.nextInt();
      //switch statement based on user input
         switch(input) {
         //if user enters 0, end the program
            case 0:
               System.out.println("User entered 0");
               loop = false;
               break;
         
         //add Pokemon if user enters 1
            case 1:
               poke = Pokedex.makePokemon();
               System.out.println("Added " + poke.getSpecies() + " to the list");
               num = poke.getNumber();
               tree.add(poke, num); 
               break;
         
         //remove Pokemon if user enters 2
            case 2:
               poke = Pokedex.removePokemon();
               System.out.println("Removed " + poke.getSpecies() + " from the list");
               num = poke.getNumber();
               tree.remove(poke, num); 
               break;
         
         //display pokemon to the screen
            case 3:
            //inOrder display of the Pokemon
               System.out.println(tree.toString());
               break;
         
            default:
               System.out.println("Default line 38");
         
         } //closes switch
      
      
      
      } //closes while
   
   
   
   } //closes main
      
      /** makePokemon method.
   *  Takes and returns user input
   * @return Pokemon object
     */
   public static Pokemon makePokemon() {
      String species = "";
      String ask = "";
      String name = "";
      String type1 = "";
      String type2 = "";
      int num = 0;    
      Pokemon p = null;  
      //Asking for user inputs
      Scanner userIn = new Scanner(System.in);   
      boolean test = false;
      //Keep looping until the user enters a number
      while (!test) {      
         System.out.println("Choose a pokemon to add:");
         System.out.println("1 for Bulbasaur");
         System.out.println("2 for Ivysaur");
         System.out.println("3 for Venusaur");
         System.out.println("4 for Charmander");
         System.out.println("5 for Charmeleon");
         System.out.println("6 for Charizard");
         System.out.println("7 for Squirtle");
         System.out.println("8 for Wartotle");
         System.out.println("9 for Blastoise");
            //userInput
         String n = userIn.nextLine();
         num = Integer.parseInt(n);
         test = true;
         switch(num) {
            case 1:
               p = new Bulbasaur();
               break;
               
            case 2:
               p = new Ivysaur();
               break;
               
            case 3:
               p = new Venusaur();
               break;
               
            case 4:
               p = new Charmander();
               break;
               
            case 5:
               p = new Charmeleon();
               break;
               
            case 6:
               p = new Charizard();
               break;
               
            case 7:
               p = new Squirtle();
               break;
               
            case 8:
               p = new Wartortle();
               break;
               
            case 9:
               p = new Blastoise();
               break;        
               
               
            default: //not a valid menu entry
               System.out.println("\n****Invalid menu choice.****");
               System.out.println("Please enter a number from 1-9 \n"); 
               test = false;                    
               break;               
                        
            
         }
      }
       
   
      return p;   //returns pokemon to main method
   
   }  //closes makepokemon method
   
   /** removePokemon method.
   *  Takes and returns user input
   * @return Pokemon object
    
     */
   public static Pokemon removePokemon() {
      String species = "";
      String ask = "";
      String name = "";
      String type1 = "";
      String type2 = "";
      int num = 0;    
      Pokemon p = null;  
           //Asking for user inputs
      Scanner userIn = new Scanner(System.in);   
      boolean test = false;
      //Keep looping until the user enters a number
      while (!test) {      
         System.out.println("Choose a pokemon to remove:");
         System.out.println("1 for Bulbasaur");
         System.out.println("2 for Ivysaur");
         System.out.println("3 for Venusaur");
         System.out.println("4 for Charmander");
         System.out.println("5 for Charmeleon");
         System.out.println("6 for Charizard");
         System.out.println("7 for Squirtle");
         System.out.println("8 for Wartotle");
         System.out.println("9 for Blastoise");
            //userInput
         String n = userIn.nextLine();
         num = Integer.parseInt(n);
         test = true;
         switch(num) {
            case 1:
               p = new Bulbasaur();
               break;
               
            case 2:
               p = new Ivysaur();
               break;
               
            case 3:
               p = new Venusaur();
               break;
               
            case 4:
               p = new Charmander();
               break;
               
            case 5:
               p = new Charmeleon();
               break;
               
            case 6:
               p = new Charizard();
               break;
               
            case 7:
               p = new Squirtle();
               break;
               
            case 8:
               p = new Wartortle();
               break;
               
            case 9:
               p = new Blastoise();
               break;        
               
               
            default: //not a valid menu entry
               System.out.println("\n****Invalid menu choice.****");
               System.out.println("Please enter a number from 1-9 \n"); 
               test = false;                    
               break;               
                        
            
         }
      }
       
   
      return p;   //returns pokemon to main method
   
   }         

} //closes class
