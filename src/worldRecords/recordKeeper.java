package worldRecords;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class recordKeeper {

	//on Desktop
	//File currPath = new File("B://CS 220 HOMEWORK/CS220 Plagiarism Detector/DesignExercise3/");
	//on Laptop
	File currPath = new File("D:\\CS 220 HOMEWORK\\DesignExercise3\\");
	
	Map<Integer, Map<String, Set<String>>> catalog = new HashMap<>();
	
	/*
	 * Capabilities:
	 *  add books - ensure no doubles
	 *  most written author of x year
	 *  
	 *  ?mass add from list
	 *  
	 */

	void addBook(Integer date, String author, String title) {
		if(catalog == null || catalog.get(date) == null) {
			Set<String> firstBook = new HashSet<>();
			firstBook.add(title);
			Map<String, Set<String>> temp = new HashMap<>();
			temp.put(author,firstBook);
			catalog.put(date,temp);
		} else if(!catalog.get(date).containsKey(author)) {
			Set<String> firstBook = new HashSet<>();
			firstBook.add(title);
			catalog.get(date).put(author,firstBook);
		} else catalog.get(date).get(author).add(title);
		
		if(!catalog.containsKey(date)) {
			catalog.put(date, catalog.get(date));
		} else if (!catalog.get(date).containsKey(author)){
			Set<String> firstBook = new HashSet<>();
			firstBook.add(title);			
			catalog.get(date).put(author,firstBook);
		} else {
			catalog.get(date).get(author).add(title);
		}
	}
	
	Set<Integer> validYears() {
		return catalog.keySet();
	}
	String myDir = "D:\\CS 220 HOMEWORK\\DesignExercise3\\fastestAuthor\\docs\\";
	
	String mostWritten(Integer date) {
		String topAuthor = "";
		int mostNumWritten = 0;
		if(!catalog.containsKey(date)) {
			System.out.println(String.format("There are no books on record for the date %d.", date));
			throw new IndexOutOfBoundsException("No such year");
		}else {
			for(String s: catalog.get(date).keySet()) {
				if(catalog.get(date).get(s).size() > mostNumWritten) {
					mostNumWritten = catalog.get(date).get(s).size();
					topAuthor = s;
				}
			}
		}
		return topAuthor;
	}
	
	void massAddBooks(String filename) throws FileNotFoundException {
		
		Scanner scan = new Scanner(new File(myDir + filename));
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			int x = line.indexOf(":");
			if(x > -1) {
				int cut = line.indexOf(":");
				String author = line.substring(0,cut - 1);
				String title = line.substring(cut+1);
				Integer date = Integer.parseInt(filename);
				addBook(date, author, title);
			}


		}
	}
	
	
	
}
