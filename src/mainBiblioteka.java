import java.util.Scanner;

public class mainBiblioteka {

	public static void main(String[] args) {
			
		Scanner input = new Scanner(System.in);
			
		
		System.out.println("********************Dobrodosli u Biblioteku!********************");
		System.out.println("           Molim Vas izaberite jednu od ponudjenih opcija:               ");
		System.out.println("**********************************************************************");
		
			System.out.println("1: Kreiranje racuna. ");
			System.out.println("2: Dodaj novu knjigu u bazu.");
			System.out.println("3: Podizanje nove knjige. ");
			System.out.println("4: Vraæanje knjige. ");
			System.out.println("5: Lista svih posudjenih i vracenih knjiga. ");
			System.out.println("6: Izlazak iz programa. ");
			
			int choice = input.nextInt();
		
		
		while (choice < 1 || choice >6 ){
			System.out.println("Pogresan unos. Izaberite jednu od ponudjenih opcija.");
			choice = input.nextInt();
		}

		switch (choice) {
		case 1:
			
			System.out.println("Unesite broj racuna: ");
			int brojRacuna = input.nextInt();
			System.out.println("Unesite korisnicko ime: ");
			String imeKorisnika = input.next();
			
			NewAccount racun = new NewAccount();
			racun.kreirajAccount(brojRacuna, imeKorisnika);
			break;
			
		case 2:
			
			System.out.println("Unesite broj knjige: ");
			int brojKnjige = input.nextInt();
			System.out.println("Unesite naziv knjige: ");
			String naziv = input.next();
			
			NewBook knjiga = new NewBook();
			knjiga.kreirajKnjigu(brojKnjige, naziv);
			break;
			
		case 3:
			
			System.out.println("Unesite broj racuna: ");
			int brojRacunaKorisnika = input.nextInt();
			
			System.out.println("Unesite broj knjige: ");
			int brojKnjigePodigni = input.nextInt();
			
			BorrowingBook.podigniKnjigu(brojRacunaKorisnika, brojKnjigePodigni);
			
			break;
			
		case 4:
				
			System.out.println("Unesite broj racuna: ");
			int brojRacunaAccout = input.nextInt();
			System.out.println("Unesite broj knjige: ");
			int brojKnjigeVracanje = input.nextInt();
				
			BorrowingBook.vratiKnjigu(brojRacunaAccout, brojKnjigeVracanje);	
			break;
		case 5:
			BorrowingBook.ispisiListe();
			break;
		case 6:
			break;
			
		}
		}
}
	
	