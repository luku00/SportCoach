<%-- 
    Document   : sportPlan
    Created on : Jan 12, 2014, 8:44:52 PM
    Author     : luku00
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </script>
</head>
<body>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="layout.jsp" />

    <div class="control-group">
        <div class="controls"><c:out value="${userData.username}" /></div>
        <div class="controls"><c:out value="${userData.firstName}" /> <c:out value="${userData.lastName}" /></div>
    </div>

        <h3>Sport plans</h3>
        <br/>
        <div class="controls">
            <button type="button" class="btn-small" onclick="displaySportPlanForm()"><spring:message code="newSportPlan" /></button>
        </div>
        <form id="newSportPlanForm" class="form-horizontal" action="newSportPlan/?user=${userData.username}" method="post">

        <div class="controls" hidden="true" id="newSportPlan">
            <label style="float: left;padding-right: 10px;padding-left: 10px"><spring:message code="fromDate" /> </label>
            <div class="controls">
                <input type="date" id="fromDate" name="fromDate" title="DD/MM/YYYY" required="true">
            </div>

            <label style="float: left;padding-right: 10px;padding-left: 10px"><spring:message code="toDate" /> </label>
            <div class="controls">
                <input type="date" id="toDate" name="toDate" title="DD/MM/YYYY" required="true">
            </div>

            <label style="float: left;padding-right: 10px;padding-left: 10px"><spring:message code="goal" /> </label>
            <div class="controls">
                <input type="text" id="goal" name="goal" required="true">
            </div>

            <label style="float: left;padding-right: 10px;padding-left: 10px"><spring:message code="goalType" /> </label>
            <div class="controls"><select id="goalType" name="goalType" style="width: 60px" >
                    <c:forEach var="item" items="${types}">
                        <option value="${item}">${item}</option>
                    </c:forEach>
                </select></div>

            <label style="float: left;padding-right: 10px;padding-left: 10px"><spring:message code="reward" /> </label>
            <div class="controls">
                <input type="text" id="reward" name="reward" >
            </div>

            <div class="controls">
                </label>
                <button type="submit" class="btn"><spring:message code="submit" /></button>
            </div>
        </div>
    </form>
    <form id="plansForm" class="form-horizontal">
        <div>
            <table class="table" id="plans">
                <c:forEach var="row" varStatus="status" items="${userData.plans}">
                    <tr class="row">
                        <td><c:out value="${row.fromDate}"/></td>
                        <td><c:out value="${row.toDate}"/></td>
                        <td><c:out value="${row.goalValue}"/></td>
                        <td><c:out value="${row.goalType}"/></td>
                        <td><c:out value="${row.reward}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </form>
</body>
</html>
