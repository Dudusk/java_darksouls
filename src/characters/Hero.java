package characters;

import java.util.Scanner;

public class Hero extends Character{

    public Hero() {
        super();
        setName("Ynovator");
        setLife(100);
        setStamina(50);
        refresh();
    }
    
    @Override
    public void fight1v1() {
    	
    	System.out.println("Hit enter \t key for \t next move >");
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
}


