package com.rahnema.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by siyavash on 5/3/2017.
 */

@Entity
@Table(name = "account")
public class Account implements Serializable {

    @Column(name = "account_id")
    private Long id;

    private AccountDetail detail;

    @Column(name = "account_username")
    private String username;

    @Column(name = "account_password")
    private String password;

    @Column(name = "account_android_id")
    private String androidId;

    @Column(name = "account_email")
    private String email;

    @Column(name = "account_phone_number")
    private int phoneNumber;

    @Column(name = "account_first_name")
    private String firstName;

    @Column(name = "account_last_name")
    private String lastName;

    public Account() {}

    public Account(String androidId) {
        this.androidId = androidId;
        this.setDetail(new AccountDetail(100L, 0L, 0L, 1));
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    public AccountDetail getDetail() {
        return detail;
    }

    public void setDetail(AccountDetail detail) {
        this.detail = detail;
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

    public String getAndroidId() {
        return androidId;
    }

    public void setAndroidId(String androidId) {
        this.androidId = androidId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
