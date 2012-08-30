package com.marakana.addressbook;

import java.util.HashMap;
import java.util.Map;

public class Person implements Contact {

	private final String firstName;
	private final String lastName;
	private final Map<String, Address> addresses = new HashMap<String, Address>();
	private final Map<String, Phone> phoneNumbers = new HashMap<String, Phone>();

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String getName() {
		return firstName + " " + lastName;
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
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
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
		Person other = (Person) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName
				+ ", addresses=" + addresses + ", phoneNumbers=" + phoneNumbers
				+ "]";
	}

}
