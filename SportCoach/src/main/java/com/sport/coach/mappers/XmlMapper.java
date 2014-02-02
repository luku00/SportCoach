package com.sport.coach.mappers;

import com.sport.coach.domain.activity.Activity;
import com.sport.coach.domain.xml.ActivityXml;
import com.sport.coach.utils.ConvertionUtil;
import java.text.ParseException;

/**
 *
 * @author luku00
 */
public class XmlMapper {

    public Activity mapActivityFromActivityXml(ActivityXml xml) throws ParseException {
        return new Activity.Builder()
                .withStart(ConvertionUtil.convertStringToTimestamp(xml.getTimeStart()))
                .withDuration(ConvertionUtil.parseStringDoubleToLong(xml.getTotalTimeInSec()))
                .withDistance(xml.getDistanceInMeters())
                .withKcal(xml.getKcal())
                .withImportId(xml.getOriginId())
                .build();
    }
}
