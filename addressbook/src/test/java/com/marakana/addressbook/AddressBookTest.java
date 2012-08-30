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

	@Test
	public void equalPhoneNumbersMustBeEqual() {
		Phone p1 = new Phone(8675309, 0);
		Phone p2 = new Phone(8675309, 0);
		assertEquals(p1, p2);
	}
}
