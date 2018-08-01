package pl.coderslab.model;

import java.util.Date;

public class Order {
    private int id;
    private Date arrivalDate;
    private Date plannedRepairDate;
    private Date realRepairDate;
    private Employee employee;
    private String problemDescription;
    private String repairDescription;
    private String status;
    private Vehicle vehicle;
    private double totalCost;
    private double partsCost;
    private int workingHours;


    public Order(Date arrivalDate, Date plannedRepairDate, Employee employee, String problemDescription, String status, Vehicle vehicle) {
        this.arrivalDate = arrivalDate;
        this.plannedRepairDate = plannedRepairDate;
        this.employee = employee;
        this.problemDescription = problemDescription;
        this.status = status;
        this.vehicle = vehicle;
    }

    public Order(int id, Date arrivalDate, Date plannedRepairDate, Date realRepairDate, Employee employee, String problemDescription, String repairDescription, String status, Vehicle vehicle, double totalCost, double partsCost, int workingHours) {
        this.id = id;
        this.arrivalDate = arrivalDate;
        this.plannedRepairDate = plannedRepairDate;
        this.realRepairDate = realRepairDate;
        this.employee = employee;
        this.problemDescription = problemDescription;
        this.repairDescription = repairDescription;
        this.status = status;
        this.vehicle = vehicle;
        this.totalCost = totalCost;
        this.partsCost = partsCost;
        this.workingHours = workingHours;
    }

    public Order(Date arrivalDate, Date plannedRepairDate, Date realRepairDate, Employee employee, String problemDescription, String repairDescription, String status, Vehicle vehicle, double totalCost, double partsCost, int workingHours) {
        this.arrivalDate = arrivalDate;
        this.plannedRepairDate = plannedRepairDate;
        this.realRepairDate = realRepairDate;
        this.employee = employee;
        this.problemDescription = problemDescription;
        this.repairDescription = repairDescription;
        this.status = status;
        this.vehicle = vehicle;
        this.totalCost = totalCost;
        this.partsCost = partsCost;
        this.workingHours = workingHours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getPlannedRepairDate() {
        return plannedRepairDate;
    }

    public void setPlannedRepairDate(Date plannedRepairDate) {
        this.plannedRepairDate = plannedRepairDate;
    }

    public Date getRealRepairDate() {
        return realRepairDate;
    }

    public void setRealRepairDate(Date realRepairDate) {
        this.realRepairDate = realRepairDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getRepairDescription() {
        return repairDescription;
    }

    public void setRepairDescription(String repairDescription) {
        this.repairDescription = repairDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getPartsCost() {
        return partsCost;
    }

    public void setPartsCost(double partsCost) {
        this.partsCost = partsCost;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", arrivalDate=" + arrivalDate +
                ", plannedRepairDate=" + plannedRepairDate +
                ", realRepairDate=" + realRepairDate +
                ", employee=" + employee +
                ", problemDescription='" + problemDescription + '\'' +
                ", repairDescription='" + repairDescription + '\'' +
                ", status='" + status + '\'' +
                ", vehicle=" + vehicle +
                ", totalCost=" + totalCost +
                ", partsCost=" + partsCost +
                ", workingHours=" + workingHours +
                '}';
    }
}
