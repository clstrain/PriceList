package PriceList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import org.primefaces.model.SelectableDataModel;

@ManagedBean(name = "courseList")
@SessionScoped

public class CourseTableBean extends ListDataModel<CourseListing>
        implements SelectableDataModel<CourseListing>, Serializable {

    private List<CourseListing> courses, filteredCourses, shoppingCartList;
    public static Integer CP_ID;
    public static String number, product, name, location, unit, duration,
            type, role, category, price, maxNumStudents,
            superProduct, subProduct;
    private String response;
    public CourseListing selectedCourse, selectedShoppingcartCourse;
    private LinkedHashSet<SelectItem> locationSelectItems, categorySelectItems, typeSelectItems, roleSelectItems;

    public CourseTableBean() {

        CourseDAO courseDAO = new CourseDAO();
        response = "Welcome to the interactive price list.";

        try {
            System.out.println("Loading driver...");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot find the driver in the "
                    + "classpath!", e);
        }

        shoppingCartList = new ArrayList<CourseListing>();

        courses = courseDAO.getAll();

        response = courseDAO.response;

        //populate the location dropdown box
        locationSelectItems = new LinkedHashSet<SelectItem>();
        categorySelectItems = new LinkedHashSet<SelectItem>();
        typeSelectItems = new LinkedHashSet<SelectItem>();
        roleSelectItems = new LinkedHashSet<SelectItem>();

        locationSelectItems.add(new SelectItem("", "Any"));
        categorySelectItems.add(new SelectItem("", "Any"));
        typeSelectItems.add(new SelectItem("", "Any"));
        roleSelectItems.add(new SelectItem("", "Any"));

        for (CourseListing courseListing : courses) {
            locationSelectItems.add(new SelectItem(courseListing.getLocation()));
            categorySelectItems.add(new SelectItem(courseListing.getCategory()));
            typeSelectItems.add(new SelectItem(courseListing.getType()));
            roleSelectItems.add(new SelectItem(courseListing.getRole()));

        }
    }

    public void processProductChange() {
        this.setSuperProduct(null);
    }

    public void processSuperProductChange() {
        this.setproduct(null);
    }

    public void addToCart() {

        shoppingCartList.add(selectedCourse);

        Set tempSet = new HashSet(shoppingCartList);

        shoppingCartList = new ArrayList(tempSet);

    }

    public void removeFromCart() {

        if (selectedShoppingcartCourse == null) {
            response = "Select Something to Remove First";
        } else {
            shoppingCartList.remove(selectedShoppingcartCourse);
        }

    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Integer getC_ID() {
        return CP_ID;
    }

    public void setC_ID(Integer C_ID) {
        CourseTableBean.CP_ID = C_ID;
    }

    public String getnumber() {
        return number;
    }

    public void setnumber(String number) {
        CourseTableBean.number = number;
    }

    public String getproduct() {
        return product;
    }

    public void setproduct(String product) {
        CourseTableBean.product = product;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        CourseTableBean.name = name;
    }

    public String getlocation() {
        return location;
    }

    public void setlocation(String location) {
        CourseTableBean.location = location;
    }

    public String getunit() {
        return unit;
    }

    public void setunit(String unit) {
        CourseTableBean.unit = unit;
    }

    public String getduration() {
        return duration;
    }

    public void setduration(String duration) {
        CourseTableBean.duration = duration;
    }

    public String gettype() {
        return type;
    }

    public void settype(String type) {
        CourseTableBean.type = type;
    }

    public String getrole() {
        return role;
    }

    public void setrole(String role) {
        CourseTableBean.role = role;
    }

    public String getcategory() {
        return category;
    }

    public void setcategory(String category) {
        CourseTableBean.category = category;
    }

    public String getprice() {
        return price;
    }

    public void setprice(String price) {
        CourseTableBean.price = price;
    }

    public String getmaxNumStudents() {
        return maxNumStudents;
    }

    public void setmaxNumStudents(String maxNumStudents) {
        CourseTableBean.maxNumStudents = maxNumStudents;
    }

    public List<CourseListing> getCourses() {

        return courses;
    }

    public void setCourses(List<CourseListing> courses) {

        this.courses = courses;
    }

    public CourseListing getSelectedCourse() {
        return selectedCourse;
    }

    public void setSelectedCourse(CourseListing selectedCourse) {
        this.selectedCourse = selectedCourse;
    }

    public List<CourseListing> getFilteredCourses() {
        return filteredCourses;
    }

    public void setFilteredCourses(List<CourseListing> filteredCourses) {
        this.filteredCourses = filteredCourses;
    }

    public String getSuperProduct() {
        return superProduct;
    }

    public void setSuperProduct(String superProduct) {
        CourseTableBean.superProduct = superProduct;
    }

    public String getSubProduct() {
        return subProduct;
    }

    public void setSubProduct(String subProduct) {
        CourseTableBean.subProduct = subProduct;
    }

    public HashSet<SelectItem> getLocationSelectItems() {
        return locationSelectItems;
    }

    
    public void setLocationSelectItems(LinkedHashSet<SelectItem> locationSelectItems) {
        this.locationSelectItems = locationSelectItems;
    }

    public LinkedHashSet<SelectItem> getCategorySelectItems() {
        return categorySelectItems;
    }

    public void setCategorySelectItems(LinkedHashSet<SelectItem> categorySelectItems) {
        this.categorySelectItems = categorySelectItems;
    }

    public LinkedHashSet<SelectItem> getTypeSelectItems() {
        return typeSelectItems;
    }

    public void setTypeSelectItems(LinkedHashSet<SelectItem> typeSelectItems) {
        this.typeSelectItems = typeSelectItems;
    }

    public LinkedHashSet<SelectItem> getRoleSelectItems() {
        return roleSelectItems;
    }

    public void setRoleSelectItems(LinkedHashSet<SelectItem> roleSelectItems) {
        this.roleSelectItems = roleSelectItems;
    }

   
 

    public List<CourseListing> getShoppingCartList() {
        return shoppingCartList;
    }

    public void setShoppingCartList(List<CourseListing> shoppingCartList) {
        this.shoppingCartList = shoppingCartList;
    }

    public CourseListing getSelectedShoppingcartCourse() {
        return selectedShoppingcartCourse;
    }

    public void setSelectedShoppingcartCourse(CourseListing selectedShoppingcartCourse) {
        this.selectedShoppingcartCourse = selectedShoppingcartCourse;
    }

    public Object getRowKey(CourseListing t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public CourseListing getRowData(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
