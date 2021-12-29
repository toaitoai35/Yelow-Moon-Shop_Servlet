

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Detail</title>
        <script>
            function deleteCake() {
                var result = confirm("Remove this cake from cart?");
                
                if (result) {
                    document.getElementById("myForm").submit();
                }
                else {
                    
                }
            }
        </script>
    </head>
    <body>
        <h1>Your Order Details: </h1>
        <c:url var="back" value="MainController">
            <c:param name="btnAction" value="Search"></c:param>
            <c:param name="txtSearch" value="${param.txtSearch}"></c:param>
            <c:param name="txtPriceFrom" value="${param.txtPriceFrom}"></c:param>
            <c:param name="txtPriceTo" value="${param.txtPriceTo}"></c:param>
            <c:param name="cbxCategory" value="${param.cbxCategory}"></c:param>
        </c:url>
        <a href="${back}">Back to shopping</a><br/>
        ${requestScope.MESSAGE}
        <c:if test="${sessionScope.CART != null}">
            <c:set var="total" value="0"></c:set>
            <c:set var="cart" value="${sessionScope.CART}"></c:set>
                <table border="1" width="100%">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Image</th>
                            <th>Bookname</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Total</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="dto" varStatus="counter" items="${cart.cart.values()}">
                    <input type="hidden" name="" value="${total = total + dto.cakePrice * dto.cakeQuantity}" />
                        <tr>
                            <td>
                                <p>${counter.count}</p>
                            </td>
                            <td><img src="<c:url value="/images/${dto.cakeImg}" />" width="200" height="150">
                            <td>
                                <p>${dto.cakeName}</p>
                            </td>
                            <form action="MainController">
                                <td>
                                    <p><input type="number" onkeyup="if (this.value < 0) {
                                            this.value = this.value * -1
                                        }" min="1" name="txtQuantity" value="${dto.cakeQuantity}" /></p>
                                </td>
                                <td>
                                    <p>${dto.cakePrice}</p>
                                </td>
                                <td>
                                    <p>${dto.cakePrice * dto.cakeQuantity}</p>
                                </td>
                                <td>
                                    <input type="hidden" name="txtCakeID" value="${dto.cakeID}" />
                                    <p><input type="submit"  name="btnAction" value="Update Order" /></p>
                                </td>
                            </form>
                            <td>
                                <form action="MainController" id="myForm">
                                    <input type="hidden" name="txtCakeID" value="${dto.cakeID}" />
                                    <input type="hidden" name="btnAction" value="Delete Order" />
                                    <p><input type="button" value="Delete Order" onclick="deleteCake()"/></p>
                                </form>
                            </td>
                        </tr>
                </c:forEach>
            </tbody>
        </table>
        <h1>Total: ${total}</h1>
        <form action="MainController">
            <c:if test="${sessionScope.LOGIN.role != 'User'}">
                Phone:<input type="text" name="txtPhone" value="${param.txtPhone}"/>
                Name:<input type="text" name="txtName" value="${param.txtName}"/>
                Address:<input type="text" name="txtAddress" value="${param.txtAddress}"/>
                <input type="hidden" name="txtTotal" value="${total}" />
                <input type="hidden" name="txtSearch" value="${param.txtSearch}" />
                <input type="submit" name="btnAction" value="Checkout" />
            </c:if>
            <c:if test="${sessionScope.LOGIN.role == 'User'}">
                <input type="hidden" name="txtTotal" value="${total}" />
                <input type="hidden" name="txtSearch" value="${param.txtSearch}" />
                <input type="submit" name="btnAction" value="Checkout" />
            </c:if>
        </form>
    </c:if>
    <c:if test="${empty sessionScope.CART}">
        Nothing here
    </c:if>
</body>
</html>
