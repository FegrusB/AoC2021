package aoc2021;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Prob1 {

	public static void main(String[] args) {
		
		ArrayList <Integer> data = new ArrayList<Integer>();
		ArrayList <Integer> data3 = new ArrayList<Integer>();
		int numDeeper = 0;
		int lastNum;
		int x = 1;
		
		//try to find file, copy file to ArrayList data. Catch if file not found
		try {
			File myFile = new File("C:\\Users\\fergu\\eclipse-workspace\\aoc2021\\data\\2021-1.txt");
			Scanner myScanner = new Scanner(myFile);
			while(myScanner.hasNextLine()) {
				int nl = myScanner.nextInt();
				data.add(nl);
			}
			myScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		}
		
		//create ArrayList of 3 reading windows, of each reading from data where there is a full 3
		while(data.size()>(x+1)) {
			int sum = data.get(x-1) + data.get(x) + data.get(x+1);
			data3.add(sum);
			x +=1;
		}
		
		//compare each term in data3 to the one before, increment numDeeper if i>i-1
		lastNum = data3.get(0);
		for(int i : data3) {if (i > lastNum) {numDeeper += 1;} lastNum = i;}
		
		//print final value
		System.out.println(numDeeper);

	} 

}
