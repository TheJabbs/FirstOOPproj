package com.mycompany.oopproject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

import java.util.Scanner;

public class App {
    
//    public App(){
//        System.out.print("poop");
//    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String name;
        String composition;
        String doctor;
        Medicine Medicine;
        Pharmacy pharm = new Pharmacy("My Pharmacy");
        char type;
        int number = 0;
        int dose;
        int quantity;
        int minAge = 0;
        double price;
        int[] array;

        System.out.println("Welcome to \" " + pharm.getname()
                + " \" pharmacy system.");
        System.out.print("-----------------------------------------------\n");
        while (number != 8) {
            number = menu();
            if (number <= 0 && number > 8) {
                System.out.print("Enter a valid number.");
                continue;
            }
            if (number == 8)
                break;
            switch (number) {
                case 1:
                    System.out.print("\nEnter the information of the"
                            + " new medicine:\n\nChoose O or o for over "
                            + "the counter medicine and p or P for \n" +
                            "prescription medicine: ");
                    do {
                        type = sc.next().charAt(0);
                    } while (type != 'o' && type != 'O' && type != 'p' && type != 'P');
                    if (type == 'o' || type == 'O') {
                        sc.nextLine();
                        System.out.print("name: ");
                        name = sc.nextLine();
                        System.out.print("composition: ");
                        composition = sc.nextLine();
                        System.out.print("dose: ");
                        dose = sc.nextInt();
                        System.out.print("quantity: ");
                        quantity = sc.nextInt();
                        System.out.print("price: ");
                        price = sc.nextDouble();
                        System.out.print("Enter the minimum Age "
                                + "for this medicine: ");
                        do {
                            minAge = sc.nextInt();
                        } while (minAge <= 0);
                        Medicine = new OverTheCounter(name, composition, dose,
                                price, quantity, minAge);
                        pharm.addMedicine(Medicine);
                        System.out.println();
                        System.out.print("-----------------------------------------------\n");
                        System.out.println();
                    }
                    if (type == 'p' || type == 'P') {
                        sc.nextLine();
                        System.out.print("name: ");
                        name = sc.nextLine();
                        System.out.print("composition: ");
                        composition = sc.nextLine();
                        System.out.print("dose: ");
                        dose = sc.nextInt();
                        System.out.print("quantity: ");
                        quantity = sc.nextInt();
                        System.out.print("price: ");
                        price = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Enter the doctor "
                                + "specialization: ");
                        doctor = sc.nextLine();
                        Medicine = new Prescription(name, composition, dose,
                                price, quantity, doctor);
                        pharm.addMedicine(Medicine);
                        System.out.println();
                        System.out.print("-----------------------------------------------\n");
                        System.out.println();
                    }
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Enter the name of the medicine"
                            + " to be found: ");
                    name = sc.nextLine();
                    array = pharm.searchByName(name);
                    System.out.println(array.length + " medicine found matching "
                            + "this name.");
                    for (int i = 0; i < array.length; i++)
                        System.out.println((i + 1) + "- "
                                + pharm.getmedicines(array[i]).toString());
                    System.out.println();
                    System.out.print("-----------------------------------------------\n");
                    System.out.println();
                    break;

                case 3:
                    sc.nextLine();
                    System.out.print("Enter the composition to be found: ");
                    composition = sc.nextLine();
                    array = pharm.searchByComposition(composition);
                    System.out.print(array.length + " medicine found matching "
                            + "this composition.");
                    for (int i = 0; i < array.length; i++)
                        System.out.println((i + 1) + "- "
                                + pharm.getmedicines(array[i]).toString());
                    System.out.println();
                    System.out.print("-----------------------------------------------\n");
                    System.out.println();
                    break;

                case 4:
                    sc.nextLine();
                    System.out.print("Enter the name of the medicine: ");
                    name = sc.nextLine();
                    System.out.print("Enter the dose: ");
                    dose = sc.nextInt();
                    System.out.print("Enter the quantity: ");
                    quantity = sc.nextInt();
                    pharm.sellMedicine(name, dose, quantity);
                    System.out.println();
                    System.out.print("-----------------------------------------------\n");
                    System.out.println();
                    break;

                case 5:
                    sc.nextLine();
                    System.out.print("Enter the name of the medicine: ");
                    name = sc.nextLine();
                    System.out.print("Enter the dose: ");
                    dose = sc.nextInt();
                    System.out.print("Enter the quantity: ");
                    quantity = sc.nextInt();
                    if (pharm.restock(name, dose, quantity))
                        System.out.print("Restock successful");
                    else
                        System.out.print("An error has occured please make "
                                + "sure the medicine already "
                                + "exists in the pharmacy");
                    System.out.println();
                    System.out.print("-----------------------------------------------\n");
                    System.out.println();
                    break;

                case 6:
                    for (int i = 0; i < pharm.getnumberOfMedicine(); i++) {
                        System.out.println("Medecine " + (i + 1) + " : "
                                + pharm.getmedicines(i).toString());
                        System.out.println((pharm.getnumberOfMedicine() > 1 ? "-----" : ""));
                    }
                    System.out.println();
                    System.out.print("-----------------------------------------------\n");
                    System.out.println();
                    break;

                case 7:
                    System.out.print("\n" + pharm.toString());
                    System.out.println();
                    System.out.print("-----------------------------------------------\n");
                    System.out.println();
                    break;
            }
        }
    }

    public static int menu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose one of the following options:\n" +
                "1- Add a new medicine\n" +
                "2- Search for a medicine by name\n" +
                "3- Search for a medicine by composition\n" +
                "4-  Sell a medicine\n" +
                "5- Restock a medicine\n" +
                "6- Display all medicines\n" +
                "7- Display information\n" +
                "8- Exist\n\n" +
                "Enter your choice (between 1 and 8): ");
        return sc.nextInt();
    }
}
