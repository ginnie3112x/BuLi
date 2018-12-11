package loeckmann.buli;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Begegnung implements Comparable<Begegnung> {

	private TreeMap<Mannschaft, Mannschaft> spiel;
	private Ergebnis ergebnis;
	private int spieltag;

	public Begegnung(Mannschaft m1, Mannschaft m2) {
		super();
		this.spiel = new TreeMap<>();
		spiel.put(m1, m2);

	}

	public TreeMap<Mannschaft, Mannschaft> getSpiel() {
		return spiel;
	}

	public void setSpiel(TreeMap<Mannschaft, Mannschaft> spiel) {
		this.spiel = spiel;
	}

	public Ergebnis getErgebnis() {
		return ergebnis;
	}

	public void setErgebnis(Ergebnis erg) {
		this.ergebnis = erg;
	}

	public int getSpieltag() {
		return spieltag;
	}

	public void setSpieltag(int spieltag) {
		this.spieltag = spieltag;
	}

	public void spielAuswerten() {
		Mannschaft man1 = getSpiel().firstEntry().getKey();
		Mannschaft man2 = getSpiel().firstEntry().getValue();
		if (getErgebnis().getErg1() < getErgebnis().getErg2()) {
			man2.setHatGewonnen(true);
			man1.setHatGewonnen(false);
			man2.setPunkte(man1.getPunkte() + 3);
			man2.setAnzahlSpieleGewonnen(man2.getAnzahlSpieleGewonnen() + 1);
			man1.setAnzahlSpieleVerloren(man1.getAnzahlSpieleVerloren() + 1);

		}
		if (getErgebnis().getErg1() > getErgebnis().getErg2()) {
			man1.setHatGewonnen(true);
			man2.setHatGewonnen(false);
			man1.setPunkte(man1.getPunkte() + 3);
			man1.setAnzahlSpieleGewonnen(man2.getAnzahlSpieleGewonnen() + 1);
			man2.setAnzahlSpieleVerloren(man1.getAnzahlSpieleVerloren() + 1);
		}
		if (getErgebnis().getErg1() == getErgebnis().getErg2()) {
			man1.setHatGewonnen(true);
			man2.setHatGewonnen(true);
			man1.setPunkte(man1.getPunkte() + 1);
			man2.setPunkte(man2.getPunkte() + 1);
			man1.setAnzahlSpieleUnentschieden(man1.getAnzahlSpieleUnentschieden() + 1);
			man2.setAnzahlSpieleUnentschieden(man2.getAnzahlSpieleUnentschieden() + 1);

		}
	}

	@Override
	public int compareTo(Begegnung other) {
		int comp = 0;
		Iterator<Entry<Mannschaft, Mannschaft>> it = this.spiel.entrySet().iterator();
		Iterator<Entry<Mannschaft, Mannschaft>> ito = other.spiel.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Mannschaft, Mannschaft> t = it.next();
			while (ito.hasNext()) {
				Entry<Mannschaft, Mannschaft> o = ito.next();
				if (t.getKey().compareTo(o.getKey()) > 0) {
					comp = -1;
				}
				if (t.getKey().compareTo(o.getKey()) < 0) {
					comp = 1;
				}

				else if (t.getKey().compareTo(o.getKey()) == 0) {
					comp = 0;
				}
			}
		}
		return comp;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((spiel == null) ? 0 : spiel.hashCode());
		result = prime * result + spieltag;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Begegnung)) {
			return false;
		}
		Begegnung other = (Begegnung) obj;
		if (spiel == null) {
			if (other.spiel != null) {
				return false;
			}
		} else if ((this.hashCode() != other.hashCode())) {
			return false;
		}

		return true;

	}

}
