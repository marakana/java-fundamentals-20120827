package com.marakana.addressbook;

import java.util.Map;

public class Person implements Contact {

	private String firstName;
	private String lastName;
	private Map<String, Address> addresses;
	private Map<String, Phone> phoneNumbers;

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

}
