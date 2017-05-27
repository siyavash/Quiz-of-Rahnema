package com.rahnema.model.entity;

import com.rahnema.model.AbstractBaseEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by siyavash on 5/5/2017.
 */

@Entity
@Table(name = "match_detail")
public class MatchDetail extends AbstractBaseEntity implements Serializable {

    @Column(name = "match_id")
    private int id;

    @Column(name = "match_type")
    private int type;

    @Column(name = "match_maximum_time")
    private int maximumTime;

    @Column(name = "match_increasing_time")
    private int increasingTime;

    @Column(name = "match_number_of_question")
    private int numberOfQuestion;

    @Column(name = "match_detail_gem_reward")
    private int gemReward;

    @Column(name = "match_detail_coin_reward")
    private int coinReward;

    @Column(name = "match_detail_xp_reward")
    private int xpReward;

    @Column(name = "match_detail_enter_coin")
    private int enterCoin;

    private int NumberOfCreate;

    public MatchDetail() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getMaximumTime() {
        return maximumTime;
    }

    public void setMaximumTime(int maximumTime) {
        this.maximumTime = maximumTime;
    }

    public int getIncreasingTime() {
        return increasingTime;
    }

    public void setIncreasingTime(int increasingTime) {
        this.increasingTime = increasingTime;
    }

    public int getNumberOfQuestion() {
        return numberOfQuestion;
    }

    public void setNumberOfQuestion(int numberOfQuestion) {
        this.numberOfQuestion = numberOfQuestion;
    }

    public int getGemReward() {
        return gemReward;
    }

    public void setGemReward(int gemReward) {
        this.gemReward = gemReward;
    }

    public int getCoinReward() {
        return coinReward;
    }

    public void setCoinReward(int coinReward) {
        this.coinReward = coinReward;
    }

    public int getXpReward() {
        return xpReward;
    }

    public void setXpReward(int xpReward) {
        this.xpReward = xpReward;
    }

    public int getEnterCoin() {
        return enterCoin;
    }

    public void setEnterCoin(int enterCoin) {
        this.enterCoin = enterCoin;
    }

    public int getNumberOfCreate() {
        return NumberOfCreate;
    }

    public void setNumberOfCreate(int numberOfCreate) {
        NumberOfCreate = numberOfCreate;
    }
}
