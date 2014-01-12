<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sport Coach</title>
    </head>
    <body>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
        <jsp:include page="layout.jsp" />

        <form id="passwordReset" class="form-horizontal" action="" method="post" onsubmit="return validatePasswordChange();">
            <div class="control-group">
                <label class="control-label"><spring:message code="password" /></label>
                <div class="controls">
                    <input type="password" name="passwd1" id="passwd1" maxlength="50" required="true"/>
                </div>
                <label class="control-label"><spring:message code="password" /></label>
                <div class="controls">
                    <input type="password" name="passwd2" id="passwd2" maxlength="50" required="true"/>
                </div>
            </div>
            <div class="control-group">
                <div class="controls">
                    </label>
                    <button type="submit" class="btn"><spring:message code="submit" /></button>
                </div>
            </div>
            <label class="label-success"><spring:message code="${passwordChangeDone}" /></label>
        </form>
    </body>
</html>
