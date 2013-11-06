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
        <jsp:include page="layout.jsp" />
        <form id="paymentForm" class="form-horizontal" action="save" method="post">
            <div class="control-group">
                <label class="control-label"><spring:message code="name" /></label>
                <div class="controls">
                    <input type="text" name="firstName" id="firstName" maxlength="50" required="true"/>
                </div>
                <label class="control-label"><spring:message code="surname" /></label>
                <div class="controls">
                    <input type="text" name="lastName" id="lastName" maxlength="50" required="true"/>
                </div>
                <div class="controls">
                    <input type="text" name="login" id="login" maxlength="50" required="true"/>
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
