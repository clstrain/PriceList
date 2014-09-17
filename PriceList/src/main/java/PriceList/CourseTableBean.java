package PriceList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import org.primefaces.model.SelectableDataModel;

@ManagedBean(name = "courseList")
@ViewScoped

public class CourseTableBean extends ListDataModel<CourseListing>
        implements SelectableDataModel<CourseListing>, Serializable {

    private List<CourseListing> courses, filteredCourses, shoppingCartList;
    public static Integer CP_ID;

    private String response;
    public CourseListing selectedCourse, selectedShoppingcartCourse;

    private List<SelectItem> locationSelectItems = new ArrayList<SelectItem>(),
            typeSelectItems = new ArrayList<SelectItem>(),
            roleSelectItems = new ArrayList<SelectItem>(),
            categorySelectItems = new ArrayList<SelectItem>(),
            productSelectItems = new ArrayList<SelectItem>();

    CourseDAO courseDAO = new CourseDAO();

    @PostConstruct
    public void init() {

        response = "Welcome to the interactive price list.";

        try {
            System.out.println("Loading driver...");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot find the driver in the "
                    + "classpath!", e);
        }

        courseDAO = new CourseDAO();

        shoppingCartList = new ArrayList<CourseListing>();

        courses = courseDAO.getAll();

        response = courseDAO.response;

        LoadDataTableMenus();
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

    public List<SelectItem> getLocationSelectItems() {
        return locationSelectItems;
    }

    public void setLocationSelectItems(List<SelectItem> locationSelectItems) {
        this.locationSelectItems = locationSelectItems;
    }

    public List<SelectItem> getTypeSelectItems() {
        return typeSelectItems;
    }

    public void setTypeSelectItems(List<SelectItem> typeSelectItems) {
        this.typeSelectItems = typeSelectItems;
    }

    public List<SelectItem> getRoleSelectItems() {
        return roleSelectItems;
    }

    public void setRoleSelectItems(List<SelectItem> roleSelectItems) {
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

    public List<SelectItem> getCategorySelectItems() {
        return categorySelectItems;
    }

    public void setCategorySelectItems(List<SelectItem> categorySelectItems) {
        this.categorySelectItems = categorySelectItems;
    }

    public List<SelectItem> getProductSelectItems() {
        return productSelectItems;
    }

    public void setProductSelectItems(List<SelectItem> productSelectItems) {
        this.productSelectItems = productSelectItems;
    }

    private void LoadDataTableMenus() {

        productSelectItems = new ArrayList<SelectItem>();

        List<String> products = new ArrayList<String>(courseDAO.getmenuItemsProduct());

        for (String stringIterator : products) {
            if (!stringIterator.isEmpty()) {
                productSelectItems.add(new SelectItem(stringIterator));
            }
        }

        //load the dropdown lists into HashSets in order to remove dupes 
        Set<String> locations = new HashSet<String>();
        Set<String> categories = new HashSet<String>();
        Set<String> types = new HashSet<String>();
        Set<String> roles = new HashSet<String>();

        for (CourseListing courseListing : courses) {
            locations.add(courseListing.getLocation());
            categories.add(courseListing.getCategory());
            types.add(courseListing.getType());
            roles.add(courseListing.getRole());
        }

        //now load the dropdown lists into array lists in order to sort them abc
        List<String> locationsArrayList = new ArrayList<String>(locations);
        List<String> categoriesArrayList = new ArrayList<String>(categories);
        List<String> typesArrayList = new ArrayList<String>(types);
        List<String> rolesArrayList = new ArrayList<String>(roles);

        Collections.sort(locationsArrayList);
        Collections.sort(categoriesArrayList);
        Collections.sort(typesArrayList);
        Collections.sort(rolesArrayList);

        //setup selectItems
        locationSelectItems = new ArrayList<SelectItem>();
        typeSelectItems = new ArrayList<SelectItem>();
        roleSelectItems = new ArrayList<SelectItem>();
        categorySelectItems = new ArrayList<SelectItem>();

        //place strings in to SelectItems
        for (String stringIterator : locationsArrayList) {
            if (!stringIterator.isEmpty()) {
                locationSelectItems.add(new SelectItem(stringIterator));
            }
        }

        for (String stringIterator : typesArrayList) {
            if (!stringIterator.isEmpty()) {
                typeSelectItems.add(new SelectItem(stringIterator));
            }
        }

        for (String stringIterator : rolesArrayList) {
            if (!stringIterator.isEmpty()) {
                roleSelectItems.add(new SelectItem(stringIterator));
            }
        }

        for (String stringIterator : categoriesArrayList) {
            if (!stringIterator.isEmpty()) {
                categorySelectItems.add(new SelectItem(stringIterator));
            }
        }

    }
}
