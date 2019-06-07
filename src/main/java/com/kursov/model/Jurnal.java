package com.kursov.model;
import javax.persistence.*;

import java.time.Clock;
import java.time.LocalDateTime;
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

    @Column(name = "eliminDate")
    private Long eliminDate;

    @ManyToOne //(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "carId")//, nullable = false)
    private Cars cars;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;



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
