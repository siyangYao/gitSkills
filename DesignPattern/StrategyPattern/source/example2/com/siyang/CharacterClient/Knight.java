package com.siyang.CharacterClient;

import com.siyang.WeaponBehavior.*;

public class Knight extends Character{
	
	public Knight(){
		weapon = new AxeBehavior();
		this.appearance();
	}
	
	public void appearance(){
		System.out.println("Knight");
	}
}
