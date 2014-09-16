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

@ManagedBean(name = "certList")
@ViewScoped

public class CertificationListBean extends ListDataModel<CertListing>
        implements SelectableDataModel<CertListing>, Serializable {

    private List<CertListing> courses, filteredCourses, shoppingCartList;
    public static Integer CP_ID;
    
    private String response;
    
    public CertListing selectedCourse, selectedShoppingcartCourse;

    private List<SelectItem> locationSelectItems = new ArrayList<SelectItem>(),
            typeSelectItems = new ArrayList<SelectItem>(),
            levelSelectItems = new ArrayList<SelectItem>(),
            categorySelectItems = new ArrayList<SelectItem>(),
            programSelectItems = new ArrayList<SelectItem>();
    
    CertDAO certDAO = new CertDAO();

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

        certDAO = new CertDAO();

        shoppingCartList = new ArrayList<CertListing>();

        courses = certDAO.getAll();

        response = certDAO.response;
                               
        LoadDataTableMenus();
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
        CertificationListBean.CP_ID = C_ID;
    }

    public List<CertListing> getCourses() {

        return courses;
    }

    public void setCourses(List<CertListing> courses) {

        this.courses = courses;
    }

    public CertListing getSelectedCourse() {
        return selectedCourse;
    }

    public void setSelectedCourse(CertListing selectedCourse) {
        this.selectedCourse = selectedCourse;
    }

    public List<CertListing> getFilteredCourses() {
        return filteredCourses;
    }

    public void setFilteredCourses(List<CertListing> filteredCourses) {
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

    public List<SelectItem> getLevelSelectItems() {
        return levelSelectItems;
    }

    public void setLevelSelectItems(List<SelectItem> levelSelectItems) {
        this.levelSelectItems = levelSelectItems;
    }

    public List<CertListing> getShoppingCartList() {
        return shoppingCartList;
    }

    public void setShoppingCartList(List<CertListing> shoppingCartList) {
        this.shoppingCartList = shoppingCartList;
    }

    public CertListing getSelectedShoppingcartCourse() {
        return selectedShoppingcartCourse;
    }

    public void setSelectedShoppingcartCourse(CertListing selectedShoppingcartCourse) {
        this.selectedShoppingcartCourse = selectedShoppingcartCourse;
    }

    public Object getRowKey(CertListing t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public CertListing getRowData(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<SelectItem> getCategorySelectItems() {
        return categorySelectItems;
    }

    public void setCategorySelectItems(List<SelectItem> categorySelectItems) {
        this.categorySelectItems = categorySelectItems;
    }

    public List<SelectItem> getProgramSelectItems() {
        return programSelectItems;
    }

    public void setProgramSelectItems(List<SelectItem> programSelectItems) {
        this.programSelectItems = programSelectItems;
    }
    
    private void LoadDataTableMenus() {

        
        programSelectItems = new ArrayList<SelectItem>();
       
        List<String>programs = new ArrayList<String>();
        
        for (CertListing stringIterator : courses) {
            
                programSelectItems.add(new SelectItem(stringIterator.getProgram()));
            
        }
                     
        for (String stringIterator : programs) {
            if (!stringIterator.isEmpty()) {
                programSelectItems.add(new SelectItem(stringIterator));
            }
        }
        
        //load the dropdown lists into HashSets in order to remove dupes 
        Set<String> locations = new HashSet<String>();
        Set<String> categories = new HashSet<String>();
        Set<String> types = new HashSet<String>();
        Set<String> levels = new HashSet<String>();
        
        for (CertListing courseListing : courses) {
            locations.add(courseListing.getLocation());
            categories.add(courseListing.getCategory());
            types.add(courseListing.getType());
            levels.add(courseListing.getLevel());
        }
        
        //now load the dropdown lists into array lists in order to sort them abc
        List<String> locationsArrayList = new ArrayList<String>(locations);
        List<String> categoriesArrayList = new ArrayList<String>(categories);
        List<String> typesArrayList = new ArrayList<String>(types);
        List<String> levelsArrayList = new ArrayList<String>(levels);
                       
        Collections.sort(locationsArrayList);
        Collections.sort(categoriesArrayList);
        Collections.sort(typesArrayList);
        Collections.sort(levelsArrayList);
             
        //setup selectItems
        locationSelectItems = new ArrayList<SelectItem>();
        typeSelectItems = new ArrayList<SelectItem>();
        levelSelectItems = new ArrayList<SelectItem>();
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

        for (String stringIterator : levelsArrayList) {
            if (!stringIterator.isEmpty()) {
                levelSelectItems.add(new SelectItem(stringIterator));
            }
        }

        for (String stringIterator : categoriesArrayList) {
            if (!stringIterator.isEmpty()) {
                categorySelectItems.add(new SelectItem(stringIterator));
            }
        }
        
        

    }
}