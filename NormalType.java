/**.
* interface for Normal type Pokemon.
* Fails checkstyle because no methods.
* @author Zifeng Liu
* @since 10/01/2020
*/
public interface NormalType {
   /** constants **/
   /** Type name String. */
   String NORMAL_TYPE = new String("Normal");
   /** Type color String. */
   String NORMAL_COLOR = new String("Brown");
   /** Array of type fast attack names. */
   String[] NORMAL_FAST_ATTACKS = {"Quick Attack", "Swift"};
   /** Array of type special attack names. */
   String[] NORMAL_SPECIAL_ATTACKS = {"Covet", "Take Down", 
      "Tackle", "Last Resort", "Double Edge"};
   /** Array of fast attack powers, coincides with name array. */
   int[] NORMAL_FAST_ATK_POWER = {40, 60};
   /** Array of special attack powers, coincides with name array. */       
   int[] NORMAL_SPECIAL_ATK_POWER = {60, 90, 40, 140, 120}; 










}