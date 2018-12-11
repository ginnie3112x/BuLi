package loeckmann.buli;

import java.util.HashMap;

public class Spieler implements Comparable<Spieler> {
	private String name;
	private Mannschaft mannschaft;
	private HashMap<String, String> tor;
	private int anzahlTore;
	private String karte;

	public Spieler(String name) {
		super();
		this.name = name;
		anzahlTore = 0;
		tor = new HashMap<>();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Mannschaft getMannschaft() {
		return mannschaft;
	}

	public void setMannschaft(Mannschaft mannschaft) {
		this.mannschaft = mannschaft;
	}

	public HashMap<String, String> getTor() {
		return tor;
	}

	public void setTor(HashMap<String, String> tor) {
		this.tor = tor;
	}

	public String getKarte() {
		return karte;
	}

	public void setKarte(String karte) {
		this.karte = karte;
	}

	public int getAnzahlTore() {
		return anzahlTore;
	}

	public void setAnzahlTore(int anzahlTore) {
		this.anzahlTore = anzahlTore;
	}

	public void torEingeben(String min, Begegnung b) {
		tor.put(min, this.getName());
		System.out.println(mannschaft.getAnzahlTore() + " " + this.getAnzahlTore());
		anzahlTore = anzahlTore + 1;
		mannschaft.setAnzahlTore(mannschaft.getAnzahlTore() + 1);
		if (b.getSpiel().containsKey(mannschaft)) {
			if (mannschaft.getSpielerliste().contains(this)) {
				b.getErgebnis().setErg1(b.getErgebnis().getErg1() + 1);
			}
		} else if (b.getSpiel().containsValue(mannschaft)) {
			b.getErgebnis().setErg2(b.getErgebnis().getErg2() + 1);
		}

		System.out.println(mannschaft.getAnzahlTore() + " " + this.getAnzahlTore());

	}

	@Override
	public int compareTo(Spieler o) {
		Spieler spieler = (Spieler) o;
		return this.getName().compareTo(spieler.getName());

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mannschaft == null) ? 0 : mannschaft.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Spieler other = (Spieler) obj;
		if (mannschaft == null) {
			if (other.mannschaft != null)
				return false;
		} else if (!mannschaft.equals(other.mannschaft))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
