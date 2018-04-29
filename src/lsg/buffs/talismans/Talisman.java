package lsg.buffs.talismans;

import java.util.Calendar;

import lsg.buffs.BuffItem;

/**
 * Cette classe définit les caractéristiques de base d'un talisman
 * @author Tanguy.Pave
 * @author Jade.Llanes
 */
public class Talisman extends BuffItem {
	
	private float buff ;
	private int start, end ; 
	
	/**
	 * Constructeur
	 * 
	 * @param name
	 * @param buff
	 * @param start
	 * @param end
	 */
	public Talisman(String name, float buff, int start, int end) {
		super(name) ;
		this.buff = buff ;
		this.start = start ;
		this.end = end ;
	}



	/**
	 * Override de computeBuffValue()
	 * Si l'heure n'est pas bonne, aucun buff.
	 */
	@Override
	public float computeBuffValue() {
		int now = Calendar.getInstance().get(Calendar.HOUR_OF_DAY) ;
		if(start <= end){
			if(now >= start && now < end) return buff ;
			else return 0f ;
		}else{
			if( (now <= 23 && now >= start) || (now >=0 && now < end)) return buff ;
			else return 0f ;
		}
	}
	
}
