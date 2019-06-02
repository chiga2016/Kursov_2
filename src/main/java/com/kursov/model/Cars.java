package com.kursov.model;

import javax.persistence.*;

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
    //@Temporal(javax.persistence.TemporalType.DATE)


    //  @Transient
    @OneToOne( mappedBy = "currentCar", cascade={CascadeType.ALL,  /*CascadeType.PERSIST*/})
    //@Column(name= "currentOwner")
    private User currentOwner;

    public User getCurrentOwner() {
        return currentOwner;
    }

    public void setCurrentOwner(User owner) {
        this.currentOwner = currentOwner;
    }

    public Cars(String name, String model, String transmission, String year) {
        this.name = name;
        this.model = model;
        this.transmission = transmission;
        this.year = year;
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


//    private Set kittens = new HashSet();

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

    @Override
    public String toString() {
        String mid;
        return super.toString()+ "{ id=" + id + " name=" + name  + " ownerid="
                ;//+(owner==null?"<none>":owner.getId())+'}';
        //+ " birthdate=" + birthdate
    }


}