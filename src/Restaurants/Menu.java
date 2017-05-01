package Restaurants;

import java.util.ArrayList;

public class Menu {
	
	private ArrayList<Item> items;
	
	public Menu () {
		this.items = new ArrayList<Item>();
	}
	
	public void add(Item i) {
		items.add(i);
	}
}
