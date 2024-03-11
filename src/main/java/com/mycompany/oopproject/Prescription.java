/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopproject;

public class Prescription extends Medicine {
    private static String doctorSpecialization;

    public Prescription(String name, String composition,
            int dose, String doctorSpecialization) {
        super(name, composition, dose);
        setdoctorSpecialization(doctorSpecialization);
    }

    public Prescription(String name, String composition,
            int dose, double price, int quantity,
            String doctorSpecialization) {
        super(name, composition, dose, price, quantity);
        setdoctorSpecialization(doctorSpecialization);
    }

    public void setdoctorSpecialization(String doctorSpecialization) {
        this.doctorSpecialization = doctorSpecialization;
    }

    public String getdoctorSpecialization() {
        return doctorSpecialization;
    }

    public String toString() {
        return ("Prescription: \n" +
                super.toString() + "\n" +
                "doctor specialization: " + getdoctorSpecialization());
    }
}
