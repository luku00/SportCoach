<%--
    Document   : newAccount
    Created on : Nov 6, 2013, 9:02:08 AM
    Author     : luku00
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New user account</title>
    </head>
    <body>
        <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <jsp:include page="layout.jsp" />
        <label class="control-label"><spring:message code="${userCreated}" /></label>
        <form id="newAccountForm" class="form-horizontal" action="save" method="post" onsubmit="return validateNewAccount();">
            <div class="control-group">
                <label class="control-label"><spring:message code="name" /></label>
                <div class="controls">
                    <input type="text" name="firstName" id="firstName" maxlength="50" required="true" value="${userV.firstName}" />
                </div>
                <label class="control-label"><spring:message code="surname" /></label>
                <div class="controls">
                    <input type="text" name="lastName" id="lastName" maxlength="50" value="${userV.lastName}" required="true"/>
                </div>

                    <label class="control-label"><spring:message code="birthdate" /></label>
                    <div class="controls">
                        <div style="float: left">
                            <label style="float: left;padding-right: 10px;padding-left: 10px"><spring:message code="day" /> </label>
                            <select id="birthDay" name="birthDay" style="width: 60px" >
                                <c:forEach var="item" items="${days}">
                                    <option value="${item}">${item}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div style="float: left">
                            <label style="float: left;padding-right: 10px;padding-left: 10px"><spring:message code="month" /> </label>
                            <select id="birthMonth" name="birthMonth" style="width: 60px">
                                <c:forEach var="item" items="${months}">
                                    <option value="${item}">${item}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div>
                            <label style="float: left;padding-right: 10px;padding-left: 10px"><spring:message code="year" /> </label>
                            <select id="birthYear" name="birthYear" style="width: 100px">
                                <c:forEach var="item" items="${years}">
                                    <option value="${item}">${item}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                <label class="control-label"><spring:message code="email" /></label>
                <div class="controls">
                    <input type="text" name="email" id="email" maxlength="50"  value="${userV.email}" required="true"/>
                </div>
                <label class="control-label"><spring:message code="streetName" /></label>
                <div class="controls">
                    <input type="text" name="streetName" id="streetName" maxlength="50" value="${userV.streetName}" required="true"/>
                </div>
                <label class="control-label"><spring:message code="streetNumber" /></label>
                <div class="controls">
                    <input type="text" name="streetNumber" id="streetNumber" maxlength="10" value="${userV.streetNumber}" required="true"/>
                </div>
                <label class="control-label"><spring:message code="city" /></label>
                <div class="controls">
                    <input type="text" name="city" id="city" maxlength="20" value="${userV.city}" required="true"/>
                </div>
                <label class="control-label"><spring:message code="zip" /></label>
                <div class="controls">
                    <input type="text" name="zip" id="zip" maxlength="10" value="${userV.zip}" required="true"/>
                </div>
                <label class="control-label"><spring:message code="country" /></label>
                <div class="controls">
                    <input type="text" name="country" id="country" maxlength="20" value="${userV.country}" required="true"/>
                </div>

                <label class="control-label"><spring:message code="role" /></label>
                <div class="controls">
                    <select id="userRole" name="userRole">
                        <c:forEach var="item" items="${roles}">
                            <option value="${item}">${item}</option>
                        </c:forEach>
                    </select>
                </div>
                <label class="control-label"><spring:message code="login" /></label>
                <div class="controls">
                    <input type="text" name="login" id="login" maxlength="50" required="true" title="User login ID"/>
                    <label class="control-label"><spring:message code="${loginExist}" /></label>
                </div>
                <label class="control-label"><spring:message code="password" /></label>
                <div class="controls">
                    <input type="password" name="password" id="password" maxlength="50" required="true"/>
                </div>
                <label class="control-label"><spring:message code="password" /></label>
                <div class="controls">
                    <input type="password" name="password1" id="password1" maxlength="50" required="true"/>
                </div>
            </div>
            <div class="control-group">
                <div class="controls">
                    </label>
                    <button type="submit" class="btn"><spring:message code="submit" /></button>
                </div>
            </div>
        </form>
    </body>
</html>
