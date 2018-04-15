package oop.apoteka;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Glavna {
	static List<Proizvodjac> listaProizvodjaca = new ArrayList<>();
	static List<GrupaLekova> listaGrupeLekova = new ArrayList<>();
	static List<Lek> lekovi = new ArrayList<>();

	public static void main(String[] args) {
		listaProizvodjaca.add(new Proizvodjac(String.valueOf(listaProizvodjaca.size() + 1), "Galenika"));
		listaProizvodjaca.add(new Proizvodjac(String.valueOf(listaProizvodjaca.size() + 1), "Hemofarm"));

		listaGrupeLekova.add(new GrupaLekova(String.valueOf(listaGrupeLekova.size() + 1), "Antihistamici"));
		listaGrupeLekova.add(new GrupaLekova(String.valueOf(listaGrupeLekova.size() + 1), "Analgetici"));
		listaGrupeLekova.add(new GrupaLekova(String.valueOf(listaGrupeLekova.size() + 1), "Antibiotici"));

		lekovi.add(new Lek("Lek1", 150, 15, listaProizvodjaca.get(0), listaGrupeLekova.get(1)));
		lekovi.add(new Lek("Lek2", 370, 7, listaProizvodjaca.get(1), listaGrupeLekova.get(0)));
		lekovi.add(new Lek("Lek3", 200, 6, listaProizvodjaca.get(1), listaGrupeLekova.get(2)));
		lekovi.add(new Lek("Lek4", 1000, 2, listaProizvodjaca.get(1), listaGrupeLekova.get(1)));
		lekovi.add(new Lek("Lek5", 1200, 7, listaProizvodjaca.get(0), listaGrupeLekova.get(2)));
		lekovi.add(new Lek("Lek6", 3000, 6, listaProizvodjaca.get(0), listaGrupeLekova.get(0)));

		String unos = "";
		do {
			meni();
			unos = unesi();
			switch (unos) {
			case "a":
				prikaziSveLekove();
				break;
			case "b":
				prikaziNajskupljiLek();
				break;
			case "c":
				snimiLekoveManjeOd10();
				break;
			case "d":
				// prikaziNajskupljegProzvodjaca();
				break;
			case "x":
			default:
				break;
			}
		} while (!unos.equals("x"));
	}

	private static String lekovi2String(Lek lek) {
			return lek.getNaziv() + "," + lek.getCena() + "," + lek.getGrupaLekova().getNaziv();
	}

	private static void snimiLekoveManjeOd10() {
		String putanja = "lekovi";
		PrintWriter output = null;
		try {
			output = new PrintWriter(new FileWriter(putanja));
			for (int i = 0; i < lekovi.size(); i++) {
				if (lekovi.get(i).getRaspolozivaKolicina() < 10) {
					output.println(lekovi2String(lekovi.get(i)));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (output != null) {
				output.close();
			}
		}
	}

	private static void prikaziNajskupljiLek() {
		int najskuplji = 0;
		Lek indeks = null;
		for (int i = 0; i < lekovi.size(); i++) {
			if (najskuplji <= lekovi.get(i).getCena()) {
				najskuplji = lekovi.get(i).getCena();
				indeks = lekovi.get(i);
			}
		}
		indeks.ispisiLek();

	}

	private static void prikaziSveLekove() {
		for (int i = 0; i < lekovi.size(); i++) {
			lekovi.get(i).ispisiLek();
		}

	}

	static String unesi() {
		String s = "";
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		try {
			s = input.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}

	static void meni() {
		System.out.println("a - prikaz svih lekova");
		System.out.println("b - najskuplji lek");
		System.out.println("c - snimanje u fajl");
		System.out.println("d - cene po grupama");
		System.out.println("x - kraj");
	}
}
