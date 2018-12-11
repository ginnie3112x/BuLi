package loeckmann.buli;

import java.util.*;

public class Tabelle {

	private static TreeSet<Begegnung> liste = new TreeSet<>();
	private static TreeSet<Mannschaft> mannschaftsliste = new TreeSet<>();

	public static TreeSet<Begegnung> getListe() {
		return Tabelle.liste;
	}

	public static void setListe(TreeSet<Begegnung> liste) {
		Tabelle.liste = liste;
	}

	public static TreeSet<Mannschaft> getMannschaftsliste() {
		return Tabelle.mannschaftsliste;
	}

	public static void setMannschaftsliste(TreeSet<Mannschaft> mannschaftsliste) {
		Tabelle.mannschaftsliste = mannschaftsliste;
	}

	public static void hinzufuegenBegegnung(Begegnung b) {
		Tabelle.liste.add(b);

	}

	// gibt die Begegnungen aus sortiert nach dem Key welcher nach Mannschaft
	// sortiert, festgelegt in Mannschaft
	public static void printTabelleBegegnungen() {
		StringBuilder builder = new StringBuilder();
		builder.append("Begegnungen nach Mannschaften absteigend\n");
		builder.append("----------------------------------------\n");
		Iterator<Begegnung> it = Tabelle.liste.iterator();

		while (it.hasNext()) {
			Begegnung b = it.next();
			Mannschaft man1 = b.getSpiel().firstEntry().getKey();
			Mannschaft man2 = b.getSpiel().firstEntry().getValue();

			builder.append(man1.getName());
			builder.append("\t:\t");
			builder.append(man2.getName());
			builder.append("\n");
			builder.append(String.format("%10s", b.getErgebnis().getErg1()));
			builder.append("\t:\t");
			builder.append(String.format("%s", b.getErgebnis().getErg2()));
			builder.append("\n");
			builder.append("- - - - - - - - - - - - - - - - - - - - \n");
			builder.append("\n");
		}
		builder.append("----------------------------------------\n\n");
		System.out.println(builder.toString());
	}


	public static void printGesamttabelle() {
		StringBuilder builder = new StringBuilder();		
		List<Mannschaft> list = new ArrayList<Mannschaft>();
		list.addAll(mannschaftsliste);
		Collections.sort(list, new Comparator<Mannschaft>() {

			@Override
			public int compare(Mannschaft o1, Mannschaft o2) {

				int comp = 0;
				if (o1 == o2)
					return 0;
				if (o1 != null && o2 != null) {
								
						try {
							if (o1.getPunkte() - o2.getPunkte() < 0) {

								comp = 11;

							}
							if (o1.getPunkte() - o2.getPunkte() > 0)  {
								comp = -1;
								// System.out.println((this.punkte - o.punkte >
								// 0)&&(this.name.compareTo(o.name)>0));
							}

							// wenn try nichtfunktionert wird eine ClassCastException geschmissen
						} catch (ClassCastException e) {
							System.out.println("nicht vergleichbar");

						}
					
				}
				return comp;
			}

		});
		
		Iterator<Mannschaft> it = list.iterator();
		builder.append("Mannschaft\tPunkte\tG\tN\tU\tTore\tSpiele\n");
		builder.append("-----------------------------------------------------------------\n");
		while (it.hasNext()) {
			Mannschaft man = it.next();
			builder.append(man.getName() + "\t");
			builder.append(man.getPunkte());
			builder.append("\t");
			builder.append(man.getAnzahlSpieleGewonnen() + "\t");
			builder.append(man.getAnzahlSpieleVerloren() + "\t");
			builder.append(man.getAnzahlSpieleUnentschieden() + "\t");
			builder.append(man.getAnzahlTore() + ":" + man.getAnzahlToreGegner() + "\t");
			builder.append(man.getAnzahlSpiele());
			builder.append("\n");

		}
		System.out.println(builder.toString());

	}

}
