package characters;

import lsg.buffs.talismans.Talisman;

/**
 * Cette classe définit les caractéristiques du character : Monster
 * @author Tanguy.Pave
 * @author Jade.Llanes
 */
public class Monster extends Character {

    private static int INSTANCES_COUNT;
    private float skinThickness = 20;
    
    private static int MAX_TALISMAN_PIECES = 1;
    private Talisman armorTalisman[] = new Talisman[MAX_TALISMAN_PIECES];
    
    /**
     * Constructeur
     */
    public Monster() {
        super();
        INSTANCES_COUNT++;
        setName("Monster_" +  INSTANCES_COUNT);
        setLife(10);
        setStamina(10);
        refresh();
    }



    /**
     * L'action du monstre : Attaquer s'il est en vie
     */
    @Override
    public void fight1v1() {
    	refresh();
    	if(isAlive())
    		attack();
    }



    /**
     * Méthode qui permet d'ajouter un talisman au Héro
     * @param talisman
     * @param slot
     */
    public void setTalisman(Talisman talisman, int slot) {
    	
    	// L'objet n'existe pas dans le tableau
    	if(slot >= 0 && slot <= MAX_TALISMAN_PIECES ) {
    		this.armorTalisman[slot-1] = talisman;
    	}
    	System.out.print("Talismans : ");
    	for(int i = 0; i<MAX_TALISMAN_PIECES ; i++) {
			System.out.println(armorTalisman[i]);
		}
    	
    }



    /**
     * Obtenir le power du talisman
     * @return total
     */
    public float getPower() {
    	
    	float total = 0;
    	
    	for(int i = 0; i<armorTalisman.length && i < MAX_TALISMAN_PIECES; i++) {
	    	if(armorTalisman[i] != null) {
				total += armorTalisman[i].computeBuffValue();
			}
    	}
    	
    	return total;
    }
    


    /**
     * Getters/setters
     */
    public float getSkinThickness() {
        return skinThickness;
    }

    public void setSkinThickness(int skinThickness) {
        this.skinThickness = skinThickness;
    }



    /**
     * Override de la methode de Character
     */
	@Override
	public float computeProtection() {
		return getSkinThickness();
	}



	/**
     * Override de la methode de ComputeBuff
     */
	@Override
	public float computeBuff() {
		// TODO Auto-generated method stub
		return getPower();
	}
    
}
