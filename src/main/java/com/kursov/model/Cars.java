package com.kursov.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="cars")
//,uniqueConstraints={@UniqueConstraint(columnNames={"NAME"})}
@EntityListeners(EventMonitor.class)
public class Cars {

    @Id
    @GeneratedValue
    @Column(name="car_id")
    private long id; // identifier

    @Column(name="name")
    String name;
    @Column(name="model")
    String model;
    @Column(name="transmission")
    String transmission;
    @Column(name="year")
    private String year;
    @Column(name="available")
    private boolean available;

    @JsonIgnore
    //@OneToMany(fetch = FetchType.EAGER, mappedBy = "carId")
    @OneToMany(mappedBy = "cars",fetch = FetchType.LAZY, cascade={CascadeType.ALL})
    private Set<Jurnal> jurnalSetCar = new HashSet<>();


    public Set<Jurnal> getJurnalSetCar() {
        return jurnalSetCar ;
    }

    public void setJurnalSetCar(Set<Jurnal> jurnalSetCar) {
        this.jurnalSetCar = jurnalSetCar;
    }

    @Column(name="price")
    private float price;
    //@Temporal(javax.persistence.TemporalType.DATE)

    //  @Transient
    @OneToOne( mappedBy = "currentCar", fetch = FetchType.LAZY,  cascade={CascadeType.ALL,  CascadeType.PERSIST})/**/
    @JsonIgnore
    //@Column(name= "currentOwner")
    private User currentOwner;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }



    public void setId(long id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @JsonIgnore
    public User getCurrentOwner() {
        return currentOwner;
    }
    @JsonProperty
    public void setCurrentOwner(User owner) {
        this.currentOwner = currentOwner;
    }

    public Cars(String name, String model, String transmission, String year, boolean available, float price) {
        if(price==0){price=5;}

        this.name = name;
        this.model = model;
        this.transmission = transmission;
        this.year = year;
        this.available = available;
        this.price = price;
    }

    public Cars() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    private void setId(Long id) {
        this.id=id;
    }
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}