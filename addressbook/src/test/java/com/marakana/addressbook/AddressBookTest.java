package com.marakana.addressbook;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddressBookTest {

	@Test
	public void test() {
		Person dan = new Person("Dan", "Rosen");
		AddressBook contacts = new AddressBook();
		contacts.add(dan);
		contacts.find("Dan Rosen");
	}

}
