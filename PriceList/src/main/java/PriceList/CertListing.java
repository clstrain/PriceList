package PriceList;

import java.io.Serializable;

public class CertListing implements Serializable {

    private double price;
    private String number, name, location, unit, duration,
            type, level, category, maxNumStudents;

    private String program, primaryKey;

    public CertListing() {

    }

    public CertListing(double price, String number, String name,
            String location, String unit, String duration, String type,
            String level, String category, String maxNumStudents,
            String program) {
        this.price = price;
        this.number = number;
        this.name = name;
        this.location = location;
        this.unit = unit;
        this.duration = duration;
        this.type = type;
        this.level = level;
        this.category = category;
        this.maxNumStudents = maxNumStudents;
        this.program = program;
        this.primaryKey = this.number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMaxNumStudents() {
        return maxNumStudents;
    }

    public void setMaxNumStudents(String maxNumStudents) {
        this.maxNumStudents = maxNumStudents;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

}
