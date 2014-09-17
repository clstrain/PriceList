package PriceList;

import java.io.Serializable;

public class CourseListing implements Serializable {

    private double price;
    private String number, name, location, unit, duration,
            type, role, category, maxNumStudents;
    private String superProduct, subProduct;
    private Integer P_ID;
    private String product, primaryKey;

    public CourseListing() {

    }

    public CourseListing(double price, String number, String name,
            String location, String unit, String duration, String type,
            String role, String category, String maxNumStudents,
            String superProduct, String subProduct, String product) {
        this.price = price;
        this.number = number;
        this.name = name;
        this.location = location;
        this.unit = unit;
        this.duration = duration;
        this.type = type;
        this.role = role;
        this.category = category;
        this.maxNumStudents = maxNumStudents;
        this.superProduct = superProduct;
        this.subProduct = subProduct;
        this.product = product;
        this.primaryKey = this.number + this.product;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getSuperProduct() {
        return superProduct;
    }

    public void setSuperProduct(String superProduct) {
        this.superProduct = superProduct;
    }

    public String getSubProduct() {
        return subProduct;
    }

    public void setSubProduct(String subProduct) {
        this.subProduct = subProduct;
    }

    public Integer getP_ID() {
        return P_ID;
    }

    public void setP_ID(Integer P_ID) {
        this.P_ID = P_ID;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
