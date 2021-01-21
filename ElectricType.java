/**.
* interface for Normal type Pokemon.
* Fails checkstyle because no methods.
*@ Author Zifeng Liu
*  Since 10/01/2020
*/
public interface ElectricType {
   /** constants **/
   /** Type name String. */
   String ELECTRIC_TYPE = new String("Electric");
   /** Type color String. */
   String ELECTRIC_COLOR = new String("Yellow");
   /** Array of type fast attack names. */
   String[] ELECTRIC_FAST_ATTACKS = {"Thunder Shock", "Thunder Fang"};
   /** Array of type special attack names. */
   String[] ELECTRIC_SPECIAL_ATTACKS = {"Discharge", "Thunder", 
      "Volt Switch", "Thunderbolt", "Wild Charge", "Rising Voltage"};
   /** Array of fast attack powers, coincides with name array. */
   int[] ELECTRIC_FAST_ATK_POWER = {40, 65}; 
   /** Array of special attack powers, coincides with name array. */     
   int[] ELECTRIC_SPECIAL_ATK_POWER = {80, 110, 70, 90, 90, 70};
}