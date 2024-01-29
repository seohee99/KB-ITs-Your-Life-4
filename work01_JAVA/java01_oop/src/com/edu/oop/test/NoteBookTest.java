package com.edu.oop.test;

import com.edu.oop.Notebook;

public class NoteBookTest {

	public static void main(String[] args) {
		Notebook n = new Notebook();
		n.brand = "Apple";
		n.price = 3000000;
		n.serialNumber = 1;
		
		n.printNoteBookInfo();

	}

}
