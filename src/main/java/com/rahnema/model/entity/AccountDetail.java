package com.rahnema.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by siyavash on 5/3/2017.
 */

@Entity
@Table(name = "account_detail")
public class AccountDetail implements Serializable {

    private Account account;

    @Column(name = "account_coin")
    private Long coin;

    @Column(name = "account_gem")
    private Long gem;

    @Column(name = "account_xp")
    private Long xp;

    @Column(name = "account_level")
    private Long level;

    @Column(name = "account_detail_created_at")
    private Date created;

    @Column(name = "account_detail_updated_at")
    private Date updated;

    @PrePersist
    protected void onCreate() {
        created = updated = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }

    public AccountDetail() {}

    public AccountDetail(Long coin, Long gem, Long xp, Long level) {
        this.coin = coin;
        this.gem = gem;
        this.xp = xp;
        this.level = level;
    }

    @Id
    @OneToOne
    @JoinColumn(name = "account_id")
    @JsonBackReference
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Long getCoin() {
        return coin;
    }

    public void setCoin(Long coin) {
        this.coin = coin;
    }

    public Long getGem() {
        return gem;
    }

    public void setGem(Long gem) {
        this.gem = gem;
    }

    public Long getXp() {
        return xp;
    }

    public void setXp(Long xp) {
        this.xp = xp;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
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
}
