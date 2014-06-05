public class JestOplacalny implements Specification<Pracownik> {

	int sprzedaz;
	double pensja;

	public JestOplacalny(double pensja, int s) {
		this.pensja = pensja;
		sprzedaz = s;
	}

	@Override
	public boolean isSatisfiedBy(Pracownik t) {
		MaNizszaPensje zarabiaMalo = new MaNizszaPensje(pensja);

		if (t != null && t.liczbaSprzedazy > sprzedaz
				&& zarabiaMalo.isSatisfiedBy(t))
			return true;
		return false;
	}
}
