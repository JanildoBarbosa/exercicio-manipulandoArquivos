package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		String path = "c:\\projetos\\modulo14\\in.txt";
		
		List<Product>list = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();

			while (line != null) {
				System.out.println(line);
				
				String[] words = new String[3];
				words = line.split(",");
				String name = words[0];
				double price = Double.parseDouble(words[1]); 
				int quantity = Integer.parseInt(words[2]);
				
				Product product = new Product(name, price, quantity);
				list.add(product);
				
				line = br.readLine();
				
			}
			
			for (Product product : list) {
				System.out.println(product);
			}
			
		} 
		catch (IOException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}
}
