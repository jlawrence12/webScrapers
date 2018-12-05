/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jovanieLawrence;

import javax.persistence.*;

@Entity
@Table(name="smartphone")

public class HibernateMobilePhones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "specifications_id")
    private int specifications_Id;
    
    @Column(name = "supplier_id")
    private int supplier_Id;
    
    @Column(name = "model_id")
    private int model_Id;
    
    @Column(name = "manufacturer")
    private String manufacturer;
    
    @Column(name = "price")
    private double price;

     @Column(name = "review")
    private String review;

    public HibernateMobilePhones() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSpecifications_Id() {
        return specifications_Id;
    }

    public void setSpecifications_Id(int specifications_Id) {
        this.specifications_Id = specifications_Id;
    }

    public int getSupplier_Id() {
        return supplier_Id;
    }

    public void setSupplier_Id(int supplier_Id) {
        this.supplier_Id = supplier_Id;
    }

    public int getModel_Id() {
        return model_Id;
    }

    public void setModel_Id(int model_Id) {
        this.model_Id = model_Id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
    
      /** Returns a String representation of the Cereal
     * @return  */
    @Override
    public String toString(){
        String str = "Smartphones: " + id + " specifications_id: " + specifications_Id +  "; supplier_Id " + supplier_Id + "; model_id: " +
                model_Id + "; manufacturer: " + manufacturer + "; price: " + price + "; Review: " + review;
        return str;
    } 

}