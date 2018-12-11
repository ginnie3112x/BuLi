package loeckmann.buli;

import java.util.Iterator;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) {
		Spieler spieler1 = new Spieler("Spieler1");
		Spieler spieler2 = new Spieler("Spieler2");
		Spieler spieler3 = new Spieler("Spieler3");
		Spieler spieler4 = new Spieler("Spieler4");
		Spieler spieler5 = new Spieler("Spieler5");
		Spieler spieler6 = new Spieler("Spieler6");
		Spieler spieler7 = new Spieler("Spieler7");
		Spieler spieler8 = new Spieler("Spieler8");
		Spieler spieler9 = new Spieler("Spieler9");
		Spieler spieler10 = new Spieler("Spieler10");
		Spieler spieler11 = new Spieler("Spieler11");
		Spieler spieler12 = new Spieler("Spieler12");
		Spieler spieler13 = new Spieler("Spieler13");
		Spieler spieler14 = new Spieler("Spieler14");
		Spieler spieler15 = new Spieler("Spieler15");
		Spieler spieler16 = new Spieler("Spieler16");

		Mannschaft man1 = new Mannschaft("Mannschaft1");
		Mannschaft man2 = new Mannschaft("Mannschaft2");
		Mannschaft man3 = new Mannschaft("Mannschaft3");
		Mannschaft man4 = new Mannschaft("Mannschaft4");
		Mannschaft man5 = new Mannschaft("Mannschaft5");

		Tabelle.getMannschaftsliste().add(man1);
		Tabelle.getMannschaftsliste().add(man2);
		Tabelle.getMannschaftsliste().add(man3);
		Tabelle.getMannschaftsliste().add(man4);

		man1.addSpieler(spieler1);
		man1.addSpieler(spieler2);
		man2.addSpieler(spieler3);
		man2.addSpieler(spieler4);
		man3.addSpieler(spieler5);
		man3.addSpieler(spieler6);
		man4.addSpieler(spieler7);
		man4.addSpieler(spieler8);

		Spieltag spieltag = new Spieltag(1);

		Begegnung b1 = spieltag.newBegegnung(man1, man2);
		Begegnung b2 = spieltag.newBegegnung(man2, man1);
		Begegnung b4 = spieltag.newBegegnung(man3, man4);

		Spieltag spieltag2 = new Spieltag(2);
		Begegnung b3 = spieltag2.newBegegnung(man1, man4);

		spieltag.addBegegnungToResulttable(b1, 2, 5);
		spieltag.addBegegnungToResulttable(b2, 8, 5);
		spieltag.addBegegnungToResulttable(b4, 1, 1);
//		spieltag2.addBegegnungToResulttable(b3,1,1);
		// spieler2.torEingeben("52",b1);
//		spieler2.torEingeben("53");
//		man1.torEingeben(spieler1, "33");//Problem einmalwert
	
		Tabelle.printGesamttabelle();
		Tabelle.printTabelleBegegnungen();
		
		for(Mannschaft m : Tabelle.getMannschaftsliste())
			System.out.println(m.getName());
		
		
		System.out.println("Größe der Mannschaftsliste " + Tabelle.getMannschaftsliste().size());
		System.out.println("Größe der Tabellenliste " + Tabelle.getListe().size());
		System.out.println("Größe der resultliste " + spieltag.getResult().size());
		System.out.println("Größe der resultliste " + spieltag2.getResult().size());

		// Problemstellung: obwohle Begegnung die die gleichen Hashwerte hat, nimmt die
		// TreeMap diese nicht als gleich wahr. man1,man2 - man2, man1
//		System.out.println(b1.equals(b2));
//		System.out.println(b1.toString());
//		System.out.println(b2.toString());
//		System.out.println(b1.equals(b4));
//		System.out.println(b4.toString());
//		System.out.println("Hash " + b1.hashCode());
//		System.out.println("Hash " + b2.hashCode());
//		System.out.println("Hash " + b4.hashCode());
//		for (Iterator<Entry<Begegnung, Ergebnis>> iterator = spieltag.getResult().entrySet().iterator(); iterator.hasNext();) {
//			
//			Entry<Begegnung, Ergebnis> n = iterator.next();
//			System.out.println("Hash "+n.hashCode());
//			System.out.println("K,V,"+n.getKey()+" "+n.getValue());
//			System.out.println("Spiel "+n.getKey().getSpiel());
//			
//			
//		}

	}

}
