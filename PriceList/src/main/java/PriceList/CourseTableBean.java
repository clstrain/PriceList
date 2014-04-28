package PriceList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

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

    public CourseTableBean() {

        response = "Welcome to the interactive price list. You may use "
                + "the drop down menus above to narrow your search.";

        try {
            System.out.println("Loading driver...");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot find the driver in the "
                    + "classpath!", e);
        }

        shoppingCartList = new ArrayList<CourseListing>();
    }

    public String go() {

        CourseDAO courseDAO = new CourseDAO();
        courses = courseDAO.searchFor(superProduct, product, location,
                type, category);
        response = courseDAO.response;

        return "courseList.xhtml";
    }

    public void processProductChange() {
        this.setSuperProduct(null);
    }

    public void processSuperProductChange() {
        this.setproduct(null);
    }

    public void reset() {
        this.setnumber(null);
        this.setproduct(null);
        this.setname(null);
        this.setlocation(null);
        this.setunit(null);
        this.setduration(null);
        this.settype(null);
        this.setrole(null);
        this.setcategory(null);
        this.setprice(null);
        this.setmaxNumStudents(null);
        this.setSubProduct(null);
        this.setSuperProduct(null);

        this.setSelectedCourse(null);

        this.setCourses(null);

        this.setFilteredCourses(null);

        response = "Welcome to the interactive price list. "
                + "You may use the drop down menus above to narrow "
                + "your search.";

    }

    public String goIndex() {

        response = "Hint: you can select Search without any filters in order to "
                + "see the full course list.";

        return "index.xhtml";
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