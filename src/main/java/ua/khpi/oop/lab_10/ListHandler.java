package ua.khpi.oop.lab_10;

import ua.khpi.oop.lab_7.AddressBook;
import ua.khpi.oop.lab_9.ListContainer;
import ua.khpi.oop.lab_12.OperatorHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Date;

public class ListHandler {

    public static Comparator<ListContainer.Node<AddressBook>> FIRST_NAME_COMPARATOR =
            Comparator.comparing(addressBookNode -> addressBookNode.getValue().getFirstName());

    public static Comparator<ListContainer.Node<AddressBook>> LAST_NAME_COMPARATOR =
            Comparator.comparing(addressBookNode -> addressBookNode.getValue().getLastName());


    public static Comparator<ListContainer.Node<AddressBook>> BIRTH_DATE_COMPARATOR =
            Comparator.comparing(addressBookNode -> addressBookNode.getValue().getDateOfBirth());

    public static  Comparator<ListContainer.Node<AddressBook>> EDIT_DATE_TIME_COMPARATOR =
            Comparator.comparing(addressBookNode -> addressBookNode.getValue().getEditDateAndTime());

    private final AddressBookMenuIO io;

    private SortListContainer<AddressBook> sort;

    private final ListContainer<AddressBook> list;

    public ListHandler() {
        io = new ListMenuIO();
        sort = null;
        list = new ListContainer<>();
    }

    public ListHandler(ListContainer<AddressBook> list) {
        this.list = list;
        io = new ListMenuIO();
        sort = null;
    }

    public void dialogMode() {
        OperatorHandler operatorHandler = new OperatorHandler();
        System.out.println("List is ready!");
        while (true) {
            int choice = io.getMenuChoice();

            if (choice == 9) {
                System.out.println("Goodbye");
                break;
            }

            if (choice < 1 || choice > 8) {
                System.out.println("Invalid input data!");
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        AddressBook addressBook = io.getAddressBook();
                        if (addressBook != null) {
                            list.add(addressBook);
                        }
                    } catch (ParseException e) {
                        System.out.println("Failed to parse data!");
                    }
                    break;
                case 2:
                    list.remove(io.getIndexOfBook());
                    break;
                case 3:
                    io.printAddressBook(list.get(io.getIndexOfBook()));
                    break;
                case 4:
                    io.print(list.toString());
                    break;
                case 5:
                    list.clear();
                    break;
                case 6:
                    io.print("Size: " + list.size());
                    break;
                case 7:
                    int sortChoice = io.getSortChoice();
                    if (sortChoice == 0) {
                        System.out.println("Invalid input data!");
                        break;
                    }
                    switch (sortChoice) {
                        case 1:
                            sort = new SortListContainer<>(FIRST_NAME_COMPARATOR);
                            list.setHead(sort.sort(list.getHead()));
                            break;
                        case 2:
                            sort = new SortListContainer<>(LAST_NAME_COMPARATOR);
                            list.setHead(sort.sort(list.getHead()));
                            break;
                        case 3:
                            sort = new SortListContainer<>(BIRTH_DATE_COMPARATOR);
                            list.setHead(sort.sort(list.getHead()));
                            break;
                        case 4:
                            sort = new SortListContainer<>(EDIT_DATE_TIME_COMPARATOR);
                            list.setHead(sort.sort(list.getHead()));
                            break;
                    }
                    break;
                case 8:
                    int operator = io.getOperatorChoice();
                    switch (operator) {
                        case 1:
                            io.print(operatorHandler.getKyivStarUsers(list).toString());
                            break;
                        case 2:
                            io.print(operatorHandler.getLifeCellUsers(list).toString());
                            break;
                    }
            }
        }
    }

    public void autoMode() throws ParseException {
        ListContainer<AddressBook> list = new ListContainer<>();
        AddressBook addressBook1;
        AddressBook addressBook2;
        AddressBook addressBook3;
        AddressBook addressBook4;
        LocalDateTime now = LocalDateTime.now();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = simpleDateFormat.parse("2009-12-31");

        addressBook1 = new AddressBook.Builder()
                .setFirstName("Bob")
                .setLastName("First surname")
                .setSecondName("First second name")
                .setAddress("Address1")
                .setDateOfBirth(date1)
                .setEditTime(now.toString())
                .build();

        addressBook1.addPhoneNumber("9825792");
        addressBook1.addPhoneNumber("3928729");


        Date date2 = simpleDateFormat.parse("1980-10-20");
        addressBook2 = new AddressBook.Builder()
                .setFirstName("Alex")
                .setLastName("Second surname")
                .setSecondName("Second second name")
                .setAddress("Address2")
                .setDateOfBirth(date2)
                .setEditTime(now.plusDays(3).toString())
                .build();

        addressBook2.addPhoneNumber("290302");
        addressBook2.addPhoneNumber("0978431");

        Date date3 = simpleDateFormat.parse("2000-09-23");
        addressBook3 = new AddressBook.Builder()
                .setFirstName("Dort")
                .setLastName("Armis")
                .setSecondName("Alfred")
                .setAddress("Address3")
                .setDateOfBirth(date3)
                .setEditTime(now.minusHours(72).toString())
                .build();
        addressBook3.addPhoneNumber("74744798");

        Date date4 = simpleDateFormat.parse("2000-11-17");
        addressBook4 = new AddressBook.Builder()
                .setFirstName("Dmitriy")
                .setLastName("Bondar")
                .setSecondName("Olegovich")
                .setAddress("address4")
                .setDateOfBirth(date4)
                .setEditTime(now.plusMonths(2).toString())
                .build();
        addressBook4.addPhoneNumber("0500709125");

        list.add(addressBook1);
        list.add(addressBook2);
        list.add(addressBook3);
        list.add(addressBook4);

        io.print(list.toString());
    }
}
