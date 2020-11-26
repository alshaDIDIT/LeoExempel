package org.example;

public class Contact {
    private String firstName;
    private String lastName;
    private String contactID;

    public Contact(String firstName, String lastName, String contactID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactID = contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getContactID() {
        return contactID;
    }

    @Override
    public String toString() {
        return "\n" + firstName + " " + lastName + "  |ID|: " + contactID;
    }
}
