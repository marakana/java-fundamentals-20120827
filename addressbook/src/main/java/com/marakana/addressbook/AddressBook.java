package com.marakana.addressbook;

import java.util.List;
import java.util.NoSuchElementException;

public class AddressBook {
	private List<Contact> contacts;

	public Contact find(String name) {
		for (Contact contact : contacts) {
			if (contact.getName() == name) {
				return contact;
			}
		}
		throw new NoSuchElementException();
	}

	public void add(Contact contact) {
		
	}
}
