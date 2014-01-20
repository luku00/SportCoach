package com.sport.coach.domain.activity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author luku00
 */
@Entity
@Table(name = "ACTIVITY_TYPE")
public class ActivityType implements Serializable {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TYPE")
    private String activityType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

}
