<%--
    Document   : subAccounts
    Created on : Dec 16, 2013, 8:14:16 PM
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
            <table class="table" id="subAccounts">
                <c:forEach var="row" varStatus="status" items="${userData.subAccounts}">
                    <tr class="row">
                        <td><c:out value="${row.username}"/></td>
                        <td><c:out value="${row.firstName} ${row.lastName}"/></td>
                        <td><c:out value="${row.email}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
