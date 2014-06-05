package ztp3drugie;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class test {

	/**
	 * @param args
	 */

	public static void main(String[] args) {

		// obiekty
		ArrayList<Osoba> testowa = new ArrayList<Osoba>();
		for (int i = 1; i < 10; i++) {
			testowa.add(new Osoba("a", "b", i));
		}

		Osoba janek = new Osoba("Janek", "Kowalski", 2500);
		Osoba janekKopia = null;

		// kopia serializacja
		long start = System.nanoTime();
		try {
			janekKopia = (Osoba) kopia(janek);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		long czasKopii = System.nanoTime() - start;
		// kopia clone

		start = System.nanoTime();
		Osoba janekClone = (Osoba) janek.clone();
		long czasClona = System.nanoTime() - start;

		// zmiana
		janekKopia.setImie("Zmienilem kopie");
		janekClone.setImie("Zmienilem clona");

		// wyniki
		System.out.println("obiekt oryginal " + janek);
		System.out.println("obiekt kopia " + janekKopia);
		System.out.println("obiekt clone " + janekClone);
		System.out.println("Czas kopii: " + czasKopii);
		System.out.println("Czas clona: " + czasClona + "\n");

		// kolekcje

		// kopia newArray
		start = System.nanoTime();
		ArrayList<Osoba> kopiaNewArray = new ArrayList<Osoba>(testowa);
		long czasNewArray = System.nanoTime() - start;

		// kopia Clone kolekcji
		start = System.nanoTime();
		ArrayList<Osoba> kopiaClone = (ArrayList<Osoba>) testowa.clone();
		long czasArrayClone = System.nanoTime() - start;

		// kopia Clone kolekcji - glebokie
		start = System.nanoTime();
		ArrayList<Osoba> kopiaCloneKazdego = cloneKolekcji(testowa);
		long czasArrayCloneKazdego = System.nanoTime() - start;

		// zmiany w kolekcji

		kopiaClone.get(1).setImie("Zmienilem clone");
		kopiaNewArray.get(2).setImie("Zmienilem new array");
		kopiaCloneKazdego.get(3).setImie("Zmienilem clone kazdego");

		// wyniki kolekcji
		// System.out.println("oryginal " + testowa);
		// System.out.println("kopia Clone" + kopiaClone);
		// System.out.println("kopia NewArray " + kopiaNewArray);
		// System.out.println("kopia clone kazdego " + kopiaCloneKazdego);
		System.out.println("Czas clone array: " + czasArrayClone);
		System.out.println("Czas newArray: " + czasNewArray);
		System.out.println("Czas clone kazdego w kolekcji: "
				+ czasArrayCloneKazdego);

	}

	public static Object kopia(Object obj) throws IOException,
			ClassNotFoundException {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(obj);

		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);
		Object result = ois.readObject();
		return result;
	}

	public static ArrayList<Osoba> cloneKolekcji(ArrayList<Osoba> kolekcja) {
		ArrayList<Osoba> result = new ArrayList<Osoba>();
		for (Osoba o : kolekcja) {
			result.add((Osoba) o.clone());
		}
		return result;
	}
}
