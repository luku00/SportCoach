package com.sport.coach.domain.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luku00
 */
@XmlRootElement(name = "ACTIVITY")
public class ActivityXml {

    private String originId;
    private String timeStart;
    private String totalTimeInSec;
    private String distanceInMeters;
    private String kcal;

    @XmlElement(name = "ORIGINID")
    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    @XmlElement(name = "TIMESTART")
    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    @XmlElement(name = "TOTALTIMEINSECONDS")
    public String getTotalTimeInSec() {
        return totalTimeInSec;
    }

    public void setTotalTimeInSec(String totalTimeInSec) {
        this.totalTimeInSec = totalTimeInSec;
    }

    @XmlElement(name = "DISTANCEINMETERS")
    public String getDistanceInMeters() {
        return distanceInMeters;
    }

    public void setDistanceInMeters(String distanceInMeters) {
        this.distanceInMeters = distanceInMeters;
    }

    @XmlElement(name = "CALORIES")
    public String getKcal() {
        return kcal;
    }

    public void setKcal(String kcal) {
        this.kcal = kcal;
    }

}
