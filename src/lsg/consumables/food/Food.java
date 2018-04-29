package lsg.consumables.food;

import lsg.consumables.Consumable;

/**
 * Cette classe permet de fixer les parametres des sous-classe des consummables de type Food.
 *
 * @author Jade.Llanes
 * @author Tanguy.Pavé
 */
public class Food extends Consumable {

    public Food (String name, int capacity, String stat) {
        super(name, capacity, stat);
    }
}
