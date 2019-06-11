package com.kursov.model;

import javax.persistence.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Transient
    private String confirmPassword;

    @Column(name = "fam")
    private String fam;

    @Column(name = "name")
    private String name;

    @Column(name = "ot")
    private String ot;

    @Column(name = "dr")
    private String dr;

    @Column(name = "vuNumber")
    private String vuNumber;

    @Column(name = "phone")
    private String phone;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "dateCreate")
    private Date dateCreate;

    @ManyToMany //(fetch = FetchType.EAGER)//, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currentCar")
    private Cars currentCar;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private Set<Jurnal> jurnalSetUser = new HashSet<>();

    public Set<Jurnal> getJurnalSetUser() {
        return jurnalSetUser;
    }

    public void setJurnalSetUser(Set<Jurnal> jurnalSetUser) {
        this.jurnalSetUser = jurnalSetUser;
    }

    public Cars getCurrentCar() {
        return currentCar;
    }

    public void setCurrentCar(Cars currentCar) {
        this.currentCar = currentCar;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User() {
    }
    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    public String getRoles2() {
        StringBuilder sb = new StringBuilder();
        sb.append("Roles: ");
        for (Role c : roles) {
            sb.append(c.getName());
            sb.append(',');
        }
        return sb.toString();
    }

    public String getFam() {
        return fam;
    }

    public void setFam(String fam) {
        this.fam = fam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getOt() {
        return ot;
    }

    public void setOt(String ot) {
        this.ot = ot;
    }

    public String getDr() {
        return dr;
    }

    public void setDr(String dr) {
        this.dr = dr;
    }

    public String getVuNumber() {
        return vuNumber;
    }

    public void setVuNumber(String vuNumber) {
        this.vuNumber = vuNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", fam='" + fam + '\'' +
                ", name='" + name + '\'' +
                ", ot='" + ot + '\'' +
                ", dr='" + dr + '\'' +
                ", vuNumber='" + vuNumber + '\'' +
                ", phone='" + phone + '\'' +
                ", enabled=" + enabled +
                ", dateCreate='" + dateCreate + '\'' +
                ", " + getRoles2() + '\'' +
                '}';
    }
}
