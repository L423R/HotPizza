<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12.08.2018
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="order">

        <div id="order_list">
            <c:forEach var="item" items="${orderItems}">
            <p class="item_link">${item}  </p>
            </c:forEach>
        </div>
        <%--<a href="<c:url value="/pizza_home/payment">">ОПЛАТИТЬ</a>--%>
         <a id="cart" href="<c:url value="/pizza_home/payment"/>">Сделать заказ</a>


    <style>

        .item_link {

            font-size: 110%;

        }

        .order {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-content: center;
            align-items: center;
            min-height: 60%;
        }

        #order_list {
            max-width: 200px;
            flex: 1 0 auto;
        }

        .order a {
            flex: 0 0 auto;
            text-decoration: none;
            font-size: 150%;

            padding: 15px;
            background-color: #ff4a1e;
            color: #adb4ad;
            font-family: initial;
            border-radius: 45px;

        }
    </style>

</div>


