import java.io.IOException;

public class NewBook extends Book {

	// Kreiranje knjige i uslovi

		public void kreirajKnjigu(int bookId, String bookName)  throws IOException {
			if (potvrdaBrojaKnjige(bookId)) {
				Account knjiga = new Account(bookId,bookName);
				System.out.println("Knjiga je dodana u bazu.");
			} else
				System.out.println("Greska. Knjigu nije moguce dodati. ");
		}
		
		public boolean potvrdaBrojaKnjige(int bookId) {
			for (int i = 0; i < books.size(); i++) {
			    if (bookId == books.get(i).getBookID()) {
					System.out.println("Broj knjige se vec koristi.");
					return false;
				}
			}
			if ( bookId < 0) {
				System.out.println("Broj knjige ne smije biti negativan broj.");
				return false;
			}
			
			return true;
			
		}

}
