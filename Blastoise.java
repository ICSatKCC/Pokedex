/**
 * Blastoise Pokemon object class.
 * Single type Water implements one type interface
 * @author Connor Smith
 * @version 1.0
 * @since 9/29/2020
 */
public class Blastoise extends Wartortle implements WaterType {

   /** The minimum attack power for species. */
   static final int BASE_ATTACK_POWER = 171;
   /** The minimum defense power for species. */
   static final int BASE_DEFENSE_POWER = 207;
   /** The minimum stamina power for species. */
   static final int BASE_STAMINA_POWER = 188;

   /**
   * Constructor with no name.
   */
   public Blastoise() {
      super("Blastoise", "Blastoise", 9, 1.6, 85.5, BASE_ATTACK_POWER,
         BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
   }
   /**
   * Constructor with name.
   * @param name The user-defined name.
   */
   public Blastoise(String name) {
      super("Blastoise", name, 9, 1.6, 85.5, BASE_ATTACK_POWER,
        BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
   }

}
