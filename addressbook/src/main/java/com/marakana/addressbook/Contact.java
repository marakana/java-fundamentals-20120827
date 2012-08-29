package com.marakana.addressbook;

public interface Contact {
	String getName();

	Address getAddress(String label);

	Phone getPhoneNumber(String label);
}
