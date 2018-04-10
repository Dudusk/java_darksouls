package characters;

public class Monster extends Character {

    private static int INSTANCES_COUNT;


    public Monster() {
        super();
        INSTANCES_COUNT++;
        setName("Monster_" +  INSTANCES_COUNT);
        setLife(10);
        setStamina(10);
    }

}
