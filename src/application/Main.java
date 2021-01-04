package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import entities.Votation;

public class Main {

	public static void main(String[] args) throws ParseException{
		
		Scanner sc = new Scanner(System.in);
		
		String path = "C:\\Users\\Isabel\\Desktop\\Estudos\\Curso de Java Completo\\Anotações\\in.txt";
		Map<String, Integer> votation = new LinkedHashMap<>();
		Votation v = new Votation();
		int totVote = 0;
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String candidate = br.readLine();
			while (candidate != null) {
				String[] fields = candidate.split(",");
				v.setName(fields[0]);
				v.setVote(Integer.parseInt(fields[1]));
				if (votation.containsKey(fields[0])) {
					totVote = v.getVote() + votation.get(v.getName());
					votation.replace(v.getName(), totVote);
				}else {
					votation.put(v.getName(), v.getVote());
				}
				candidate = br.readLine();
			}
			for (String can : votation.keySet()) {
				System.out.println(can + ": " + votation.get(can));
				}		
		}catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}finally {
			System.out.println("\nPrograma finalizado");
			sc.close();
		}
		
	}

}