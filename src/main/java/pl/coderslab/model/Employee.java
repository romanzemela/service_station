package pl.coderslab.model;


import java.math.BigDecimal;

public class Employee {

    private int id;
    private String name;
    private String surname;
    private String address;
    private int phone;
    private String note;
    private BigDecimal rate;

    public Employee(int id, String name, String surname, String address, int phone, String note, BigDecimal rate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.note = note;
        this.rate = rate;
    }

    public Employee(String name, String surname, String address, int phone, String note, BigDecimal rate) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.note = note;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String text) {
        this.note = text;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", note='" + note + '\'' +
                ", rate=" + rate +
                '}';
    }

}

