package DAO;

import java.util.Scanner;

import Main.Restaurant;

public class Tester {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		Restaurant res = new Restaurant();

		RestaurantService rs = new RestaurantService();

		Scanner scan = new Scanner(System.in);	
		res.setId(0);
		System.out.println("profile name");
		res.setName(scan.next());
		System.out.println("profile email");
		res.setEmail(scan.next());
		System.out.println("profile password");
		res.setPassword(scan.next());
		System.out.println("profiles description");
		res.setDescription(scan.next());
		System.out.println("profile location");
		res.setLocation(scan.next());
		System.out.println("profile image");
		res.setImg(null);

		rs.registerRestaurant(res);
		scan.close();
	}
}
