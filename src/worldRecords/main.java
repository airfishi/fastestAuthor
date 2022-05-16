package worldRecords;

import java.io.FileNotFoundException;

public class main {

	public static void main(String[] args) {

		recordKeeper records = new recordKeeper();
		
		
		records.addBook(1992, "Jack", "The World");
		records.addBook(1992, "Jill","Flavortown");
		records.addBook(1992, "Jill", "Megaville");
		try {
			records.massAddBooks("2002.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < 40; i++) {
			records.addBook(1476, "Bill" + i%7,"test" + i);
		}
		System.out.println(records.validYears());
		
		System.out.printf("%s wrote the most books in %d.\n",records.mostWritten(1476), 1476);
		System.out.printf("%s wrote the most books in %d.\n",records.mostWritten(1992), 1992);
		
		
		
	}

}
