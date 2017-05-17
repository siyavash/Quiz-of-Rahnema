package com.rahnema.model.entity;

import com.rahnema.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by siyavash on 5/3/2017.
 */

@Entity
@Table(name = "account")
@Component
public class Account implements Serializable, UserDetailsService {

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

    @Column(name = "account_created_at")
    private Date created;

    @Column(name = "account_updated_at")
    private Date updated;

    @PrePersist
    protected void onCreate() {
        created = updated = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Account() {}

    public Account(String androidId, AccountDetail detail) {
        this.androidId = androidId;
        this.setDetail(detail);
        detail.setAccount(this);
    }

    @Autowired
    AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Account account = accountRepository.findByUsername(username);
        if(account == null) {
            return null;
        }

        return new User(account.getUsername(),
                account.getPassword(),
                true,
                true,
                true,
                true,
                new ArrayList< GrantedAuthority>());
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
