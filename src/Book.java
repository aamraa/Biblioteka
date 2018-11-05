import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Book {
	
	//Atributi
	private int bookID;
	private String bookName;
	private boolean bookStatus;  
	
	// pohranjuje sve kreirane knjige
	public static ArrayList<Book> books = new ArrayList<Book>();
	
	//Konstruktor

	public Book() {

	}

	protected Book( int bookID, String bookName) throws IOException {
		this.bookID = bookID;
		this.bookName = bookName;
		this.bookStatus = true;
		books.add(this);
		unosUFile(this.bookID, this.bookName);
		}
	
	// provjerava da li je knjiga dostupna
	
	public static boolean stanjeKnjige(int bookid) {
		for (int i = 0; i < books.size(); i++) {
		    if (books.get(i).bookID == bookid) {
			if (books.get(i).bookStatus) {
			    return true;
			}
		    }
		}
		System.out.println("Knjiga nije dostupna.");
		return false;
	    }
	
	public static void preuzetaKnjiga(int brojKnjige) { 
		for (Book knjiga : books) {
			if (knjiga.getBookID() == brojKnjige) {
				knjiga.setBookStatus(false);
				System.out.println("Knjiga broj: " + knjiga.bookID + " je preuzeta.");
			}
		}
	}
	
	public static void vracenaKnjiga(int brojKnjige) {
		for (Book knjiga : books) {
			if (knjiga.getBookID() == brojKnjige) {
				knjiga.setBookStatus(true);
				System.out.println("Knjiga broj: " + knjiga.bookID + " je sada dostupna.");
			}
		}
	}

	// getters i setters
	
	public boolean isBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(boolean bookStatus) {
		this.bookStatus = bookStatus;
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
public static void kreirajFile() {
		
		java.io.File file = new java.io.File("ListaKnjiga.txt");
}
public void unosUFile(int brojKnjige, String nazivKnjige) throws IOException {
	
	try(FileWriter unos = new FileWriter("ListaKnjiga.txt", true);
		    BufferedWriter buffer = new BufferedWriter(unos);
		    PrintWriter out = new PrintWriter(buffer))
		{
		out.println(brojKnjige + " " + nazivKnjige);
		out.close();
		buffer.close();
		unos.close();
		}		  
}

public static void izbrisiFile() throws IOException {
	
	Files.deleteIfExists(Paths.get("C:\\Users\\User\\eclipse-workspace\\Biblioteka\\ListaKnjiga.txt"));
	
}

}
