package loeckmann.buli;

import java.util.Iterator;
import java.util.TreeSet;

public class Mannschaft implements Comparable<Mannschaft> {
	private String name;
	private TreeSet<Spieler> spielerliste;
	private int anzahlTore;
	private int anzahlToreGegner;
	private boolean hatGewonnen;
	private int punkte;
	private int anzahlSpiele;
	private int anzahlSpieleGewonnen;
	private int anzahlSpieleVerloren;
	private int anzahlSpieleUnentschieden;

	public Mannschaft(String name) {
		super();
		this.name = name;
		this.punkte = 0;
		spielerliste = new TreeSet<>();
		hatGewonnen = false;
	}

	public int getAnzahlSpieleGewonnen() {
		return anzahlSpieleGewonnen;
	}

	public void setAnzahlSpieleGewonnen(int anzahlSpieleGewonnen) {
		this.anzahlSpieleGewonnen = anzahlSpieleGewonnen;
	}

	public int getAnzahlSpieleVerloren() {
		return anzahlSpieleVerloren;
	}

	public void setAnzahlSpieleVerloren(int anzahlSpieleVerloren) {
		this.anzahlSpieleVerloren = anzahlSpieleVerloren;
	}

	public int getAnzahlSpieleUnentschieden() {
		return anzahlSpieleUnentschieden;
	}

	public void setAnzahlSpieleUnentschieden(int anzahlSpieleUnentschieden) {
		this.anzahlSpieleUnentschieden = anzahlSpieleUnentschieden;
	}

	public int getAnzahlSpiele() {
		return anzahlSpiele;
	}

	public void setAnzahlSpiele(int anzahlSpiele) {
		this.anzahlSpiele = anzahlSpiele;
	}

	public int getPunkte() {
		return punkte;
	}

	public void setPunkte(int punkte) {
		this.punkte = punkte;
	}

	public boolean isHatGewonnen() {
		return hatGewonnen;
	}

	public void setHatGewonnen(boolean hatGewonnen) {
		this.hatGewonnen = hatGewonnen;
	}

	public TreeSet<Spieler> getSpielerliste() {
		return spielerliste;
	}

	public void setSpielerliste(TreeSet<Spieler> spielerliste) {
		this.spielerliste = spielerliste;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAnzahlTore() {
		return anzahlTore;
	}

	public void setAnzahlTore(int anzahlTore) {
		this.anzahlTore = anzahlTore;
	}

	public int getAnzahlToreGegner() {
		return anzahlToreGegner;
	}

	public void setAnzahlToreGegner(int anzahlToreGegner) {
		this.anzahlToreGegner = anzahlToreGegner;
	}

	public void addSpieler(Spieler spieler) {
		spielerliste.add(spieler);
		spieler.setMannschaft(this);
	}

	public void removeSpieler(Spieler spieler) {
		spielerliste.remove(spieler);
	}

	//Methode, um ein Tor für einen Spieler einzugeben, dies wird an den Spieler weitergereicht
	public void torEingeben(Spieler spieler, String minute, Begegnung b) {
		Iterator<Spieler> it = spielerliste.iterator();
		while (it.hasNext()) {
			Spieler s = it.next();
			//nur wenn das Argument Spieler mit dem Spieler übereinstimmt
			if (s.equals(spieler))
				s.torEingeben(minute, b);
		}
		//Toranzahl für die Mannschaft wird erhöht
		anzahlTore = anzahlTore + 1;
	}

	@Override
	public int compareTo(Mannschaft o) {

		int comp = 0;
		if (this == o)
			return 0;
		if (o != null) {
			if (o.getClass() != getClass())
				throw new ClassCastException();
			//wenn die Namen ungleich sind, wird nach Punkten sortiert (/eingefügt)
			if (this.name.compareTo(o.name) != 0) {
				
				try {
					if (this.punkte - o.punkte < 0&&this.name.compareTo(o.name)<0) {
						
						comp = -1;

					}
					if (this.punkte - o.punkte > 0&&this.name.compareTo(o.name)>0) {
						comp = 1;
						//System.out.println((this.punkte - o.punkte > 0)&&(this.name.compareTo(o.name)>0));
					}

				//wenn try nichtfunktionert wird eine ClassCastException geschmissen
				} catch (ClassCastException e) {
					System.out.println("nicht vergleichbar");

				}
			}
		}
		return (this.name.compareTo(o.name));

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + punkte;
		return result;
	}

	//Equals basiert auf Name und aktelle Punkte der Mannschaft / eventuell reicht das nicht zur Unterscheidung
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Mannschaft)) {
			return false;
		}
		Mannschaft other = (Mannschaft) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (punkte != other.punkte) {
			return false;
		}
		return true;
	}

}
