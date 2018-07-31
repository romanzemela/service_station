package pl.coderslab.model;

import java.time.Year;
import java.util.Date;

public class Vehicle {
    private int id;
    private String model;
    private String brand;
    private Year production_year;
    private String plate_number;
    private Date next_inspection_date;
    private int client_id;

    public Vehicle(int id, String model, String brand, Year production_year, String plate_number, Date next_inspection_date, int client_id) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.production_year = production_year;
        this.plate_number = plate_number;
        this.next_inspection_date = next_inspection_date;
        this.client_id = client_id;
    }

    public Vehicle(String model, String brand, Year production_year, String plate_number, Date next_inspection_date, int client_id) {
        this.model = model;
        this.brand = brand;
        this.production_year = production_year;
        this.plate_number = plate_number;
        this.next_inspection_date = next_inspection_date;
        this.client_id = client_id;
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

    public Year getProduction_year() {
        return production_year;
    }

    public void setProduction_year(Year production_year) {
        this.production_year = production_year;
    }

    public String getPlate_number() {
        return plate_number;
    }

    public void setPlate_number(String plate_number) {
        this.plate_number = plate_number;
    }

    public Date getNext_inspection_date() {
        return next_inspection_date;
    }

    public void setNext_inspection_date(Date next_inspection_date) {
        this.next_inspection_date = next_inspection_date;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    @Override
    public String toString() {
        return "Vehicle{id=" + this.getId() +
                ", model=" + this.getModel() +
                ", brand=" + this.getBrand() +
                ", production year" + this.getProduction_year() +
                "' plate number=" + this.getPlate_number() +
                ", next inspection date=" + this.getNext_inspection_date() +
                ", client ID=" + this.getClient_id() + "}";
    }
}
