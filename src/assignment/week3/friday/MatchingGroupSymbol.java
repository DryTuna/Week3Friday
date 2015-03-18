/*
 * Name: DUY TRAN
 * Date: Feb 20th, 2015
 */

package assignment.week3.friday;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class MatchingGroupSymbol {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter your file name: ");
		String file_name = input.next();
		input.close();
		
		Stack<Character> symbols = new Stack<>();
		boolean isMatch = true;
		
		try (
			DataInputStream jFile = new DataInputStream(new FileInputStream(file_name));
		){

			while (isMatch) {
				char sym = (char)jFile.readByte();
				
				switch (sym) {
					case '(':
					case '{':
					case '[': 
						symbols.push(sym); 
						break;
					case ')':
						if (symbols.isEmpty() || symbols.pop() != '(')
							isMatch = false;
						break;
					case '}':
						if (symbols.isEmpty() || symbols.pop() != '{')
							isMatch = false;
						break;
					case ']':
						if (symbols.isEmpty() || symbols.pop() != '[')
							isMatch = false;
						break;
					default:
				}
			}
			
		} 
		catch (FileNotFoundException e) {
			System.out.println("The file \"" + file_name 
					+ "\" does not exist in the first level of the project folder.");
		}
		catch (EOFException e) {
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		if (isMatch && symbols.isEmpty())
			System.out.println("Correct grouping pairs.");
		else
			System.out.println("Incorrect grouping pairs.");
	}

}
