package oop.apoteka;

public class GrupaLekova {
	private String identifikator;
	private String naziv;
	
	public GrupaLekova(String identifikator, String naziv) {
		super();
		this.identifikator = identifikator;
		this.naziv = naziv;
	}

	public String getIdentifikator() {
		return identifikator;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	
}
