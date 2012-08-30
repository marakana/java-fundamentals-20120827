package com.marakana.addressbook;

public class Phone {
	private final int number;
	private final int extension;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + extension;
		result = prime * result + number;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phone other = (Phone) obj;
		if (extension != other.extension)
			return false;
		if (number != other.number)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Phone [number=" + number + ", extension=" + extension + "]";
	}

}
