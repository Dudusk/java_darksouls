package characters;

public class Monster extends Character {

    private static int INSTANCES_COUNT;
    private float skinThickness = 20;
    
    
    public Monster() {
        super();
        INSTANCES_COUNT++;
        setName("Monster_" +  INSTANCES_COUNT);
        setLife(10);
        setStamina(10);
        refresh();
    }
    
    @Override
    public void fight1v1() {
    	refresh();
    	if(isAlive())
    		attack();
    }
    
    
    /**
     * Getters/setters
     * @return
     */

    public float getSkinThickness() {
        return skinThickness;
    }

    public void setSkinThickness(int skinThickness) {
        this.skinThickness = skinThickness;
    }

    
    /**
     * Override de la méthode de Character
     */
    
	@Override
	public float computeProtection() {
		return getSkinThickness();
	}

	@Override
	public float computeBuff() {
		// TODO Auto-generated method stub
		return 0;
	}
    
}
