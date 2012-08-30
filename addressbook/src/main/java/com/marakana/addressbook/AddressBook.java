package com.marakana.addressbook;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class AddressBook {
	private final Set<Contact> contacts = new HashSet<Contact>();

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((contacts == null) ? 0 : contacts.hashCode());
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
		AddressBook other = (AddressBook) obj;
		if (contacts == null) {
			if (other.contacts != null)
				return false;
		} else if (!contacts.equals(other.contacts))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AddressBook [contacts=" + contacts + "]";
	}

}
