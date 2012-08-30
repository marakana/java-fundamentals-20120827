package com.marakana.addressbook;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
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

	public Set<Person> getPersonContacts() {
		Set<Person> persons = new HashSet<Person>();
		for (Contact contact : contacts) {
			if (contact instanceof Person) {
				persons.add((Person) contact);
			}
		}
		return persons;
	}

	// multimap!!!
	public Map<ZodiacSign, Set<Person>> getPersonsBySign() {

		// initialize an empty map
		Map<ZodiacSign, Set<Person>> persons = new EnumMap<ZodiacSign, Set<Person>>(ZodiacSign.class);

		// for each contact that is a person ...
		for (Person person : getPersonContacts()) {

			// get the person's sign, and get the set of people with that sign
			ZodiacSign sign = person.getSign();
			Set<Person> personsWithSign = persons.get(sign);

			// if there is no set yet, create one and put it in the map
			if (personsWithSign == null) {
				personsWithSign = new HashSet<Person>();
				persons.put(sign, personsWithSign);
			}

			// put the person in the set
			personsWithSign.add(person);
		}
		return persons;
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
