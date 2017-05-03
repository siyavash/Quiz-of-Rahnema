package com.rahnema.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by doost on 5/3/2017.
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
    private int level;

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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
