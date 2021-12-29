
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="MainController" method="POST">
            Name: <input type="text" name="txtCakeName" value="${param.txtCakeName}"><br/>
            ${requestScope.ERROR_CAKE.cakeNameError}
            Image: <input type="file" name="txtCakeImg" value="${param.txtCakeImg}"><br/>
            Description: <input type="text" name="txtCakeDescription" value="${param.txtCakeDescription}"><br/>
            ${requestScope.ERROR_CAKE.cakeDescriptionError}
            Price: <input type="number" onkeyup="if (this.value < 0) {
                        this.value = this.value * -1
                    }" min="0" name="txtCakePrice" value="${param.txtCakePrice}"><br/>
            ${requestScope.ERROR_CAKE.cakePriceError}
            CreateDate: <input type="date" name="txtCakeCreateDate" value="${param.txtCakeCreateDate}"><br/>
            ExpirationDate: <input type="date" name="txtCakeExpirationDate" value="${param.txtCakeExpirationDate}"><br/>
            ${requestScope.ERROR_CAKE.cakeExpirationDateError}
            Category:<select name="cbxCategoryCreate">
                <c:forEach var="cate" items="${sessionScope.LOAD_CATEGORY}">
                    <option value="${cate.categoryName}">${cate.categoryName}</option>
                </c:forEach>
            </select><br/>
            Quantity: <input type="number" onkeyup="if (this.value < 0) {
                        this.value = this.value * -1
                    }" min="0" name="txtCakeQuantity" value="${dto.cakeQuantity}"/><br/>
            ${requestScope.ERROR_CAKE.cakeQuantityError}
            Status: <select name="cbxCakeStatus">
                <option value="True">True</option>
                <option value="False">False</option>
            </select><br/>
            <input type="hidden" name="txtSearch" value="${param.txtSearch}" />
            <input type="hidden" name="txtPriceFrom" value="${param.txtPriceFrom}" />
            <input type="hidden" name="txtPriceTo" value="${param.txtPriceTo}" />
            <input type="hidden" name="cbxCategory" value="${param.cbxCategory}" />
            <input type="reset" value="Reset"/>
            <input type="submit" value="Create" name="btnAction"/>
        </form>
            
        <c:url var="back" value="MainController">
            <c:param name="btnAction" value="Search"></c:param>
            <c:param name="txtSearch" value="${param.txtSearch}"></c:param>
            <c:param name="txtPriceFrom" value="${param.txtPriceFrom}"></c:param>
            <c:param name="txtPriceTo" value="${param.txtPriceTo}"></c:param>
            <c:param name="cbxCategory" value="${param.cbxCategory}"></c:param>
        </c:url>
        <a href="${back}">Back</a>
    </body>
</html>
