package lsg.consumables.drinks;

import lsg.consumables.Consumable;

/**
 * Cette classe permet de fixer les parametres des sous-classe des consummables de type Drink.
 *
 * @author Jade.Llanes
 * @author Tanguy.Pavé
 */
public class Drink extends Consumable {

    public Drink(String name, int capacity, String stat) {
        super(name, capacity, stat);
    }
}
