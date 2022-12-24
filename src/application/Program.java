package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a file path:");
		String strPath = "c:\\projetos\\modulo14\\vendas.csv";
		String[] vect = new String[4];
		
		try (BufferedReader br = new BufferedReader(new FileReader(strPath))){
			String line = br.readLine();
			vect = line.split(",");
			
			for (int i = 0; i <= 3; i++) {
				if (line != null) {
					System.out.println(line);
					line = br.readLine();
			
				}
			}			
		}
		catch (IOException e){
			e.printStackTrace();
		}
		finally {
			sc.close();
		}

		for (String string : vect) {
			System.out.println(string);
		}

		File file = new File(strPath);
		file.listFiles(File::isDirectory);

		
		boolean sucess = new File(strPath + "\\out").mkdir();

		System.out.println("Directory created successfully: " + sucess);
	}

}
