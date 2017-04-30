package Objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Restaurant {

	private String name;
	private ArrayList<Integer> userRating;
	private int postcode;
	private Menu menu;
	
	public Restaurant (String name, int postcode) {
		this.name = name;
		this.postcode = postcode;
		this.menu = new Menu();
		this.userRating = new ArrayList<Integer>();
	}

	public void readInMenu() {
		InputStream text = Database.class.getResourceAsStream("menus/" + name + ".csv");
		BufferedReader menuText = new BufferedReader(new InputStreamReader(text));
		
		try {
			while (menuText.ready()) {
				String[] split = menuText.readLine().split(",");
				String foodName = split[0];
				float price = Float.parseFloat(split[1]);
				
				Item newItem = new Item(foodName, price);
				menu.add(newItem);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getName() {
		return name;
	}

	public int getPostcode() {
		return postcode;
	}
	
	public void addRating(int i) {
		userRating.add(i);
	}
}
