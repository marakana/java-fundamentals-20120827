package com.marakana.addressbook;

import java.util.HashMap;
import java.util.Map;

public class Company implements Contact {

	private String name;
	private Map<String, Address> addresses = new HashMap<String, Address>();
	private Map<String, Phone> phoneNumbers = new HashMap<String, Phone>();

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

}
