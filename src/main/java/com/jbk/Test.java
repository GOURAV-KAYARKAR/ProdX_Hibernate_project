package com.jbk;

import java.util.List;
import java.util.Scanner;

import com.jbk.entity.Product;
import com.jbk.operation.Operation;
import com.jbk.utility.UserData;

public class Test {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Operation operation = new Operation();
		int choice;
		boolean WantToContinue = true;

		do {
			System.out.println("press 1 for Add Product ");
			System.out.println("press 2 for Delete Product by Id ");
			System.out.println("press 3 for Get Product by Id ");
			System.out.println("press 4 for Update Product by Id ");
			System.out.println("press 5 for All Product  ");
			System.out.println("press 6 for All Product by Order [A-Z]  ");
			System.out.println("press 7 for Get Product by Product Name ");
			System.out.println("press 8 for Products with Price Greater Than Specified Price ");
			System.out.println("press 9 for Products by Name Pattern  ");
			System.out.println("press 10 for Products Within Price Range ");
			System.out.println("Press 0 for exit");
			choice = scan.nextInt();

			switch (choice) {
			case 0:
				WantToContinue = false;
				break;
			case 1: {
				System.out.println("Add product ");
				Product product = UserData.getProductInfoFromUser();
				String msg = operation.addProduct(product);
				System.out.println(msg);
				break;
			}
			case 2: {
				System.out.println("Give the Id Of Product");
				int ProductId = scan.nextInt();
				String msg = operation.deleteProduct(ProductId);
				System.out.println(msg);
				break;

			}

			case 3: {
				System.out.println("Give the Id Of Product");
				int ProductId = scan.nextInt();
				Object object = operation.getProductById(ProductId);
				System.out.println(object);
				break;

			}
			case 4: {
				System.out.println("Give the Id Of Product");
				int ProductId = scan.nextInt();
				Product product = UserData.getProductInfoFromUser();
				product.setProductId(ProductId);
				String msg = operation.updateProductById(ProductId);
				System.out.println(msg);
				break;
			}
			case 5: {
				System.out.println("Here Is Your All Product");
				List<Product> allProduct = operation.getAllProduct();
				System.out.println(allProduct);
				break;
			}
			case 6: {
				List<Product> allProductByOrder = operation.getAllProductByOrder();
				if (!allProductByOrder.isEmpty()) {
					// if (allProductByOrder != null && !allProductByOrder.isEmpty()){
					System.out.println(allProductByOrder);
				} else {
					System.out.println("No Product In List");
				}
				break;
			}
			case 7: {
				System.out.println("Enter Your Product Name");
				String Name = scan.next();
				List<Product> productByProductname = operation.getProductByProductname(Name);
				if (!productByProductname.isEmpty()) {
					System.out.println(productByProductname);
				} else {
					System.out.println("No Product In List");
				}
				break;
			}
			case 8: {
				System.out.println("Enter Your Price");
				double price = scan.nextDouble();
				List<Product> productBymaxPrice = operation.getProductGreaterThanGivenPrice(price);
				if (!productBymaxPrice.isEmpty()) {
					System.out.println(productBymaxPrice);
				} else {
					System.out.println("No Product In List");
				}
				break;
			}
			case 9: {
				System.out.println("Enter Your search");
				String Name = scan.next();
				List<Product> productByPattern = operation.getProductBymatchingPattern(Name);
				if (!productByPattern.isEmpty()) {
					System.out.println(productByPattern);
				} else {
					System.out.println("No Product In List");
				}
				break;
			}
			case 10: {
				System.out.println("Enter Your lower Price");
				double low = scan.nextDouble();
				System.out.println("Enter Your higher Price");
				double high = scan.nextDouble();
				List<Product> productInRange = operation.getProductBetRange(low, high);
				if (productInRange != null && !productInRange.isEmpty()) {
					System.out.println(productInRange);
				} else {
					System.out.println("No Product In List");
				}
				break;
			}
			default:
				break;
			}
		} while (WantToContinue);
	}
}
