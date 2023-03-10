package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;


interface Info {
	String k = "key1";
	String v = "value2";
	
	String ID = "id";
	String PSW = "psw";
	String NAME = "name";
	String PET = "pet";
	
	String HP = "hp";
	String FEELING = "feeling";
	String STATE = "state";
	String LEVEL = "level";
	String EXP = "exp";
	String MONEY = "money";
	String POTION = "potion";
	String DRINK = "drink";
	String PILL = "pill";
	String SNACK = "snack";
	User CURRENT_USER = new User(null, null, null);
	
	// 가챠 추가
	String GACHA_1 = "gacha1";
	String GACHA_2 = "gacha2";
	String GACHA_3 = "gacha3";
	String GACHA_4 = "gacha4";
	String GACHA_5 = "gacha5";
	String GACHA_6 = "gacha6";
	
	static int MAX_HP = 100;
	static int MAX_EXP = 100;
	static int MAX_STATE = 100;
	static int MAX_FEELING = 100;
	static int MAX_LEVEL = 30;
	
	String CAT = "cat";
	String DOG = "dog";
}


public class Temp implements Info {
	
	static HashMap<String, Object> map;

	// map 을 save.dat 에 저장
	public static void saveMap(HashMap<String, Object> map) {
		
		try (FileOutputStream fOut = new FileOutputStream((String)map.get(Info.ID)+".dat");
				ObjectOutputStream oOut = new ObjectOutputStream(fOut)) {
			oOut.writeObject(map);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// save.dat 의 map 불러오기
	static HashMap<String, Object> loadMap(String id) {
		HashMap<String, Object> map = null;
		try (FileInputStream fOut = new FileInputStream(id+".dat");
				ObjectInputStream oOut = new ObjectInputStream(fOut)) {
			map = (HashMap<String, Object>) oOut.readObject();
		} catch (FileNotFoundException e) {
			map = new HashMap<String, Object>();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public static void main(String[] args) {
		new Temp();
		
	}
}


