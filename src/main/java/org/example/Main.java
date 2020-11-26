package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static boolean exit = true;
    private static int number;

    public static void main(String[] args) {
        fillContactList();

        System.out.println("\n| KONTAKTER |");
        ContactManagement.showContacts();

        while (exit) {
            menu();
        }
    }

    private static void userInput() {
        boolean loop = true;

        while (loop) {
            System.out.print("\nAnge en siffra: ");

            try {
                number = sc.nextInt();
                loop = false;
            } catch (InputMismatchException e) {
                System.out.println("\nOGILTIG INMATNING, ANGE EN SIFFRA!");
            }
            sc.nextLine();
        }
    }

    public static void menu() {

        System.out.println("\n---------");
        System.out.println("\n1. Visa");
        System.out.println("2. Lägg till");
        System.out.println("3. Ta bort");
        System.out.println("4. Sök");
        System.out.println("\n0. Stäng ner");

        userInput();

        switch (number) {
            case 0:
                Main.exit = false;
                System.out.println("Kontaktlista nedstängd!");
                break;
            case 1:
                System.out.println("\n---------");
                System.out.println("\n| KONTAKTER |");
                ContactManagement.showContacts();
                menu();
                break;
            case 2:
                System.out.print("\nFörnamn: ");
                String firstName = sc.nextLine();
                System.out.print("Efternamn: ");
                String lastName = sc.nextLine();
                System.out.print("\nKontakt ID (2 första och sista" +
                        "\nbokstäverna i för- och efternamn" +
                        "\nsamt födelseår): ");
                String contactID = sc.nextLine();

                Contact c = new Contact(firstName, lastName, contactID);
                ContactManagement.addContact(c);
                break;
            case 3:
                System.out.print("\nAnge kontakt ID: ");
                String contactIDRemove = sc.nextLine();
                ContactManagement.removeContact(contactIDRemove);
                break;
            case 4:
                System.out.println("\n---------");
                System.out.println("\nVill du söka på för- eller efternamn?");
                System.out.println("1. Förnamn");
                System.out.println("2. Efternamn");

                userInput();
                switch (number) {
                    case 1:
                        System.out.print("\nAnge förnamn: ");
                        String firstNameSearch = sc.nextLine();
                        ContactManagement.searchFirstName(firstNameSearch);
                        break;
                    case 2:
                        System.out.print("\nAnge Efternamn: ");
                        String lastNameSearch = sc.nextLine();
                        ContactManagement.searchLastName(lastNameSearch);
                        break;
                    default:
                        System.out.println("\nOGILTIG INMATNING!!");
                        break;
                }

                break;
            default:
                System.out.println("\nOGILTIGT INMATNING!");
                break;
        }
    }


    public static void fillContactList() {
        Contact c1 = new Contact("Youssef", "Al Shadidi", "YOAL91");
        ContactManagement.addContact(c1);
        Contact c2 = new Contact("Youssef", "Efternamn", "Testar förnamn");
        ContactManagement.addContact(c2);
        Contact c3 = new Contact("Förnamn", "Al Shadidi", "Testar efternamn");
        ContactManagement.addContact(c3);
    }
}
