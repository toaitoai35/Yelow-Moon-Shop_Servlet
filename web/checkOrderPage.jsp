
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            #sub {
                float: left;
                width: 20%;
                margin-left: 2%;
                margin-top: 1%;
            }
            #container {
                width: 100%;
                float: left;
            }
            #information {
                float: left;
                width: 30%;
                margin-left: 2%;
                margin-top: 1%;
            }
        </style>
    </head>
    <body>
        <c:if test="${sessionScope.LOGIN == null}">
            <a href="loginpage.jsp">Login</a>
        </c:if>

        <c:if test="${sessionScope.LOGIN != null}">
            <c:if test="${sessionScope.LOGIN.role != 'User'}">
                <c:redirect url="loginpage.jsp"></c:redirect>
            </c:if>

            <c:if test="${sessionScope.LOGIN.role == 'User'}">
                <h1>Welcome, ${sessionScope.LOGIN.username}</h1>
                <c:url var="logout" value="MainController">
                    <c:param name="btnAction" value="Logout"></c:param>
                </c:url>
            </c:if>

            &nbsp;<a href="${logout}">Logout</a> <br/>

            <c:url var="back" value="MainController">
                <c:param name="btnAction" value="Search"></c:param>
                <c:param name="txtSearch" value="${param.txtSearch}"></c:param>
                <c:param name="txtPriceFrom" value="${param.txtPriceFrom}"></c:param>
                <c:param name="txtPriceTo" value="${param.txtPriceTo}"></c:param>
                <c:param name="cbxCategory" value="${param.cbxCategory}"></c:param>
            </c:url>
            <a href="${back}">Back to shopping</a>
            
            <form action="MainController">
                Search: <input type="text" name="txtSearchOrder" value="${param.txtSearchOrder}" /><br/>
                <input type="submit" value="SearchOrder" name="btnAction"/>
            </form>

            <c:set var="orderList" value="${requestScope.ORDER_LIST.orderListCake}"/>
            <c:forEach var="items" items="${orderList}">
                <div id="container">
                    <div id="sub">
                        <img src="<c:url value="/images/${items.cakeImg}" />" width="200" height="150">
                    </div>
                    <div id="sub">
                        ${items.cakeName}
                    </div>
                    <div id="sub">
                        Quantity: ${items.cakeQuantity}
                    </div>
                    <div id="sub">
                        ${items.cakePrice}$
                    </div>
                </div>
            </c:forEach>

            <c:if test="${not empty requestScope.ORDER_LIST}">
                <div id="information">
                    <p>Information Order</p>
                    OrderID: <span>${requestScope.ORDER_LIST.orderID}</span><br/>
                    CreateDate: <span>${requestScope.ORDER_LIST.orderCreateDate}</span><br/>
                    Order status: <c:if test="${requestScope.ORDER_LIST.orderStatus == 'True'}" >
                        <span>Processed</span>
                    </c:if>
                    <c:if test="${requestScope.ORDER_LIST.orderStatus == 'False'}" >
                        <span>Not Process</span>
                    </c:if>
                </div>

                <div id="information">
                    <p>Information Payment</p>
                    Username: <span>${requestScope.ORDER_LIST.orderUserName}</span><br/>
                    Address: <span>${requestScope.ORDER_LIST.address}</span><br/>
                    Payment method: <span>${requestScope.ORDER_LIST.orderPayment}</span>
                </div>
            </c:if>
        </c:if>
    </body>
</html>
