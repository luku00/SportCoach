package com.sport.coach.controllers;

import com.sport.coach.domain.user.Role;
import com.sport.coach.domain.user.User;
import com.sport.coach.domain.view.UserInfo;
import com.sport.coach.domain.view.UserView;
import com.sport.coach.domain.view.ViewParams;
import com.sport.coach.error.ClientServerException;
import com.sport.coach.mappers.ViewMapper;
import com.sport.coach.service.SportCoachSecurityService;
import com.sport.coach.service.SportCoachService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.joda.time.LocalDate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Lukas Kubicek
 */
@Controller
@RequestMapping("/account")
@SessionAttributes({"userData", "userInfo"})
public class SportCoachAccountController {

    private static final int DAYS_IN_MONTH = 31;
    private static final int MONTHS_IN_YEAR = 12;
    private static final int YEARS = 50;

    @Autowired
    private UserView userView;

    @Autowired
    private UserInfo userInfo;

    @Autowired
    private ViewMapper viewMapper;

    @Autowired
    private SportCoachService sportCoachService;

    @Autowired
    private SportCoachSecurityService sportCoachSecurityService;

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView newAccount() {
        // at the moment allowed to have only requestor
        // later we may use createListOfRoles() to allow all roles
        List<Role> role = new ArrayList<>();
        role.add(Role.REQUESTOR);

        ModelAndView model = new ModelAndView("newAccount", ViewParams.NEW_ACCOUNT_ROLES, role);
        loadDefaultNewAccountParams(model);
        return model;
    }

    /**
     * Will create new account
     */
    @RequestMapping(value = "/new/save", method = RequestMethod.POST)
    public ModelAndView save(@Valid UserView viewUser) throws ClientServerException {
        ModelAndView model = new ModelAndView();

        // at the moment allowed to have only requestor
        // later we may use createListOfRoles() to allow all roles
        List<Role> role = new ArrayList<>();
        role.add(Role.REQUESTOR);

        model.getModel().put(ViewParams.NEW_ACCOUNT_ROLES, role);
        model.setViewName("newAccount");
        if (sportCoachService.checkIfLoginExists(viewUser.getUsername())) {
            model.getModel().put(ViewParams.NEW_ACCOUNT_EXISTING_LOGIN, "loginExist");
            model.getModel().put(ViewParams.NEW_ACCOUNT_USER_VIEW, viewUser);

        } else {
            viewUser.setPassword(sportCoachSecurityService.hashPassword(viewUser.getPassword()));
            User user = sportCoachService.save(viewMapper.mapToUser(viewUser), null);
            model.getModel().put(ViewParams.NEW_ACCOUNT_USER_CREATED, "userCreated");
        }

        return model;
    }

    /**
     * Will create new user sub account under main requestor account
     */
    @RequestMapping(value = "/admin/newSubAccount", method = RequestMethod.POST)
    public ModelAndView saveSubAccount(@Valid UserView viewUser) throws ClientServerException {
        ModelAndView model = new ModelAndView("adminAccount");
        viewUser.getSubUserView().setUserRole(Role.BASIC_USER.name());
        viewUser.getSubUserView().setPassword(sportCoachSecurityService.getHashedDefaultPassword());
        User user = viewMapper.mapToUser(viewUser.getSubUserView());
        sportCoachService.save(user, userInfo.getAccountId());
        loadDefaultNewAccountParams(model);
        return model;
    }

    /**
     * Login page
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * Will load user admin page
     */
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminOwnAccount() throws ClientServerException {
        ModelAndView model = new ModelAndView("adminAccount");
        emptyOldData();
        userView = viewMapper.mapToUserView(sportCoachService.getUser(getLoggedUserName()), userView);
        userInfo.setAccountId(userView.getAccountId());
        model.addObject("userData", userView);
        model.addObject("userInfo", userInfo);
        loadDefaultNewAccountParams(model);
        return model;
    }

    /**
     * This will change account data
     * @param viewUser
     * @param passwd1
     * @return
     * @throws com.sport.coach.error.ClientServerException
     */
    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public ModelAndView changeAccountData(@Valid UserView viewUser, @Valid String passwd1) throws ClientServerException {
        ModelAndView model = new ModelAndView("redirect:/account/admin");
        if (passwd1 != null) {
            viewUser.setPassword(sportCoachSecurityService.hashPassword(passwd1));
        }
        User updatedUser = sportCoachService.updateUserData(viewMapper.mapToUser(viewUser), getLoggedUserName());
        userInfo = viewMapper.mapUserToUserInfo(updatedUser);
        model.addObject("userInfo", userInfo);
        return model;
    }

    /**
     * will load logged user from security context
     *
     * @return actually logged userName
     */
    private String getLoggedUserName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName(); //get logged in username
    }

    private List<String> createListOfRoles() {
        List<String> roles = new ArrayList<>();
        for (Role r : Role.values()) {
            roles.add(r.name());
        }
        return roles;
    }

    private void loadDefaultNewAccountParams(ModelAndView model) {
        model.getModel().put(ViewParams.NEW_ACCOUNT_DAYS, createListOfDays());
        model.getModel().put(ViewParams.NEW_ACCOUNT_MONTHS, createListOfMonths());
        model.getModel().put(ViewParams.NEW_ACCOUNT_YEARS, createListOfYears());
    }

    private List<String> createListOfDays() {
        List<String> days = new ArrayList<>();
        for (int i = 1; i <= DAYS_IN_MONTH; i++) {
            days.add(String.valueOf(i));
        }
        return days;
    }

    private List<String> createListOfMonths() {
        List<String> months = new ArrayList<>();
        for (int i = 1; i <= MONTHS_IN_YEAR; i++) {
            months.add(String.valueOf(i));
        }
        return months;
    }

    private List<String> createListOfYears() {
        List<String> years = new ArrayList<>();
        LocalDate localDate = new LocalDate();
        int currentYear = localDate.getYear();
        for (int i = 1; i <= YEARS; i++) {
            years.add(String.valueOf(currentYear - i));
        }
        return years;
    }

    /**
     * will clean data which might be out of date
     */
    private void emptyOldData() {
        userView.getSubAccounts().clear();
    }
}
