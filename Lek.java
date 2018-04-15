package oop.apoteka;

public class Lek {
	static String identifikator = "1";
	private String naziv;
	private int cena;
	private int raspolozivaKolicina;
	private Proizvodjac proizvodjac;
	private GrupaLekova grupaLekova;
	
	public Lek(String naziv, int cena, int raspolozivaKolicina, Proizvodjac proizvodjac,
			GrupaLekova grupaLekova) {
		super();
		identifikator = String.valueOf(identifikator + 1);
		this.naziv = naziv;
		this.cena = cena;
		this.raspolozivaKolicina = raspolozivaKolicina;
		this.proizvodjac = proizvodjac;
		this.grupaLekova = grupaLekova;
	}
	
	protected void ispisiLek() {
		System.out.println("Naziv: " + naziv + " Cena: " + cena + " Grupa lekova: " + grupaLekova.getNaziv());
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public int getRaspolozivaKolicina() {
		return raspolozivaKolicina;
	}

	public void setRaspolozivaKolicina(int raspolozivaKolicina) {
		this.raspolozivaKolicina = raspolozivaKolicina;
	}

	public String getIdentifikator() {
		return identifikator;
	}

	public Proizvodjac getProizvodjac() {
		return proizvodjac;
	}

	public GrupaLekova getGrupaLekova() {
		return grupaLekova;
	}
	
	
	
}
