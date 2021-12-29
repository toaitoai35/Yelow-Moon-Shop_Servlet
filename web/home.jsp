
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
            <a href="checkOrderPage.jsp">Order Tracking</a>
            
        </c:if>
        
        <c:if test="${sessionScope.CART != null}">
            <c:url var="view" value="MainController">
                <c:param name="btnAction" value="View"></c:param>
                <c:param name="txtSearch" value="${param.txtSearch}"></c:param>
                <c:param name="txtPriceFrom" value="${param.txtPriceFrom}"></c:param>
                <c:param name="txtPriceTo" value="${param.txtPriceTo}"></c:param>
                <c:param name="cbxCategory" value="${param.cbxCategory}"></c:param>
            </c:url>
            <a href="${view}">Cart</a>
        </c:if>    
            
        <form action="MainController">
            Search: <input type="text" name="txtSearch" value="${param.txtSearch}" /><br/>
            Price: From <input placeholder="$Min" min="0" type="number" onkeyup="if(this.value<0){this.value= this.value * -1}" name="txtPriceFrom" value="${param.txtPriceFrom}"/>
            &nbsp;To <input placeholder="$Max" min="0" type="number" onkeyup="if(this.value<0){this.value= this.value * -1}" name="txtPriceTo" value="${param.txtPriceTo}"/><br/>
            <c:if test="${sessionScope.LOAD_CATEGORY != null}">
                Category:<select name="cbxCategory">
                    <c:if test="${not empty param.cbxCategory}">
                        <option value="${param.cbxCategory}">${param.cbxCategory}</option>
                        <c:forEach var="cate" items="${sessionScope.LOAD_CATEGORY}">
                            <option value="${cate.categoryName}">${cate.categoryName}</option>
                        </c:forEach>
                        <option value="">Any</option>
                    </c:if>
                    <c:if test="${empty param.cbxCategory}">
                        <option value="">Any</option>
                        <c:forEach var="cate" items="${sessionScope.LOAD_CATEGORY}">
                            <option value="${cate.categoryName}">${cate.categoryName}</option>
                        </c:forEach>
                    </c:if>
                </select>
            </c:if>
            <input type="submit" value="Search" name="btnAction"/>
        </form>

        <c:set var="searchValue" value="${param.txtSearch}" />
        <c:set var="priceFrom" value="${param.txtPriceFrom}" />
        <c:set var="priceTo" value="${param.txtPriceTo}" />
        <c:set var="category" value="${param.cbxCategory}" />
        <%--<c:if test="${not empty searchValue or not empty priceFrom or not empty priceTo or not empty category}">--%>
        <c:set var="cakeList" value="${requestScope.CAKE_LIST}" />
            <c:if test="${not empty cakeList}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Image</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Category</th>
                            <th>Price</th>
                            <th>Create Date</th>
                            <th>Expiration Date</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${cakeList}" varStatus="counter">
                            <tr>
                                <td>
                                    ${counter.count}
                                </td>
                                <td>
                                    <img src="<c:url value="/images/${dto.cakeImg}" />" width="200" height="150">
                                    <!--${dto.cakeImg}-->
                                </td>
                                <td>
                                    ${dto.cakeName}
                                </td>
                                <td>
                                    ${dto.cakeDescription}
                                </td>
                                <td>
                                    ${dto.cakeCategory}
                                </td>
                                <td>
                                    ${dto.cakePrice}$
                                </td>
                                <td>
                                    ${dto.cakeCreateDate}
                                </td>
                                <td>
                                    ${dto.cakeExpirationDate}
                                </td>
                                <td>
                                    <form action="MainController">
                                        <input type="hidden" name="txtCakeID" value="${dto.cakeID}"/>
                                        <input type="hidden" name="txtCakeName" value="${dto.cakeName}"/>
                                        <input type="hidden" name="txtCakeImg" value="${dto.cakeImg}"/>
                                        <input type="hidden" name="txtCakePrice" value="${dto.cakePrice}"/>
                                        <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
                                        <input type="hidden" name="txtPriceFrom" value="${param.txtPriceFrom}"/>
                                        <input type="hidden" name="txtPriceTo" value="${param.txtPriceTo}"/>
                                        <input type="hidden" name="cbxCategory" value="${param.cbxCategory}"/>
                                        <input type="submit" name="btnAction" value="Add to Cart"/>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </c:if>
            <c:if test="${empty cakeList}">
                No record is matched
            </c:if>
        <%--</c:if>--%>
               
    </body>
</html>
