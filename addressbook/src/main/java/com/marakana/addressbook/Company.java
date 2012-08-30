package com.marakana.addressbook;

import java.util.HashMap;
import java.util.Map;

public class Company implements Contact {

	private final String name;
	private final Map<String, Address> addresses = new HashMap<String, Address>();
	private final Map<String, Phone> phoneNumbers = new HashMap<String, Phone>();

	public Company(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Address getAddress(String label) {
		return addresses.get(label);
	}

	@Override
	public Phone getPhoneNumber(String label) {
		return phoneNumbers.get(label);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Company other = (Company) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Company [name=" + name + ", addresses=" + addresses
				+ ", phoneNumbers=" + phoneNumbers + "]";
	}

}
