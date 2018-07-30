package pl.coderslab.model;

import java.util.Date;

public class Order {
    private int id;
    private Date arrival_date;
    private Date planned_repair_date;
    private Date real_repair_date;
    private int employees_id;
    private String problem_description;
    private String repair_description;
    private String status;
    private int vehicles_id;
    private float total_cost;
    private float parts_cost;
    private int working_hours;

    public Order(Date arrival_date, Date planned_repair_date, Date real_repair_date, int employees_id, String problem_description, String repair_description, String status, int vehicles_id, float total_cost, float parts_cost, int working_hours) {
        this.arrival_date = arrival_date;
        this.planned_repair_date = planned_repair_date;
        this.real_repair_date = real_repair_date;
        this.employees_id = employees_id;
        this.problem_description = problem_description;
        this.repair_description = repair_description;
        this.status = status;
        this.vehicles_id = vehicles_id;
        this.total_cost = total_cost;
        this.parts_cost = parts_cost;
        this.working_hours = working_hours;
    }

    public Order(int id, Date arrival_date, Date planned_repair_date, Date real_repair_date, int employees_id, String problem_description, String repair_description, String status, int vehicles_id, float total_cost, float parts_cost, int working_hours) {
        this.id = id;
        this.arrival_date = arrival_date;
        this.planned_repair_date = planned_repair_date;
        this.real_repair_date = real_repair_date;
        this.employees_id = employees_id;
        this.problem_description = problem_description;
        this.repair_description = repair_description;
        this.status = status;
        this.vehicles_id = vehicles_id;
        this.total_cost = total_cost;
        this.parts_cost = parts_cost;
        this.working_hours = working_hours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(Date arrival_date) {
        this.arrival_date = arrival_date;
    }

    public Date getPlanned_repair_date() {
        return planned_repair_date;
    }

    public void setPlanned_repair_date(Date planned_repair_date) {
        this.planned_repair_date = planned_repair_date;
    }

    public Date getReal_repair_date() {
        return real_repair_date;
    }

    public void setReal_repair_date(Date real_repair_date) {
        this.real_repair_date = real_repair_date;
    }

    public int getEmployees_id() {
        return employees_id;
    }

    public void setEmployees_id(int employees_id) {
        this.employees_id = employees_id;
    }

    public String getProblem_description() {
        return problem_description;
    }

    public void setProblem_description(String problem_description) {
        this.problem_description = problem_description;
    }

    public String getRepair_description() {
        return repair_description;
    }

    public void setRepair_description(String repair_description) {
        this.repair_description = repair_description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getVehicles_id() {
        return vehicles_id;
    }

    public void setVehicles_id(int vehicles_id) {
        this.vehicles_id = vehicles_id;
    }

    public float getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(float total_cost) {
        this.total_cost = total_cost;
    }

    public float getParts_cost() {
        return parts_cost;
    }

    public void setParts_cost(float parts_cost) {
        this.parts_cost = parts_cost;
    }

    public int getWorking_hours() {
        return working_hours;
    }

    public void setWorking_hours(int working_hours) {
        this.working_hours = working_hours;
    }

    @Override
    public String toString() {
        return "Order{id=" + this.getId() +
                ", arrival_date=" + this.getArrival_date() +
                ", planned_repair_date=" + this.getPlanned_repair_date() +
                ", real_repair_date=" + this.getReal_repair_date() +
                ", emplyees_id=" + this.getEmployees_id() +
                ", problem_description=" + this.getProblem_description() +
                ", repair_description=" + this.getRepair_description() +
                ", status=" + this.getStatus() +
                ", vehicles_id=" + this.getVehicles_id() +
                ", total_cost=" + this.getTotal_cost() +
                ", parts_cost=" + this.getParts_cost() +
                ", working_hours=" + this.getWorking_hours();
    }
}
