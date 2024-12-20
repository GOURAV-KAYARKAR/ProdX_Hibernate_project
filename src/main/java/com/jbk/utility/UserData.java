package com.jbk.utility;

import java.util.Scanner;

import com.jbk.entity.Product;


public class UserData {
	public static Product getProductInfoFromUser() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Product Name ");
		String productName = scan.next();

		System.out.println("Enter Product Quentity");
		int productQty = scan.nextInt();

		System.out.println("Enter Product Price");
		int productPrice = scan.nextInt();

		System.out.println("Enter Product MFG Date");
		String mfgDate = scan.next();

		System.out.println("Enter Product EXP Date");
		String expDate = scan.next();

		Product product= new Product(productPrice, productName, productQty, productPrice, mfgDate, expDate);
		

		return product;

	}
}
