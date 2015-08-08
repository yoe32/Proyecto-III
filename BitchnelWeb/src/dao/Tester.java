package dao;

import java.util.ArrayList;

import main.Gallery;

public class Tester 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		GalleryService gs = new GalleryService();
		
		//gs.showImages(2);
		
		
		ArrayList<Gallery> gallery = gs.showAllGallery(2);
		
		for (Gallery g : gallery)
		{
			System.out.println(g.getId());
			System.out.println(g.getRestaurant_id());
			System.out.println(g.getName());
		}
	}
}
