package com.sport.coach.controllers;

import com.sport.coach.domain.activity.ValueType;
import com.sport.coach.domain.user.Role;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.LocalDate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author luku00
 */
public abstract class BaseController {

    private static final int DAYS_IN_MONTH = 31;
    private static final int MONTHS_IN_YEAR = 12;
    private static final int YEARS = 50;

    /**
     * will load logged user from security context
     *
     * @return actually logged userName
     */
    protected String getLoggedUserName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName(); //get logged in username
    }

    protected Role gelLoggedUserRole() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return Role.valueOf(auth.getAuthorities().iterator().next().getAuthority());
    }

    public List<String> createListOfValueTypes() {
        List<String> values = new ArrayList<>();
        for (ValueType v : ValueType.values()) {
            values.add(v.name());
        }
        return values;
    }

    public List<String> createListOfRoles() {
        List<String> roles = new ArrayList<>();
        for (Role r : Role.values()) {
            roles.add(r.name());
        }
        return roles;
    }

    public List<String> createListOfDays() {
        List<String> days = new ArrayList<>();
        for (int i = 1; i <= DAYS_IN_MONTH; i++) {
            days.add(String.valueOf(i));
        }
        return days;
    }

    public List<String> createListOfMonths() {
        List<String> months = new ArrayList<>();
        for (int i = 1; i <= MONTHS_IN_YEAR; i++) {
            months.add(String.valueOf(i));
        }
        return months;
    }

    public List<String> createListOfYears() {
        List<String> years = new ArrayList<>();
        LocalDate localDate = new LocalDate();
        int currentYear = localDate.getYear();
        for (int i = 1; i <= YEARS; i++) {
            years.add(String.valueOf(currentYear - i));
        }
        return years;
    }
}
