package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		String path = "c:\\projetos\\modulo14\\vendas.csv";
		String path2 = "c:\\projetos\\modulo14\\out.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			BufferedWriter bw = new BufferedWriter(new FileWriter(path2));

			String line = br.readLine();
			String[] words = new String[3];
			words = line.split(",");

			for (String string : words) {
				System.out.println(string);
			}
			while (line != null) {
				System.out.println(line);
				line = br.readLine();

			}

		} catch (IOException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		
		

	}
}
