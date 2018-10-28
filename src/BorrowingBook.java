import java.util.ArrayList;
import java.util.Date;

public class BorrowingBook {
	
	// pohranjuje podatke posudjenih i vracenih Book 
	private static ArrayList<BorrowingBook> listBorrowed = new ArrayList<>();
	private static ArrayList<BorrowingBook> listReturn = new ArrayList<>();
	
	//Atributi
	private int accountID;
	private int bookID;
	private Date date;
	

	//konstruktor
	public BorrowingBook() {
		
	}
	
	// metode
	
	public BorrowingBook(int accountID, int bookID, Date date) {
		this.accountID = accountID;
		this.bookID = bookID;
		this.date = date;
	}
	
	// ako su ispunjeni uslovi za preuzimanje knjige, poziva odgovarajuce metode i dodaje unos u list posudjivanja

	public static void podigniKnjigu(int accountID, int bookID) {
		if (Account.checkAccount(accountID) && Book.stanjeKnjige(bookID) && Account.brojPodignutihKnjiga(accountID)) {
			Account.povecajBrojPosudjenjihKnjiga(accountID);
			Book.preuzetaKnjiga(bookID);
			Date date = new Date();
			System.out.println("Knjiga je preuzeta: " + date);
			BorrowingBook borrowingBook = new BorrowingBook(accountID, bookID, date);
			listBorrowed.add(borrowingBook);
		} else
			System.out.println("Nemoguce izdati knjigu.");
	}
	
	// ukoliko su ispunjeni uslovi za vracanje knjige, poziva odgovarajuce metode i dodaje unos u listu vracanja

	public static void vratiKnjigu(int accountID, int bookID) {
		if (Account.checkAccount(accountID) && Book.stanjeKnjige(bookID)) {
			Account.smanjiBrojPosudjenihKnjiga(accountID);
			Book.vracenaKnjiga(bookID);
			Date date = new Date();
			System.out.println("Book vracena na dan: " + date);
			BorrowingBook borrowingBook = new BorrowingBook(accountID, bookID, date);
			listReturn.add(borrowingBook);
		}
	}

	public static void ispisiListe() {
		System.out.println("Lista posudjenih knjiga:");
		System.out.println("-------------------------");
		for (BorrowingBook unos : listBorrowed)
			System.out.println("Broj racuna: " 
								+ unos.accountID 
								+ ", broj knjige: " 
								+ unos.bookID 
								+ " preuzeta na dan " 
								+ unos.date);
	
		
		System.out.println("\nLista vracenih knjiga:");
		System.out.println("-------------------------");
		for (BorrowingBook unos : listReturn)
			System.out.println("Broj racuna: " 
								+ unos.accountID 
								+ ", broj knjige: " 
								+ unos.bookID 
								+ " vracena na dan " 
								+ unos.date);
	}
	
}
