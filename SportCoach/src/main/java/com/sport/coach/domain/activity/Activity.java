package com.sport.coach.domain.activity;

import com.sport.coach.domain.user.User;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author luku00
 */
@NamedQueries({
    @NamedQuery(name = "Activity.getActivityByUser", query = "select a from Activity a where user.userIdentification.userLogin = :login"),
    @NamedQuery(name = "Activity.importAlreadyExist", query = "select a from Activity a where importId = :importId")
})
@Entity
@Table(name = "ACTIVITY")
public class Activity implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;

    @Column(name = "IMPORT_ID")
    private String importId;

    @Column(name = "START_A")
    private Timestamp start;

    @Column(name = "END_A")
    private Timestamp end;

    @Column(name = "DURATION")
    private Long duration;

    @Column(name = "ACTIVITY_TYPE")
    private String type;

    @Column(name = "DISTANCE")
    private String distance;

    @Column(name = "KCAL")
    private String kcal;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;

    //@Column(name = "RAW_DATA", unique = false, nullable = false, length = 100000)
    //private byte[] data;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImportId() {
        return importId;
    }

    public void setImportId(String importId) {
        this.importId = importId;
    }

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getKcal() {
        return kcal;
    }

    public void setKcal(String kcal) {
        this.kcal = kcal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public byte[] getData() {
//        return data;
//    }
//
//    public void setData(byte[] data) {
//        this.data = data;
//    }

    public static class Builder {

        private final Activity activity;

        public Builder() {
            this.activity = new Activity();
        }

        public Activity build() {
            return this.activity;
        }

        public Builder withStart(Timestamp start) {
            activity.start = start;
            return this;
        }

        public Builder withEnd(Timestamp end) {
            activity.end = end;
            return this;
        }

        public Builder withDuration(Long duration) {
            activity.duration = duration;
            return this;
        }

        public Builder withValueType(String valueType) {
            activity.type = valueType;
            return this;
        }

        public Builder withDistance(String distance) {
            activity.distance = distance;
            return this;
        }

        public Builder withKcal(String kcal) {
            activity.kcal = kcal;
            return this;
        }

        public Builder withImportId(String importId) {
            activity.importId = importId;
            return this;
        }
    }
}
