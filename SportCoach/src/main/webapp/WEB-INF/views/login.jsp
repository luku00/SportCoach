<%--
    Document   : login
    Created on : Nov 23, 2013, 9:04:02 PM
    Author     : luku00
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User login</title>
    </head>
    <body>
        <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <jsp:include page="layout.jsp" />
        <form id="userLoginForm" class="form-horizontal" action="" method="post">
            <c:if test="${param.error != null}">
                <div class="alert alert-error">
                    <spring:message code="loginError" />
                </div>
            </c:if>
            <div class="control-group">
                <label class="control-label"><spring:message code="login" /></label>
                <div class="controls">
                    <input type="text" name="username" id="username" maxlength="50" required="true" title="User login ID"/>
                </div>
                <label class="control-label"><spring:message code="password" /></label>
                <div class="controls">
                    <input type="password" name="password" id="password" maxlength="50" required="true"/>
                </div>
            </div>
            <div class="control-group">
                <div class="controls">
                    </label>
                    <button type="submit" class="btn"><spring:message code="submit" /></button>
                </div>
            </div>
                    <div class="control-group">
                        <a href="/SportCoach/user/forgotPassword/"><spring:message code="forgotPassword" /></a>
                    </div>
        </form>
    </body>
</html>
