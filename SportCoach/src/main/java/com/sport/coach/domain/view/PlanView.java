package com.sport.coach.domain.view;

import com.sport.coach.domain.activity.ValueType;
import java.util.Date;

/**
 *
 * @author luku00
 */
public class PlanView {

    private Date fromDate;
    private Date toDate;
    private ValueType goalType;
    private String goalValue;
    private Integer reward;

    public PlanView(Date fromDate, Date toDate, ValueType goalType, String goalValue, Integer reward) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.goalType = goalType;
        this.goalValue = goalValue;
        this.reward = reward;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public ValueType getGoalType() {
        return goalType;
    }

    public void setGoalType(ValueType goalType) {
        this.goalType = goalType;
    }

    public String getGoalValue() {
        return goalValue;
    }

    public void setGoalValue(String goalValue) {
        this.goalValue = goalValue;
    }

    public Integer getReward() {
        return reward;
    }

    public void setReward(Integer reward) {
        this.reward = reward;
    }

}
