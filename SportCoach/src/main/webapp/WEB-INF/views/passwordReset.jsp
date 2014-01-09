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

        <form id="passwordReset" class="form-horizontal" action="" method="post">
            <div class="control-group">
                <label class="control-label"><spring:message code="loginOrEmail" /></label>
                <div class="controls">
                    <input type="text" name="loginOrEmail" id="loginOrEmail" maxlength="50" required="true" title="User login or email"/>
                </div>
            </div>
            <div class="control-group">
                <div class="controls">
                    </label>
                    <button type="submit" class="btn"><spring:message code="submit" /></button>
                </div>
            </div>
                    <label class="label-success"><spring:message code="${passwordResetRequested}" /></label>
                    <label class="label-warning"><spring:message code="${passwordResetRequestFailed}" /></label>
        </form>
    </body>
</html>
