package lsg.consumables;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import lsg.consumables.drinks.Coffe;
import lsg.consumables.drinks.Whisky;
import lsg.consumables.drinks.Wine;
import lsg.consumables.food.Americain;
import lsg.consumables.food.Hamburger;

/**
 * Cette classe dzfinit les caractéristiques et methodes d'une classe executable : Menu, groupement de plusieurs consumables.
 *
 * @author Jade.Llanes
 * @author Tanguy.Pave
 */
public class MenuBestOfV2 implements Set<Object>{
	
	 	private int MAX_CONSUMABLE = 5;
	 	Set<Consumable> menu = new HashSet<Consumable>(MAX_CONSUMABLE);
	    //Consumable[] menu = new Consumable[MAX_CONSUMABLE];


	/**
	 * Constructeur
	 */
	public MenuBestOfV2() {
	    	menu.add(new Hamburger());
	    	menu.add(new Wine());
	    	menu.add(new Americain());
	    	menu.add(new Coffe());
	    	menu.add(new Whisky());
	    }



		/**
		 * Retourne le menu en string.
		 * @return ligne
		 */
		private String listeMenu() {
			String ligne = "";
			int i = 0;
			Iterator<Consumable> itr= menu.iterator();

			while(itr.hasNext()){
				i++;
				ligne = i + ": " + itr.next();
				System.out.println(ligne);
			}

			return ligne;
		}



	    @Override
	    public String toString() {
	    	System.out.println(getClass().getSimpleName() + " :");
	        return String.format(getClass().getSimpleName() + "\n" + listeMenu());
	        //getClass().getSimpleName() + "\n" + listeMenu();
	    }


		/**
		 * Creer un menu et liste son contenu
		 * @param args
		 */
	    public static void main(String[] args) {
	        MenuBestOfV2 menu = new MenuBestOfV2();
	        menu.toString();
	    }



		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}


		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}


		@Override
		public boolean contains(Object o) {
			// TODO Auto-generated method stub
			return false;
		}



		@Override
		public Iterator<Object> iterator() {
			// TODO Auto-generated method stub
			return null;
		}



		@Override
		public Object[] toArray() {
			// TODO Auto-generated method stub
			return null;
		}



		@Override
		public Object[] toArray(Object[] a) {
			// TODO Auto-generated method stub
			return null;
		}



		@Override
		public boolean add(Object e) {
			new Hamburger();
			// TODO Auto-generated method stub
			return false;
		}



		@Override
		public boolean remove(Object o) {
			// TODO Auto-generated method stub
			return false;
		}



		@Override
		public boolean containsAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}



		@Override
		public boolean addAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}



		@Override
		public boolean retainAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}



		@Override
		public boolean removeAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}



		@Override
		public void clear() {
			// TODO Auto-generated method stub
			
		}
	
}
