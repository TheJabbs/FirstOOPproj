/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopproject;

/**
 *
 * @author johnn
 */
public class OverTheCounter extends Medicine {
    private static int minAge;

    public OverTheCounter(String name, String composition, int dose, int minAge) {
        super(name, composition, dose);
        setminAge(minAge);
    }

    public OverTheCounter(String name, String composition, int dose,
            double price, int quantity, int minAge) {
        super(name, composition, dose, price, quantity);
        setminAge(minAge);
    }

    public int getminAge() {
        return OverTheCounter.minAge;
    }

    public void setminAge(int minAge) {
        if (minAge > 0)
            OverTheCounter.minAge = minAge;
        else
            OverTheCounter.minAge = 18;
    }

    public String toString() {
        return ("Over the Counter: \n" +
                super.toString() + "\n" +
                "minimum Age: " + OverTheCounter.minAge);
    }
}
