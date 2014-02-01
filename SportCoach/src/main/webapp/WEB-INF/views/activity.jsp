<%-- 
    Document   : activity
    Created on : Feb 1, 2014, 5:35:34 PM
    Author     : luku00
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Activity</title>
    </head>
    <body>
        <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <jsp:include page="layout.jsp" />
        <form method="post" enctype="multipart/form-data" modelAttribute="uploadedFile" action="fileUpload">
            <div class="controls">
                <label style="float: left;padding-right: 10px;padding-left: 10px"><spring:message code="activityType" /> </label>
                <select id="activityType" name="activityType" style="width: 110px" >
                    <c:forEach var="item" items="${activityTypes}">
                        <option value="${item.activityType}">${item.activityType}</option>
                    </c:forEach>
                </select>
                </br>
                Please select a file to upload : <input type="file" name="file" />
                <form:errors path="file" />

                <input type="submit" value="Upload" />
            </div>
        </form>
                <!-- list of sub accounts  -->
                <%--<jsp:include page="activityList.jsp" />--%>
    </body>
</html>
