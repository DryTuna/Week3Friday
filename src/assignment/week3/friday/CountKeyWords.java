/*
 * Name: DUY TRAN
 * Date: Feb 20th, 2015
 */

package assignment.week3.friday;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountKeyWords {

	public static void main(String[] args) {
		Map<String, Integer> keywords = new HashMap<>();
		collectKeyWords(keywords);

		Scanner input = new Scanner(System.in);
		System.out.print("Please enter your file name: ");
		String file_name = input.next();
		input.close();
		
		try (
			Scanner jFile = new Scanner(new FileInputStream(file_name));
		){
			boolean block_comment = false;
			
			while (jFile.hasNext()) {
				String java_line = jFile.nextLine().trim();

				java_line = java_line.replaceAll("\\\\\"", " ");
				java_line = java_line.replaceAll("/\\*(?:.|[\\n\\r])*?\\*/", " ");
				java_line = java_line.replaceAll("\\\"(?:.|[\\n\\r])*?\\\"", " ");
				java_line = java_line.replaceAll("//[\\w\\W]{0,}", " ");

				String[] tokens = java_line.split("\\s+");
				
				for (String token: tokens) {
					if (token.contains("/*") || token.contains("/**")) {
						block_comment = true;
						token = token.replaceAll("/\\*(?:.|[\\n\\r])*", "");
						if (keywords.containsKey(token)) {
							keywords.replace(token, keywords.get(token) + 1);
						}
					}
					
					else if (token.contains("*/")) {
						block_comment = false;
						token = token.replaceAll("(?:.|[\\n\\r])*?\\*/", "");
					}
					
					if (!block_comment) {
						String[] temp = token.split("\\W+");
						for (String t: temp)
							if (keywords.containsKey(t)) {
								keywords.replace(t, keywords.get(t) + 1);
							}
					}
				} //End of For Loop
				
			} //End of While Loop
			
			printKeyWordsCount(keywords);
		} 
		catch (FileNotFoundException e) {
			System.out.println("The file \"" + file_name 
					+ "\" does not exist in the first level of the project folder.");
		}
		
		
	}
	
	/**
	 * Name: collectKeyWords()
	 * @param keywords a Map with key a String and value an Integer
	 * Process: Fill the Map with keywords from a file and initialize its count to 0
	 */
	private static void collectKeyWords(Map<String, Integer> keywords) {
		try (
			Scanner input = new Scanner(new FileInputStream("JavaKeyWords.java"));
				){
		
			while (input.hasNext()) {
				String token = input.next();
				token = token.replaceAll("\",*", "");
				
				keywords.put(token, 0);
			}
		
		}
		catch (FileNotFoundException e) {
			System.out.println("JavaKeyWords.java does not exist in the first level"
					+ " of the project folder.");
		}
	}
	
	/**
	 * Name: printKeyWordsCount()
	 * @param keywords - a Map that contain String key and Integer count
	 * Process: Sum up the value of each of the keys
	 * 			Print out the total keywords count
	 */
	private static void printKeyWordsCount(Map<String, Integer> keywords) {
		int sum = 0;
		for (String keyword: keywords.keySet()) {
			sum += keywords.get(keyword);
			//System.out.println(keyword + ": " + keywords.get(keyword));
		}
		
		System.out.println("\nThe number of keywords in the program is " + sum +".");
	}
}
