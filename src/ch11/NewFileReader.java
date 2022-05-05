package ch11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NewFileReader {
	private static final String FILENAME = "./src/ch11/NewFileReader.java";
	public static void main(String[] args) {
		try (
			BufferedReader br = new BufferedReader(new FileReader(FILENAME))
		) {
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}