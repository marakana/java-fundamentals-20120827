package com.marakana.addressbook;

public class Phone {
	private int number;
	private int extension;

	public Phone(int number, int extension) {
		this.number = number;
		this.extension = extension;
	}

	public int getNumber() {
		return number;
	}

	public int getExtension() {
		return extension;
	}

}
