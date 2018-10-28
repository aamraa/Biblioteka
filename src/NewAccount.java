import java.util.Scanner;


public class NewAccount extends Account {
	
	
	// Kreirati Account 

	public void kreirajAccount(int brojAccounta, String imeKorisnika) {
		if ( potvrdaBrojaAccounta(brojAccounta)) {
			Account Racun = new Account(brojAccounta, imeKorisnika);
			System.out.println("Racun je uspjesno kreiran.");
		}
		else 
			System.out.println("Greska. Racun nije moguce kreirati.");
	}
	
	// provjerava da li je broj Account ispravan unos
	
	public boolean potvrdaBrojaAccounta(int brojAccounta) {
		if ( brojAccounta < 0) {
			System.out.println("Broj racuna ne moze biti negativan broj.");
			return false;
		}
		for ( int i = 0; i < accounts.size(); i++ ) {
			if (accounts.get(i).id == id) {
				System.out.println("Racuni pod tim brojem vec postoji.");
				return false;
			}
		}
		return true;
	}
		
}