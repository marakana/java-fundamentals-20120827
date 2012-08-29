package com.marakana.addressbook;

import java.util.Map;

public class Company implements Contact {

	private String name;
	private Map<String, Address> addresses;
	private Map<String, Phone> phoneNumbers;

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

}
