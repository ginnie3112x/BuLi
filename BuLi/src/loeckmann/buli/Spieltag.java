package loeckmann.buli;

import java.util.TreeMap;

public class Spieltag {
	private int spieltagnummer;
	private Begegnung begegnung;
	private  TreeMap<Begegnung, Ergebnis> result;

	public Spieltag(int spieltagnummer) {
		super();
		this.spieltagnummer = spieltagnummer;
		this.result = new TreeMap<>();
	}

	public int getSpieltagnummer() {
		return spieltagnummer;
	}

	public void setSpieltagnummer(int spieltagnummer) {
		this.spieltagnummer = spieltagnummer;
	}

	public TreeMap<Begegnung, Ergebnis> getResult() {
		return result;
	}

	public void setResult(TreeMap<Begegnung, Ergebnis> result) {
		this.result = result;
	}

	public Begegnung getBegegnung() {
		return begegnung;
	}

	public void setBegegnung(Begegnung begegnung) {
		this.begegnung = begegnung;
	}

	//Begegnung wird festgelegt in TreeMap (Mannschaft, Mannschaft)
	public Begegnung newBegegnung(Mannschaft man1, Mannschaft man2) {
		man1.setAnzahlSpiele(man1.getAnzahlSpiele() + 1);
		man2.setAnzahlSpiele(man2.getAnzahlSpiele() + 1);
		begegnung = new Begegnung(man1, man2);
		begegnung.setSpieltag(spieltagnummer);
		return begegnung;
	}

	//Resultliste (TreeMap) für den Spieltag (Begegnung, Ergebnis)
	public void addBegegnungToResulttable(Begegnung b, int x, int y) {
		Ergebnis erg = new Ergebnis(x, y);
		b.setErgebnis(erg);
		Mannschaft man1 = b.getSpiel().firstEntry().getKey();
		Mannschaft man2 = b.getSpiel().firstEntry().getValue();
		man1.setAnzahlTore(man1.getAnzahlTore() + x);
		man2.setAnzahlTore(man2.getAnzahlTore() + y);
		man1.setAnzahlToreGegner(man1.getAnzahlToreGegner() + y);
		man2.setAnzahlToreGegner(man2.getAnzahlToreGegner() + x);	
		result.put(b, erg);
		Tabelle.hinzufuegenBegegnung(b);
		b.spielAuswerten();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + spieltagnummer;
		return result;
	}

	//Identifiziert den Spieltag anhand der Spieltagnnummer (id)
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Spieltag)) {
			return false;
		}
		Spieltag other = (Spieltag) obj;
		if (spieltagnummer != other.spieltagnummer) {
			return false;
		}
		return true;
	}

}
