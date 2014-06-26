package com.photoshop.models;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8500330229924853531L;
	private ArrayList<Photo> mBasket;
	private String mName;
	private String mPassword;

	public ArrayList<Photo> getmBasket() {
		return mBasket;
	}

	public void setmBasket(ArrayList<Photo> mBasket) {
		this.mBasket = mBasket;
	}

	public String getmName() {
		return mName;
	}

	public User(ArrayList<Photo> mBasket, String mName, String mPassword) {

		this.mBasket = mBasket;
		this.mName = mName;
		this.mPassword = mPassword;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmPassword() {
		return mPassword;
	}

	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}

	public void addItemToBasket(Photo photo) {
		mBasket.add(photo);
	}

	public void removerItemFromBasket(int index) {
		mBasket.remove(index);
	}

	public int getPriceSum() {
		int TotalPrice = 0;
		for (Photo ph : mBasket) {
			TotalPrice += ph.getmPrice();
		}
		return TotalPrice;
	}

}
