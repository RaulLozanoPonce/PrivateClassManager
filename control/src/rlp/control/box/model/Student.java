package rlp.control.box.model;

public class Student {

    private String surname;
    private String name;
    private double hourPrize;
    private long phone;
    private String email;
    private double balance;

    public Student(String surname, String name, double hourPrize, long phone, String email) {
        this.surname = surname;
        this.name = name;
        this.hourPrize = hourPrize;
        this.phone = phone;
        this.email = email;
        this.balance = 0;
    }
}
