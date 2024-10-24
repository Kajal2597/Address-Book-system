package com.addressregx;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class AddressBook {
    private ArrayList<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
    }

    // Add a contact
    public void addContact(Contact contact) {
        if (isValidPhoneNumber(contact.getPhoneNumber()) && isValidEmail(contact.getEmail())) {
            contacts.add(contact);
            System.out.println("Contact added successfully.");
        } else {
            System.out.println("Invalid phone number or email. Contact not added.");
        }
    }

    // Delete a contact
    public void deleteContact(String name) {
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contacts.remove(contact);
                System.out.println("Contact deleted successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    // Update a contact
    public void updateContact(String name) {
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter new phone number: ");
                String phoneNumber = scanner.nextLine();
                System.out.print("Enter new email: ");
                String email = scanner.nextLine();

                if (isValidPhoneNumber(phoneNumber) && isValidEmail(email)) {
                    contact.setPhoneNumber(phoneNumber);
                    contact.setEmail(email);
                    System.out.println("Contact updated successfully.");
                } else {
                    System.out.println("Invalid phone number or email. Contact not updated.");
                }
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }
    // Display all contacts
    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    // Validate phone number using Regex
    private boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "^[6-9]{2}[0-9]{8}$";  // Example: 1234567890 (10 digits)
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    // Validate email using Regex
    private boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";  // Example: example@domain.com
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
