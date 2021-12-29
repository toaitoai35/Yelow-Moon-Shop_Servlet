
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
            <c:if test="${sessionScope.LOGIN.role != 'Admin'}">
                <c:redirect url="loginpage.jsp"></c:redirect>
            </c:if>
            
            ${requestScope.ERROR_CAKE.cakeNameError}
            ${requestScope.ERROR_CAKE.cakePriceError}
            ${requestScope.ERROR_CAKE.cakeExpirationDateError}
            ${requestScope.ERROR_CAKE.cakeQuantityError}
            
            <c:if test="${sessionScope.LOGIN.role == 'Admin'}">
                <h1>Welcome, ${sessionScope.LOGIN.username}</h1>
                <c:url var="logout" value="MainController">
                    <c:param name="btnAction" value="Logout"></c:param>
                </c:url>
            </c:if>

            &nbsp;<a href="${logout}">Logout</a>

        </c:if>

        <form action="MainController">
            Search: <input type="text" name="txtSearch" value="${param.txtSearch}" /><br/>
            Price: From <input placeholder="$Min" type="number" onkeyup="if (this.value < 0) {
                        this.value = this.value * -1
                    }" min="0" name="txtPriceFrom" value="${param.txtPriceFrom}"/>
            &nbsp;To <input placeholder="$Max" type="number" onkeyup="if (this.value < 0) {
                        this.value = this.value * -1
                    }" min="0" name="txtPriceTo" value="${param.txtPriceTo}"/><br/>
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
            <!--<input type="submit" value="Create New Cake" name="btnAction"/>-->
        </form>

        <c:url var="addCake" value="createNewCake.jsp">
            <c:param name="txtSearch" value="${param.txtSearch}"></c:param>
            <c:param name="txtPriceFrom" value="${param.txtPriceFrom}"></c:param>
            <c:param name="txtPriceTo" value="${param.txtPriceTo}"></c:param>
            <c:param name="cbxCategory" value="${param.cbxCategory}"></c:param>
        </c:url>    
        <a href="${addCake}">Create New Cake</a><br/>

        <c:set var="cakeList" value="${requestScope.CAKE_LIST}" />
        <c:set var="cakeError" value="${requestScope.ERROR_CAKE}"/>
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
                        <th>Quantity</th>
                        <th>Status</th>
                        <th>Last Update Date</th>
                        <th>Last User Update</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${cakeList}" varStatus="counter">
                    <form action="MainController" method="POST">
                        <tr>
                            <td>
                                ${counter.count}
                            </td>
                            <td>
                                <img src="<c:url value="/images/${dto.cakeImg}" />" width="200" height="150">
                                <input type="file" name="txtCakeImg" value="${dto.cakeImg}">
                            </td>
                            <td>
                                <!--${dto.cakeName}-->
                                <input type="text" name="txtCakeName" value="${dto.cakeName}"><br/>
                            </td>
                            <td>
                                <!--${dto.cakeDescription}-->
                                <input type="text" name="txtCakeDescription" value="${dto.cakeDescription}">
                            </td>
                            <td>
                                <!--${dto.cakeCategory}-->
                                <select name="cbxCakeCategory">
                                    <option value="${dto.cakeCategory}">${dto.cakeCategory}</option>
                                    <c:forEach var="cateDTO" items="${sessionScope.LOAD_CATEGORY}">
                                        <c:if test="${cateDTO.categoryName != dto.cakeCategory}">
                                            <option value="${cateDTO.categoryName}">${cateDTO.categoryName}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </td>
                            <td>
                                <input type="number" onkeyup="if (this.value < 0) {
                                            this.value = this.value * -1
                                        }" min="0" name="txtCakePrice" value="${dto.cakePrice}">
                            </td>
                            <td>
                                <!--${dto.cakeCreateDate}-->
                                <input type="date" name="txtCakeCreateDate" value="${dto.cakeCreateDate}">
                            </td>
                            <td>
                                <!--${dto.cakeExpirationDate}-->
                                <input type="date" name="txtCakeExpirationDate" value="${dto.cakeExpirationDate}">
                                <!--<input id="update" type="date" name="txtCakeExpirationDate" value="">-->
                            </td>
                            <td>
                                <!--${dto.cakeQuantity}-->
                                <input type="number" onkeyup="if (this.value < 0) {
                                            this.value = this.value * -1
                                        }" name="txtCakeQuantity" value="${dto.cakeQuantity}"/>
                            </td>
                            <td>
                                <!--${dto.cakeStatus}-->
                                <select name="cbxCakeStatus">
                                    <c:if test="${dto.cakeStatus == 'True'}">
                                        <option value="True">True</option>
                                        <option value="False">False</option>
                                    </c:if>
                                    <c:if test="${dto.cakeStatus != 'True'}">
                                        <option value="False">False</option>
                                        <option value="True">True</option>
                                    </c:if>
                                </select>
                            </td>
                            <td>
                                <!--${dto.cakeLastUpdateDate}-->
                                <c:if test="${not empty dto.cakeLastUpdateDate}">
                                    <!--<input type="date" name="txtCakeLastUpdateDate" value="${dto.cakeLastUpdateDate}">-->
                                    ${dto.cakeLastUpdateDate}
                                </c:if>
                                <c:if test="${empty dto.cakeLastUpdateDate}">
                                    ---
                                </c:if>
                            </td>
                            <td>
                                <!--${dto.cakeLastUpdateUser}-->
                                <c:if test="${not empty dto.cakeLastUpdateUser}">
                                    ${dto.cakeLastUpdateUser}
                                    <!--<input type="text" name="txtCakeLastUpdateUser" value="${dto.cakeLastUpdateUser}">-->
                                </c:if>
                                <c:if test="${empty dto.cakeLastUpdateUser}">
                                    ---
                                </c:if>
                            </td>
                            <td>
                                <input type="hidden" name="txtCakeID" value="${dto.cakeID}">
                                <input type="hidden" name="txtSearch" value="${param.txtSearch}">
                                <input type="hidden" name="txtPriceTo" value="${param.txtPriceTo}">
                                <input type="hidden" name="txtPriceFrom" value="${param.txtPriceFrom}">
                                <input type="hidden" name="cbxCategory" value="${param.cbxCategory}">
                                <input type="submit" value="Update" name="btnAction"/>
                    </form>
                </td>
            </tr>
        </form>
    </c:forEach>
</tbody>
</table>

</c:if>
<c:if test="${empty cakeList}">
    No record is matched
</c:if>
</body>
</html>
