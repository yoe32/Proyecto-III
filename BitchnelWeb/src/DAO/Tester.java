package DAO;

import java.util.Scanner;

import Main.Restaurant;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Restaurant res = new Restaurant();
		
		RestaurantService rs = new RestaurantService();
		
		Scanner scan = new Scanner(System.in);	
		res.setRestaurant_profile_id(0);
		System.out.println("profile name");
		res.setRestaurant_name(scan.next());
		System.out.println("profile email");
		res.setRestaurant_email(scan.next());
		System.out.println("profile password");
		res.setRestaurant_password(scan.next());
		System.out.println("profiles description");
		res.setRestaurant_description(scan.next());
		System.out.println("profile location");
		res.setRestaurant_location(scan.next());
		System.out.println("profile image");
		res.setRestaurant_img(null);
	
		rs.registerRestaurant(res);
scan.close();
	}

}
