package com.siyang.CharacterClient;

import com.siyang.WeaponBehavior.WeaponBehavior;

public class Character {
	WeaponBehavior weapon;
	
	public void useWeapon(){
		weapon.useWeapon();
	}
	
	public void setWeapon(WeaponBehavior wb){
		this.weapon = wb;
	}
	
	public void appearance(){};
}
