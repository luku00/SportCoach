<%-- 
    Document   : activityList
    Created on : Feb 1, 2014, 8:33:00 PM
    Author     : luku00
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <div>
            <table class="table" id="activity">
                <tr class="row">
                    <th><spring:message code="activity_Id" /></th>
                    <th><spring:message code="activity_Sport" /></th>
                    <th><spring:message code="activity_Started" /></th>
                    <th><spring:message code="activity_Duration" /></th>
                    <th><spring:message code="activity_Distance" /></th>
                    <th><spring:message code="activity_KCAL" /></th>
                </tr>
                <c:forEach var="row" varStatus="status" items="${activities}">
                    <tr class="row">
                        <td><c:out value="${row.id}"/></td>
                        <td><c:out value="${row.type}"/></td>
                        <td><c:out value="${row.start}"/></td>
                        <td><c:out value="${row.duration}"/></td>
                        <td><c:out value="${row.distance}"/></td>
                        <td><c:out value="${row.kcal}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
