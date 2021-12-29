
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>This is your ORDER ID: ${requestScope.ORDERID}. Please keep it to track your order</h1>
        <c:if test="${not empty requestScope.USER_DETAIL}">
            Your user id: ${requestScope.USER_DETAIL.userid} and password: ${requestScope.USER_DETAIL.password}
        </c:if>
        <c:url var="back" value="MainController">
            <c:param name="btnAction" value="Search"></c:param>
            <c:param name="txtSearch" value="${param.txtSearch}"></c:param>
            <c:param name="txtPriceFrom" value="${param.txtPriceFrom}"></c:param>
            <c:param name="txtPriceTo" value="${param.txtPriceTo}"></c:param>
            <c:param name="cbxCategory" value="${param.cbxCategory}"></c:param>
        </c:url>
        <a href="${back}">Home</a>
    </body>
</html>
