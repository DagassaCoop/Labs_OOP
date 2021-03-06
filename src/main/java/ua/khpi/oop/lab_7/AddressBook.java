package ua.khpi.oop.lab_7;

import ua.khpi.oop.lab_5.StringContainer;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class AddressBook implements Serializable {

    private static final long serialVersionUID = 1L;

    private String lastName;

    private String firstName;

    private String secondName;

    private Date dateOfBirth;

    private StringContainer phoneNumbers;

    private String address;

    private String editDateAndTime;

    public AddressBook() {
        phoneNumbers = new StringContainer();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        editDateAndTime = formatter.format(date);
    }

    public void addPhoneNumber(String number) {
        phoneNumbers.add(number);
    }

    public String getStringDateOfBirth() {
        String resultString;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        resultString = simpleDateFormat.format(dateOfBirth);
        return resultString;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setEditDateAndTime(String editDateAndTime) {
        this.editDateAndTime = editDateAndTime;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public StringContainer getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(StringContainer phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getEditDateAndTime() {
        return editDateAndTime;
    }

    public String getStringPhoneNumbers() {
        final int capacity = 250;
        StringBuilder stringBuilder = new StringBuilder(capacity);
        int i;
        for (i = 0; i < phoneNumbers.size() - 1; i++) {
            stringBuilder.append(phoneNumbers.get(i)).append(", ");
        }
        stringBuilder.append(phoneNumbers.get(i));
        return stringBuilder.toString();
    }

    public String toString() {
        final int capacity = 5000;
        StringBuilder stringBuilder = new StringBuilder(capacity);
        stringBuilder.append("Last name: ").append(lastName).append('\n');
        stringBuilder.append("First name: ").append(firstName).append('\n');
        stringBuilder.append("Middle name: ").append(secondName).append('\n');
        stringBuilder.append("Date of birth: ").append(getStringDateOfBirth()).append('\n');
        stringBuilder.append("Phone numbers: ").append(phoneNumbers.toString()).append('\n');
        stringBuilder.append("Address: ").append(address).append('\n');
        stringBuilder.append("Edit date and time: ").append(editDateAndTime).append('\n');
        return stringBuilder.toString();
    }

    public void setPhoneNumbers(String newPhoneNumbers, String delim) {
        StringTokenizer stringTokenizer = new StringTokenizer(newPhoneNumbers, delim);
        if (!stringTokenizer.hasMoreTokens()) {
            if (!phoneNumbers.isEmpty()) {
                phoneNumbers = new StringContainer();
            }
            return;
        }
        phoneNumbers = new StringContainer();
        while (stringTokenizer.hasMoreTokens()) {
            phoneNumbers.add(stringTokenizer.nextToken());
        }
    }

    public void setEditTime(String timeAndDate) {
        editDateAndTime = timeAndDate;
    }

    public static class Builder {
        private final AddressBook newBook;

        public Builder() {
            newBook = new AddressBook();
        }

        public Builder setFirstName(String firstName) {
            newBook.firstName = firstName;
            return this;
        }

        public Builder setSecondName(String secondName) {
            newBook.secondName = secondName;
            return this;
        }

        public Builder setLastName(String lastName) {
            newBook.lastName = lastName;
            return this;
        }

        public Builder setDateOfBirth(Date birthday) {
            newBook.dateOfBirth = birthday;
            return this;
        }

        public Builder setAddress(String address) {
            newBook.address = address;
            return this;
        }

        public Builder setEditTime(String editTime) {
            newBook.editDateAndTime = editTime;
            return this;
        }

        public Builder setPhoneNumbers(StringContainer phoneNumbers) {
            newBook.phoneNumbers = phoneNumbers;
            return this;
        }

        public AddressBook build() {
            return newBook;
        }
    }
}
