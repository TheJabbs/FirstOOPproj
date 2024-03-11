/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopproject;

/**
 *
 * @author johnn
 */
public class Pharmacy {
    private String name;
    private Medicine[] medicines;
    private int overTheCounterQuantity;
    private int prescriptionQuantity;
    private int numberOfMedicines;
    private static int MaxNumberOfMedicines;

    public Pharmacy(String name) {
        setname(name);
        this.overTheCounterQuantity = 0;
        this.prescriptionQuantity = 0;
        this.numberOfMedicines = 0;
        setMaxNumberOfMedicines(100);
        medicines = new Medicine[MaxNumberOfMedicines];
    }

    public void addMedicine(Medicine medicine) {
        boolean available = false;
        for (int i = 0; i < numberOfMedicines; i++) {
            if (medicines[i].equals(medicine)) {
                available = true;
                System.out.println("Medecines already exists "
                        + "in the pharmacy");
            }
        }
        if (!available) {
            medicines[numberOfMedicines] = medicine;
            if (medicine instanceof Prescription)
                prescriptionQuantity += medicines[numberOfMedicines].getquantity();
            else if (medicine instanceof OverTheCounter)
                overTheCounterQuantity += medicines[numberOfMedicines].getquantity();
            numberOfMedicines++;
            System.out.println("New medicine is added successfully");
        } else
            System.out.println("Pharmacy reached the limit "
                    + "of medecine storage");

    }

    public void raisePrises(double percentage) {
        for (int i = 0; i < numberOfMedicines; i++) {
            medicines[i].setprice(medicines[i].getprice() +
                    medicines[i].getprice() * percentage / 100);
        }
    }

    public int[] searchByName(String name) {
        int[] names = new int[numberOfMedicines];
        int count = 0;
        for (int i = 0; i < numberOfMedicines; i++) {
            if (medicines[i].getname().equalsIgnoreCase(name)) {
                names[count] = i;
                count++;
            }
        }
        int[] namesindex = new int[count];
        for (int i = 0; i < count; i++) {
            namesindex[i] = names[i];
        }
        return namesindex;
    }

    public int searchByNameAndDose(String name, int dose) {
        for (int i = 0; i < numberOfMedicines; i++) {
            if (medicines[i].getname().equalsIgnoreCase(name) &&
                    medicines[i].getdose() == dose)
                return i;
        }
        return -1;
    }

    public int[] searchByComposition(String composition) {
        int[] compositions = new int[numberOfMedicines];
        int count = 0;
        for (int i = 0; i < numberOfMedicines; i++) {
            if (medicines[i].getcomposition().equalsIgnoreCase(composition)) {
                compositions[count] = i;
                count++;
            }
        }
        int[] compositionindex = new int[count];
        for (int i = 0; i < count; i++) {
            compositionindex[i] = compositions[i];
        }
        return compositionindex;
    }

    public void sellMedicine(String name, int dose, int quantity) {
        int index = searchByNameAndDose(name, dose);
        if (index >= 0) {
            if (medicines[index].getquantity() >= quantity) {
                medicines[index].setquantity(medicines[index].getquantity() - quantity);
                System.out.println("Selling successful.");
            } else
                System.out.println("There is not enought of that item "
                        + "quantity. Avaible quantity is: "
                        + medicines[index].getquantity());
        } else
            System.out.println("not found");
    }

    public boolean restock(String name, int dose, int quantity) {
        int index = searchByNameAndDose(name, dose);
        if (index >= 0) {
            medicines[index].setquantity(quantity +
                    medicines[index].getquantity());
            return true;
        } else
            return false;
    }

    public Medicine getmedicines(int index) {
        return this.medicines[index];
    }

    public int getprescriptionQuantity() {
        return this.prescriptionQuantity;
    }

    public int getoverTheCounterQuantity() {
        return this.overTheCounterQuantity;
    }

    public int getnumberOfMedicine() {
        return this.numberOfMedicines;
    }

    public int getMaxNumberOfMedicines() {
        return Pharmacy.MaxNumberOfMedicines;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setMaxNumberOfMedicines(int MaxNumberOfMedicines) {
        Pharmacy.MaxNumberOfMedicines = MaxNumberOfMedicines;
    }

    public String getname() {
        return this.name;
    }

    public String toString() {
        return ("Pharmacy: " + this.name + "\n" +
                "Number of Medicines: " + this.numberOfMedicines + "\n" +
                "Over the counter quantity: " + this.overTheCounterQuantity + "\n" +
                "Prescription quantity: " + this.prescriptionQuantity + "\n");
    }
}
