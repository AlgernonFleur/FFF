package Objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Database {
	
	private ArrayList<Restaurant> restaurants;
	
	public Database () {
		this.restaurants = new ArrayList<Restaurant>();
	}
	
	public static void main(String[] args) {
		Database d = new Database();
		d.readInDatabase();
	}
	
	public void readInDatabase() {
		InputStream text = Database.class.getResourceAsStream("restaurantInfo.csv");
		BufferedReader restaurantInfo = new BufferedReader(new InputStreamReader(text));
		
		try {
			while (restaurantInfo.ready()) {
				String[] split = restaurantInfo.readLine().split(",");
				String name = split[0];
				int postcode = Integer.parseInt(split[1]);
				
				Restaurant newRestaurant = new Restaurant(name, postcode);
				newRestaurant.readInMenu();
				
				restaurants.add(newRestaurant);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setRestaurants(ArrayList<Restaurant> list) {
		this.restaurants = list;
	}
	
	public ArrayList<Restaurant> getRestaurants() {
		return restaurants;
	}
}
