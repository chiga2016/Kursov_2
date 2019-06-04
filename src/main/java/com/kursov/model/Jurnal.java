package com.kursov.model;
import javax.persistence.*;
import java.time.Clock;
import java.time.LocalDateTime;

@Entity
@Table(name = "Jurnal")

public class Jurnal {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.AUTO  )
    private long id;

    @Column(name = "regDate")
    private Long regDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getRegDate() {
        return regDate;
    }

    public void setRegDate(Long regDate) {
        this.regDate = regDate;
    }

    //    @OneToOne
//    @JoinColumn(name = "userId")
//    private User user;


    public Jurnal() {
        this.regDate = System.currentTimeMillis(); // LocalDateTime.now(Clock.systemUTC());
    }
}
