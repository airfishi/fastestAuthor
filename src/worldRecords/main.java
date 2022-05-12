package worldRecords;

public class main {

	public static void main(String[] args) {

		recordKeeper records = new recordKeeper();
		
		
		records.addBook(1992, "Jack", "The World");
		records.addBook(1992, "Jill","Flavortown");
		records.addBook(1992, "Jill", "Megaville");
		records.massAddBooks("2002.txt");
		System.out.println(records.validYears());
		
		System.out.printf("%s has the most books written for the date %d.\n",records.mostWritten(2002), 2002);
		
		
		
	}

}
