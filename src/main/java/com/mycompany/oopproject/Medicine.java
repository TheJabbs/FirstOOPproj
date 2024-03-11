/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopproject;

/**
 *
 * @author johnn
 */
public class Medicine {
    private String name;
    private String composition;
    private int dose;
    private double price;
    private int quantity;

    public Medicine(String name, String composition, int dose) {
        this(name, composition, dose, 10, 0);
    }

    public Medicine(String name, String composition, int dose,
            double price, int quantity) {
        setname(name);
        setcomposition(composition);
        setdose(dose);
        setprice(price);
        setquantity(quantity);
    }

    public String getname() {
        return this.name;
    }

    public void setname(String name) {
        this.name = name.toLowerCase();
    }

    public String getcomposition() {
        return this.composition;
    }

    public void setcomposition(String composition) {
        this.composition = composition.toLowerCase();
    }

    public int getdose() {
        return this.dose;
    }

    public void setdose(int dose) {
        if (dose > 0)
            this.dose = dose;
        else
            this.dose = 1000;
    }

    public double getprice() {
        return this.price;
    }

    public void setprice(double price) {
        if (price > 0)
            this.price = price;
        else
            this.price = 10;
    }

    public int getquantity() {
        return this.quantity;
    }

    public void setquantity(int quantity) {
        if (quantity > 0)
            this.quantity = quantity;
        else
            this.quantity = 0;
    }

    public String toString() {
        return ("name: " + this.name + "\n" +
                "composition: " + this.composition + "\n" +
                "dose: " + this.dose + "mg\n" +
                "price: " + this.price + "\n" +
                "quantity: " + this.quantity);
    }

    public boolean equals(Object object) {
        if (this == object)
            return true;
        else {
            if (object instanceof Medicine)
                return (this.name == ((Medicine) object).name &&
                        this.dose == ((Medicine) object).dose);
            else
                return false;
        }
    }
}
