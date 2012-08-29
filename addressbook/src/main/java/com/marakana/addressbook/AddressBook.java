package com.marakana.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class AddressBook {
	private List<Contact> contacts = new ArrayList<Contact>();

	public Contact find(String name) {
		for (Contact contact : contacts) {
			if (contact.getName().equals(name)) {
				return contact;
			}
		}
		throw new NoSuchElementException();
	}

	public void add(Contact contact) {
		contacts.add(contact);
	}
}
