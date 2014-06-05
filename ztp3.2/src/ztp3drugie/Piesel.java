package ztp3drugie;

import java.io.Serializable;

public class Piesel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2655586584575630556L;
	private String imie;
	private boolean czySzczepiony;

	public Piesel(String imie, boolean szcz) {
		this.imie = imie;
		this.czySzczepiony = szcz;
	}

}
