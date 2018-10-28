import java.util.ArrayList;


/**
 * @author User
 *
 */
public class Account {
	
	// Atributi
	
	protected int id;
	private String userName;
	private int brojPosudjenihKnjiga = 0;
	public static ArrayList<Account> accounts = new ArrayList<>(); 

	// Konstruktor 
	
	public Account() {

	}
	
	//Metode

	// Pohranjuje svih racuna koje kreiramo
	
	protected Account(int id, String userName) { 
		this.id = id;
		this.userName = userName;
		accounts.add(this);
	}
	
	// Provera da li racun postoji
	
	public static boolean checkAccount(int id) {
		for (int i = 0; i < accounts.size(); i++) {
		    if (id == accounts.get(i).id) {
			System.out.println("Broj racuna vec postoji");
			return false;
		    }
		}
		return true;
	    }
	
	//Provjerava broj posudjenih knjiga
	
	  public static boolean brojPodignutihKnjiga(int id) {
			for (int i = 0; i < accounts.size(); i++) {
			    if (accounts.get(i).id == id) {
				if (accounts.get(i).id > 3) {
				    System.out.println("Ne mozete podici vise od 3 knjige. ");
				    return false;
				}
			    }
			}
			return true;
		    }
	  
	  // dodajemo ili oduzimamo broj knjiga
	  
	  public static void povecajBrojPosudjenjihKnjiga(int accountId) {
		  for (int i = 0; i < accounts.size(); i++) {
			    if (accounts.get(i).id == accountId) 
				accounts.get(i).brojPosudjenihKnjiga++;
			    else 
				System.out.println("Mozete podici samo tri knjige.");
		}
	  }
	  
	  public static void smanjiBrojPosudjenihKnjiga(int accountId) {
		  for (int i = 0; i < accounts.size(); i++) {
			    if (accounts.get(i).id == accountId) 
				accounts.get(i).brojPosudjenihKnjiga--;
			    System.out.println("Posudili ste novu knjigu.");
				
		  }
		  
		}

	 // getters and setters 
		
		public int getId() {
			return id;
		}

	
		public void setId(int id) {
			this.id = id;
		}

		public String getuserName() {
			return userName;
		}

		public void setuserName(String userName) {
			this.userName = userName;
		}

		public int getBrojPosudjenihKnjiga() {
			return brojPosudjenihKnjiga;
		}

		public void setBrojPosudjenihKnjiga(int brojPosudjenihKnjiga) {
			this.brojPosudjenihKnjiga = brojPosudjenihKnjiga;
		}
		
	  
	}

	

