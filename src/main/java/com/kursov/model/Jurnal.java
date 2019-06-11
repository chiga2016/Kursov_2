package com.kursov.model;
import javax.persistence.*;

import java.util.Date;


@Entity
@Table(name = "Jurnal")

public class Jurnal {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.AUTO  )
    private long id;

    @Column(name = "regDate")
   // @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;

    @Column(name = "cost")
    private float cost;

    @Column(name = "eliminDate")
    private Date eliminDate;

    @ManyToOne //(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "idCar")//, nullable = false)
    private Cars cars;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    public Date getEliminDate() {
        return eliminDate;
    }

    public void setEliminDate(Date eliminDate) {
        this.eliminDate = eliminDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cars getCars() {
        return cars;
    }

    public void setCars(Cars cars) {
        this.cars = cars;
    }

    public Jurnal(Cars cars, User user) {
        Date date = new Date();

        this.regDate = new Date(date.getTime());
        this.cars = cars;
        this.user = user;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = new Date(regDate.getTime());
    }

    public Jurnal() {

         ; // LocalDateTime.now(Clock.systemUTC());
    }
}
