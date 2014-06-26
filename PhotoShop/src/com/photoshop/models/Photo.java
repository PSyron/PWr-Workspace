package com.photoshop.models;

import java.io.Serializable;

public class Photo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4849602742651324372L;
	private String mName;
	private String mDescribe;
	private double mPrice;
	private int mImageID;

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmDescribe() {
		return mDescribe;
	}

	public void setmDescribe(String mDescribe) {
		this.mDescribe = mDescribe;
	}

	public double getmPrice() {
		return mPrice;
	}

	public void setmPrice(double mPrice) {
		this.mPrice = mPrice;
	}

	public int getmImageID() {
		return mImageID;
	}

	public void setmImageID(int mImageID) {
		this.mImageID = mImageID;
	}

	public Photo(String mName, String mDescribe, double mPrice, int mImageID) {

		this.mName = mName;
		this.mDescribe = mDescribe;
		this.mPrice = mPrice;
		this.mImageID = mImageID;
	}

}
