package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);

		String path = "C:\\projetos\\modulo14\\in.csv";
		
		List<Product>list = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){			
			String line = br.readLine();
			
			while (line != null) {
				System.out.println(line);
				
				String[] attributes = new String[3];
				attributes = line.split(",");
				
				String name = attributes[0];
				Double price = Double.parseDouble(attributes[1]);
				int quantity = Integer.parseInt(attributes[2]);
				
				Product product = new Product(name, price, quantity);
				list.add(product);				
				
				line = br.readLine();
			}
			
			String strOut = "C:\\projetos\\modulo14\\summary.csv";
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(strOut))){
				
				for (Product product : list) {
					bw.write(product.getName() + ", " + product.getPrice() * product.getQuantity());
					bw.newLine();
				}
				
			}
			catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}
							
		} 
		catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
				
		}
	}
}
