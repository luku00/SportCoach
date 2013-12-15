
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:f="http://java.sun.com/jsf/core"
      xmlns:h="http://java.sun.com/jsf/html">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sport coach</title>
        <link href="/SportCoach/resources/css/bootstrap.css" rel="stylesheet">
        <link href="/SportCoach/resources/css/bootstrap-responsive.css" rel="stylesheet">
        <script type="text/javascript" src="/SportCoach/resources/js/jquery-1.8.3.min.js"></script>
        <script type="text/javascript" src="/SportCoach/resources/js/common.js"></script>
        <style>
            body {
                padding-top: 60px;
            }
        </style>
    </head>
    <body>
        <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="brand" href="/SportCoach/">Sport COACH</a>
                    <div class="nav-collapse collapse">
                        <ul class="nav">
                            <li><a href="/SportCoach/account/new/"><spring:message code="newRegistration" /></a></li>
                            <li><a href="/SportCoach/account/admin/"><spring:message code="accountAdmin" /></a></li>
                                <c:if test="${pageContext.request.remoteUser != null}">
                                <li><a href="<c:url value="/logout" />"><spring:message code="logout" /></a></li>
                                <li>
                                    <c:out value="${pageContext.request.remoteUser}"/>
                                </li>
                            </c:if>
                                <!--<li></li>-->
                                <!--              <li><a href="/demo/payment/list">Payment list</a></li>
                            <li><a href="/demo/nsa/payments">NSA</a></li>
                            <li><a href="/demo/nsa/list">NSA list</a></li>
                            <li><a href="/demo/payment/problem">Problem</a></li>
                            <li><a href="/demo/nsa/longpolling">Long polling</a></li>-->
                        </ul>
                    </div><!--/.nav-collapse -->
                </div>
            </div>
        </div>
        <div class="container">

        </div>
    </body>
</html>
