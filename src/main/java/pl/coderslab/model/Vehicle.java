package pl.coderslab.model;

import java.time.Year;
import java.util.Date;

public class Vehicle {
    private int id;
    private String model;
    private String brand;
    private Year productionYear;
    private String plateNumber;
    private Date nextInspectionDate;
    private Customer customer;

    public Vehicle(int id, String model, String brand, Year productionYear, String plateNumber, Date nextInspectionDate, Customer customer) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.productionYear = productionYear;
        this.plateNumber = plateNumber;
        this.nextInspectionDate = nextInspectionDate;
        this.customer = customer;
    }

    public Vehicle(String model, String brand, Year productionYear, String plateNumber, Date nextInspectionDate, Customer customer) {
        this.model = model;
        this.brand = brand;
        this.productionYear = productionYear;
        this.plateNumber = plateNumber;
        this.nextInspectionDate = nextInspectionDate;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Year getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Year productionYear) {
        this.productionYear = productionYear;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Date getNextInspectionDate() {
        return nextInspectionDate;
    }

    public void setNextInspectionDate(Date nextInspectionDate) {
        this.nextInspectionDate = nextInspectionDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", productionYear=" + productionYear +
                ", plateNumber='" + plateNumber + '\'' +
                ", nextInspectionDate=" + nextInspectionDate +
                ", customer=" + customer +
                '}';
    }
}
