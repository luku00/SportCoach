<%-- 
    Document   : adminAccount
    Created on : Nov 26, 2013, 8:29:58 PM
    Author     : luku00
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administration own account</title>
    </head>
    <body>
        <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <jsp:include page="layout.jsp" />
        <form id="adminAccountForm" class="form-horizontal" action="" method="post">
            <div class="control-group">
                <label class="control-label"><spring:message code="name" /></label>
                <div class="controls">
                    <input type="text" name="firstName" id="firstName" value="${userData.firstName}" maxlength="30" required="true" disabled="true" title="User First name"/>
                </div>
                <label class="control-label"><spring:message code="surname" /></label>
                    <div class="controls">
                        <input type="text" name="lastName" id="lastName" maxlength="50" value="${userData.lastName}" required="true" disabled="true"/>
                    </div>
                    <label class="control-label"><spring:message code="email" /></label>
                    <div class="controls">
                        <input type="text" name="email" id="email" maxlength="50"  value="${userData.email}" required="true" disabled="true"/>
                    </div>
                    <label class="control-label"><spring:message code="role" /></label>
                    <div class="controls">
                        <input type="text" name="userRole" id="userRole" maxlength="20" value="${userData.userRole}" required="true" disabled="true"/>
                    </div>
                    <label class="control-label"><spring:message code="streetName" /></label>
                    <div class="controls">
                        <input type="text" name="streetName" id="streetName" maxlength="50" value="${userData.streetName}" required="true" disabled="true"/>
                    </div>
                    <label class="control-label"><spring:message code="streetNumber" /></label>
                    <div class="controls">
                        <input type="text" name="streetNumber" id="streetNumber" maxlength="10" value="${userData.streetNumber}" required="true" disabled="true"/>
                    </div>
                    <label class="control-label"><spring:message code="city" /></label>
                    <div class="controls">
                        <input type="text" name="city" id="city" maxlength="20" value="${userData.city}" required="true" disabled="true"/>
                    </div>
                    <label class="control-label"><spring:message code="zip" /></label>
                    <div class="controls">
                        <input type="text" name="zip" id="zip" maxlength="10" value="${userData.zip}" required="true" disabled="true"/>
                    </div>
                    <label class="control-label"><spring:message code="country" /></label>
                    <div class="controls">
                        <input type="text" name="country" id="country" maxlength="20" value="${userData.country}" required="true" disabled="true"/>
                    </div>
            </div>

            <div class="control-group">
                <div class="controls">
                    </label>
                    <button type="button" class="btn" onclick="changeAccount()"><spring:message code="change" /></button>
                    <button type="submit" class="btn" ><spring:message code="submit" /></button>
                </div>
                <div class="controls">
                    <button type="button" class="btn-small" onclick="displaySubAccountForm()"><spring:message code="subaccount" /></button>
                </div>
            </div>
        </form>

        <!-- creating sub accounts -->
        <form id="subAccountForm" class="form-horizontal" action="newSubAccount" method="post" onsubmit="return validateNewSubAccount();">
            <div class="control-group" hidden="true" id="subAccountRequestForm">
                <label class="label-info" id="newSubAccountLabel"><spring:message code="newSubAccount" /></label>
                <label class="control-label"><spring:message code="name" /></label>
                <div class="controls">
                    <input type="text" name="subUserView.firstName" id="subAccountFirstName" maxlength="30" required="true" title="User First name"/>
                </div>
                <label class="control-label"><spring:message code="surname" /></label>
                <div class="controls">
                    <input type="text" name="subUserView.lastName" id="subAccountLastName" maxlength="50" required="true"/>
                </div>

                <label class="control-label"><spring:message code="birthdate" /></label>
                <div class="controls">
                    <div style="float: left">
                        <label style="float: left;padding-right: 10px;padding-left: 10px"><spring:message code="day" /> </label>
                        <select id="subAccountBirthDay" name="subUserView.birthDay" style="width: 60px" >
                            <c:forEach var="item" items="${days}">
                                <option value="${item}">${item}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div style="float: left">
                        <label style="float: left;padding-right: 10px;padding-left: 10px"><spring:message code="month" /> </label>
                        <select id="subAccountBirthMonth" name="subUserView.birthMonth" style="width: 60px">
                            <c:forEach var="item" items="${months}">
                                <option value="${item}">${item}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div>
                        <label style="float: left;padding-right: 10px;padding-left: 10px"><spring:message code="year" /> </label>
                        <select id="subAccountBirthYear" name="subUserView.birthYear" style="width: 100px">
                            <c:forEach var="item" items="${years}">
                                <option value="${item}">${item}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <label class="control-label"><spring:message code="email" /></label>
                <div class="controls">
                    <input type="text" name="subUserView.email" id="subAccountEmail" maxlength="50" required="true"/>
                </div>
                <label class="control-label"><spring:message code="streetName" /></label>
                <div class="controls">
                    <input type="text" name="subUserView.streetName" id="subAccountStreetName" maxlength="50" required="true"/>
                </div>
                <label class="control-label"><spring:message code="streetNumber" /></label>
                <div class="controls">
                    <input type="text" name="subUserView.streetNumber" id="subAccountStreetNumber" maxlength="10" required="true"/>
                </div>
                <label class="control-label"><spring:message code="city" /></label>
                <div class="controls">
                    <input type="text" name="subUserView.city" id="subAccountCity" maxlength="20" required="true"/>
                </div>
                <label class="control-label"><spring:message code="zip" /></label>
                <div class="controls">
                    <input type="text" name="subUserView.zip" id="subAccountZip" maxlength="10" required="true"/>
                </div>
                <label class="control-label"><spring:message code="country" /></label>
                <div class="controls">
                    <input type="text" name="subUserView.country" id="subAccountCountry" maxlength="20" required="true"/>
                </div>
                <label class="control-label"><spring:message code="login" /></label>
                <div class="controls">
                    <input type="text" name="subUserView.username" id="subAccountUserName" maxlength="50" required="true" title="User login ID"/>
                    <label class="label-warning"><spring:message code="${loginExist}" /></label>
                </div>
            </div>
                <div class="control-group" hidden="true" id="subAccountButtons">
                    <div class="controls">
                    </label>
                    <button type="submit" class="btn" ><spring:message code="submit" /></button>
                </div>
            </div>
        </form>

        <!-- list of sub accounts  -->
        <jsp:include page="subAccounts.jsp" />
    </body>
</html>
