package characters;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lsg.armor.ArmorItem;
import lsg.armor.BlackWitchVeil;
import lsg.armor.DragonSlayerLeggings;

public class Hero extends Character{
	
	private static int MAX_ARMOR_PIECES = 3;
	private ArmorItem armor[] = new ArmorItem[MAX_ARMOR_PIECES];
	
    public Hero() {
        super();
        setName("Ynovator");
        setLife(100);
        setStamina(50);
        refresh();
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
    	
    	System.out.println("Hit enter \t key for \t next move >");
    	Scanner sc = new Scanner(System.in);
    	
    	String enterkey = sc.nextLine();
    	// Touche entrée
    	
    	while(!enterkey.equals("")) {
    		System.out.println("Appuyez sur la touche entrée !");
    		enterkey = sc.nextLine();
    	}
    	
	    if(enterkey.equals("")){
	    	refresh();
	    	if(isAlive())
	    		attack();
	    }
    }
    
    /**
     * Getter/setters
     */
    
    public void setArmorItem(ArmorItem piece, int slot) {
    	
    	// L'objet n'existe pas dans le tableau
    	if(slot >= 0 && slot <= MAX_ARMOR_PIECES ) {
    		this.armor[slot-1] = piece;
    	}

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
     * Override de la méthode de Character
    */
	public float computeProtection() {	
		//setArmorItem(new BlackWitchVeil(), 1);
		return getTotalArmor();
	}
    
}


