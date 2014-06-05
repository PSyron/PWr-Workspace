public class Main {

	public static void main(String[] args) {

		MaNizszaPensje zarabiaMalo = new MaNizszaPensje(1800);
		MaWyzszaPensje zarabiaDuzo = new MaWyzszaPensje(2200);
		JestMlodszy nieJestStary = new JestMlodszy(40);
		JestStarszy jestPelnoletni = new JestStarszy(18);
		JestOplacalny jestOplacalny = new JestOplacalny(2200, 100);
		WykorzystujeUrlop obijaSie = new WykorzystujeUrlop(5);

		Pracownik marcin = new Pracownik("Marcin", "Kowalski", 87121015427L,
				2100, 27);
		Pracownik jurek = new Pracownik("Jerzy", "Nowak", 78542210154L, 3200,
				61);
		Pracownik pawel = new Pracownik("Paweł", "Cyron", 92112103533L, 1666,
				22);
		Pracownik gawel = new Pracownik("Gaweł", "Oryginalny", 12345603533L,
				750, 40);

		marcin.setLiczbaSprzedazy(144);
		marcin.bierzeUrlop(1);

		jurek.setLiczbaSprzedazy(255);
		jurek.bierzeUrlop(3);
		jurek.bierzeUrlop(3);

		pawel.setLiczbaSprzedazy(33);

		Pracownik[] pracownicy = { marcin, jurek, pawel, gawel };

		for (Pracownik pracus : pracownicy) {
			System.out.println();
			System.out.println(pracus.toString());
			System.out.println("Zarabia za malo: "
					+ zarabiaMalo.isSatisfiedBy(pracus));
			System.out.println("Zarabia za duzo: "
					+ zarabiaDuzo.isSatisfiedBy(pracus));
			System.out.println("Jest mlody: "
					+ nieJestStary.isSatisfiedBy(pracus));
			System.out.println("Jest pelnoletni: "
					+ jestPelnoletni.isSatisfiedBy(pracus));
			System.out.println("Oplaca sie: "
					+ jestOplacalny.isSatisfiedBy(pracus));
			System.out.println("Obija sie w pracy: "
					+ obijaSie.isSatisfiedBy(pracus));
		}

	}

}
