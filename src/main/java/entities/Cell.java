/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author yukit
 */
public class Cell {
    private int featured_cell_ID;
    private String name;
    private int average_age;
    private String locality;
    private String image;
    
    public Cell() {
    }

    public Cell(int featured_cell_ID) {
        this.featured_cell_ID = featured_cell_ID;
    }

    public Cell(String name,int average_age,String locality,String image) {
        this.name = name;
        this.locality = locality;
        this.average_age = average_age;
        this.image = image;
        
    }

    public Cell(int featured_cell_ID,String name,int average_age,String locality,String image) {
        this.featured_cell_ID = featured_cell_ID;
        this.name = name;
        this.locality = locality;
        this.average_age = average_age;
        this.image = image;
        
    }

    public int getFeatured_cell_ID() {
        return featured_cell_ID;
    }

    public void setFeatured_cell_ID(int featured_cell_ID) {
        this.featured_cell_ID = featured_cell_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAverage_age() {
        return average_age;
    }

    public void setAverage_age(int average_age) {
        this.average_age = average_age;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Cell{" + "featured_cell_ID=" + featured_cell_ID + ", name=" + name + ", average_age=" + average_age + ", locality=" + locality + ", image=" + image + '}';
    }
    
}
