package com.siyang.CharacterClient;

import com.siyang.WeaponBehavior.*;

public class Queen extends Character{
	
	public Queen(){
		weapon = new SwordBehavior();
		this.appearance();
	}
	
	public void appearance(){
		System.out.println("Queen");
	}
}
