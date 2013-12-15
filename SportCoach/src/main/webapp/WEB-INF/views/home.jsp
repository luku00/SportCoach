<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sport Coach</title>
    </head>
    <body>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <jsp:include page="layout.jsp" />
        <c:if test="${param.logout != null}">
            <div class="alert-info">
                <spring:message code="successLogout" />
            </div>
        </c:if>
        <a href="<c:url value="j_spring_security_logout" />"/>

        <!--        <form id="paymentForm" class="form-horizontal" action="save" method="post">
                    <div class="control-group">
                            <label class="control-label" for="firstName">First name</label>
                            <div class="controls">
                                <input type="text" name="firstName" id="firstName" placeholder="First name" maxlength="50" required>
                            </div>
                    </div>
                </form>-->
    </body>
</html>
