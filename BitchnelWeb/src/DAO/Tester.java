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
		res.setName(scan.nextLine());
		System.out.println("profile email");
		res.setEmail(scan.nextLine());
		System.out.println("profile password");
		res.setPassword(scan.nextLine());
		System.out.println("profiles description");
		res.setDescription(scan.nextLine());
		System.out.println("profile location");
		res.setLocation(scan.nextLine());
		System.out.println("profile phone 1");
		res.setPhonei(scan.nextInt());
		System.out.println("profile phone 2");
		res.setPhoneii(scan.nextInt());
		System.out.println("profile phone 3");
		res.setPhoneiii(scan.nextInt());
		System.out.println("profile image");
		res.setImg(null);

		rs.registerRestaurant(res);
		scan.close();
	}
}
