package oop.apoteka;

public class Proizvodjac {
	private String identifikator;
	private String naziv;
	
	public Proizvodjac(String identifikator, String naziv) {
		super();
		this.identifikator = identifikator;
		this.naziv = naziv;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getIdentifikator() {
		return identifikator;
	}
	
	
}
