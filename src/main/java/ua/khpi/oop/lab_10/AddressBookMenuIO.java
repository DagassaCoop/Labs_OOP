package ua.khpi.oop.lab_10;

import ua.khpi.oop.lab_7.AddressBook;

import java.text.ParseException;

public interface AddressBookMenuIO {
    int getMenuChoice();

    AddressBook getAddressBook() throws ParseException;

    int getIndexOfBook();

    void printAddressBook(AddressBook book);

    void print(String string);

    int getSortChoice();

    int getOperatorChoice();

    int getMenuCollectionChoice();
}
