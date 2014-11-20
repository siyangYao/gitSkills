package com.siyang.CharacterClient;

import com.siyang.WeaponBehavior.*;

public class King extends Character{
	
	public King(){
		weapon = new KnifeBehavior();
		this.appearance();
	}
	
	public void appearance(){
		System.out.println("King");
	}
}
