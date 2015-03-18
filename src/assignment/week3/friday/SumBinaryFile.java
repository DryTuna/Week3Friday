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

public class SumBinaryFile {

	public static void main(String[] args) {
		String file_name = "BinaryFile.dat";
		int value = 0, count = 0;
		long sum = 0;
		
		try (
				DataInputStream input = new DataInputStream(
						new FileInputStream(file_name));
				){

			while (true) {
				value = input.readInt();
				sum += value;
				count ++;
				System.out.print(value + " ");
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
		
		if (count > 0) {
			System.out.println();
			System.out.println("Count is " + count);
			System.out.println("Total is " + sum);
		}

	}

}
