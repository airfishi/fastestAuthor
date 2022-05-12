package worldRecords;

public class main {

	public static void main(String[] args) {

		recordKeeper records = new recordKeeper();
		
		
		records.addBook(1992, "Jack", "The World");
		records.addBook(1992, "Jill","Flavortown");
		records.addBook(1992, "Jill", "Megaville");
		records.massAddBooks("2002.txt");
		for(int i = 0; i < 40; i++) {
			records.addBook(1476, "Bill" + i%7,"test" + i);
		}
		System.out.println(records.validYears());
		
		/*
		 * The only date that will work currently are the ones you input 
		 * since massAddBooks is not yet implemented.x
		 */
		System.out.printf("%s has the most books written for the date %d.\n",records.mostWritten(1476), 1476);
		
		
		
	}

}
