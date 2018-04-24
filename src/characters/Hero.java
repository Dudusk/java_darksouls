package characters;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lsg.armor.ArmorItem;
import lsg.armor.BlackWitchVeil;
import lsg.armor.DragonSlayerLeggings;
import lsg.buffs.rings.Ring;
import lsg.buffs.talismans.Talisman;
import lsg.weapons.ShotGun;

public class Hero extends Character{
	
	private static int MAX_ARMOR_PIECES = 3;
	private static int MAX_RING_PIECES = 2;
	private static int MAX_TALISMAN_PIECES = 1;
	private ArmorItem armor[] = new ArmorItem[MAX_ARMOR_PIECES];
	private Ring armorRings[] = new Ring[MAX_ARMOR_PIECES];
	private Talisman armorTalisman[] = new Talisman[MAX_TALISMAN_PIECES];
	
    public Hero() {
        super();
        setName("Ynovator");
        setLife(100);
        setStamina(50);
        refresh();
        //setWeapon(new ShotGun());
    }
    
    
//    public static void main(String[] args) {
//    	Hero hero = new Hero();   	
//    	
//    	hero.setArmorItem(new BlackWitchVeil(), 1);
//    	hero.setArmorItem(new DragonSlayerLeggings(), 3);
//    	
//    	//hero.getTotalArmor();
//    	hero.armorToString();
//    	hero.getArmorItems();
//    }

    
    @Override
    public void fight1v1() {
    	
    	System.out.println("\nHit enter \t key for \t next move >");
    	Scanner sc = new Scanner(System.in);
    	
    	String enterkey = sc.nextLine();
    	// Touche entr�e
    	
    	while(!enterkey.equals("")) {
    		System.out.println("Appuyez sur la touche entr�e !");
    		enterkey = sc.nextLine();
    	}
    	
	    if(enterkey.equals("")){
	    	refresh();
	    	if(isAlive())
	    		attack();
	    }
    }
    
    
    public void setTalisman(Talisman talisman, int slot) {
    	
    	// L'objet n'existe pas dans le tableau
    	if(slot >= 0 && slot <= MAX_TALISMAN_PIECES ) {
    		this.armorTalisman[slot-1] = talisman;
    	}
    	for(int i = 0; i<MAX_TALISMAN_PIECES ; i++) {
			System.out.println(armorTalisman[i]);
		}
    	
    }
    

    /**
     * Setter Ring
     * @param ring
     * @param slot
     */
    public void setRing(Ring ring, int slot) {
    	
    	// L'objet n'existe pas dans le tableau
    	if(slot >= 0 && slot <= MAX_RING_PIECES ) {
    		this.armorRings[slot-1] = ring;
    	}
    	
    	for(int i = 0; i<MAX_RING_PIECES ; i++) {
    		System.out.println(armorRings[i]);
    	}
    	

    }
    
    
    /**
     * Setter Armor
     * @param piece
     * @param slot
     */
    public void setArmorItem(ArmorItem piece, int slot) {
    	
    	// L'objet n'existe pas dans le tableau
    	if(slot >= 0 && slot <= MAX_ARMOR_PIECES ) {
    		this.armor[slot-1] = piece;
    	}

    }
    
    
    public float getPowerBuff() {
    	
    	return 0;
    }
    
    
    public float getPower() {
    	
    	float total = 0;
    	
    	for(int i = 0; i<armorRings.length && i < MAX_RING_PIECES; i++) {
    		if(armorRings[i] != null) {
        		total += armorRings[i].computeBuffValue();
    		}
    	}
    	
    	for(int i = 0; i<armorTalisman.length && i < MAX_TALISMAN_PIECES; i++) {
	    	if(armorTalisman[i] != null) {
				total += armorTalisman[i].computeBuffValue();
			}
    	}
    	
    	return total;
    }
    
    
    public float getTotalArmor() {
    	float total = 0;
    	
    	for(int i = 0; i<armor.length && i < MAX_ARMOR_PIECES; i++) {
    		if(armor[i] != null) {
        		total += armor[i].getArmorValue();
    		}
    	}
    	
    	//System.out.println("Total : " + ((int)(total*10))/10.);
    	return total;
    	//((float)(total*10))/10.;
    }
    
    
    public String armorToString() {
    	int i = 0;
    	String chaine = "";
    	
    	try {
	    	for(i = 0; i < MAX_ARMOR_PIECES; i++) {
	    		//System.out.println(armor[i].toString());
	    		if(armor[i] == null) {
        			chaine += i+": empty\t";
        		} else {
        			chaine += i+": " + armor[i].toString() + "\t";
        		}
	    	}
    	} catch(java.lang.IndexOutOfBoundsException exception) {
    		if(i == 0) {
    			chaine += 0+": empty\t";
    			chaine += 1+": empty\t";
    			chaine += 2+": empty\t";
    		} else if(i == 1) {
    			chaine += 1+": empty\t";
    			chaine += 2+": empty\t";
    		} else if(i == 2) {
    			chaine += 2+": empty\t";
    		}
		}
    	
    	System.out.println("ARMOR\t" + chaine);
    	return "ARMOR\t" + chaine + getTotalArmor();
    }
    
    public ArmorItem[] getArmorItems() {
    	
    	ArmorItem tableauArmurePortee[] = new ArmorItem[MAX_ARMOR_PIECES];
    	
    	for(int i = 0; i < armor.length; i++) {
    		if(armor[i] != null) {
    			tableauArmurePortee[i] = armor[i];
    		}
    	}
    	
    	return tableauArmurePortee;
    }


    /**
     * Override de la m�thode de Character
    */
	public float computeProtection() {	
		//setArmorItem(new BlackWitchVeil(), 1);
		return getTotalArmor();
	}


	@Override
	public float computeBuff() {
		return getPower();
	}
    
}


