package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("ENTER CLIENT DATA:");
		
		System.out.print("Name: ");
		String name = sc.nextLine();
		//sc.nextLine();
		
		System.out.print("Email: ");
		String email = sc.next();
		sc.nextLine();
		
		System.out.print("Birth Date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println();
		
		System.out.println("ENTER ORDER DATA:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.println();
		
		System.out.print("How many items to this order? ");
		int items = sc.nextInt();
		
		System.out.println();
		
		for (int i=1; i<=items; i++) {
			System.out.println("ENTER #" + i + " ITEM DATA:");
			
			System.out.print("Product name: ");
			String productName = sc.next();
			sc.nextLine();
			
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			Product product = new Product(productName, price);
			OrderItem item = new OrderItem(quantity, price, product);
			
			order.addItem(item);
			
			System.out.println();
		}
		
		System.out.println(order);
		
		sc.close();
	}

}
