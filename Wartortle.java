/**
 * Wartortle Pokemon object class.
 * Single type Water implements one type interface
 * Parent class to Blastoise
 * @author Connor Smith
 * @version 1.0
 * @since 9/29/2020
 */
public class Wartortle extends Squirtle implements WaterType {

   /** The minimum attack power for species. */
   static final int BASE_ATTACK_POWER = 126;
   /** The minimum defense power for species. */
   static final int BASE_DEFENSE_POWER = 155;
   /** The minimum stamina power for species. */
   static final int BASE_STAMINA_POWER = 153;

   /**
   * Constructor with no name.
   */
   public Wartortle() {
      super("Wartortle", "Wartortle", 8, 1.0, 22.5, BASE_ATTACK_POWER,
        BASE_DEFENSE_POWER, BASE_STAMINA_POWER);

      chooseFastAttack();
      chooseSpecialAttack();
   }
   /**
   * Constructor with name.
   * @param name The user-defined name.
   */
   public Wartortle(String name) {
      super("Wartortle", name, 8, 1.0, 22.5, BASE_ATTACK_POWER,
        BASE_DEFENSE_POWER, BASE_STAMINA_POWER);

      chooseFastAttack();
      chooseSpecialAttack();
   }

   /**
   * Constructor with species and name for subclasses.
   * This allows subclass specific name, number, height, weight, and basePowers
   * to pass through to Pokemon superclass constructor
   *@param species The Pokemon's species.
   *@param name The optional user-given name.
   *@param num The Pokedex number for this species.
   *@param ht The height of this Pokemon.
   *@param wt The weight of this Pokemon.
   *@param baseAttackPwr The low limit of Attack Power for species.
   *@param baseDefensePwr The low limit of Defense Power for species.
   *@param baseStaminaPwr The low limit of Stamina Power for speices.
   */
   protected Wartortle(String species, String name, int num, double ht,
       double wt, int baseAttackPwr, int baseDefensePwr, int baseStaminaPwr) {

      super(species, name, num, ht, wt, baseAttackPwr,
      baseDefensePwr, baseStaminaPwr);

      chooseFastAttack();
      chooseSpecialAttack();
   }

}
