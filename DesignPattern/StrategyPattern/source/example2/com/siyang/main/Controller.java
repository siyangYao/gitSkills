package com.siyang.main;

import com.siyang.CharacterClient.*;
import com.siyang.CharacterClient.Character;
import com.siyang.WeaponBehavior.*;

public class Controller {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Character cha;
		for(int i=0;i<4;i++){
			switch(i){
			case 0:{
					cha =new King();
					cha.useWeapon();
					break;
				}
			case 1:{
					cha = new Knight();
					cha.useWeapon();
					break;
				}
			case 2:{
					cha = new Queen();
					cha.useWeapon();
					break;
				}
			case 3:{
					cha = new King();
					cha.useWeapon();
					cha.setWeapon(new SwordBehavior());
					cha.useWeapon();
				}
			}
		}
	}

}
