<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
<div class="content">

        <div class="right-side">
            <a href="#pizza_id" title="Support" >Пицца</a>
            <a href="#drink_id" title="Support" >Напитки</a>
            <a href="" title="Support" >Салаты</a>

        </div>


        <div id="my_item" class="center-side">

            <%--<output id="output1">${cashFromCart}</output>--%>
            <h1 id="pizza_id">ПИЦЦА</h1>
            <br/><br>
            <div class="flex">


                <c:forEach  var="items" items="${itemPizza}" varStatus="loop">


                    <%--<c:if test="${not loop.first and loop.index % 3 == 0}">
                    </tr><tr>
                    </c:if>--%>
                    <%--<tr><th>текст заголовка</th><th>текст заголовка</th></tr> <!--ряд с ячейками заголовков-->
                    <tr><td>данные</td><td>данные</td></tr> <!--ряд с ячейками тела таблицы-->--%>
                    <div class="item" id="pizza${items.id}">

                        <img  src="/resources/img/${items.imgPath}.jpg" title="PICTION"/>
                        <p class="p_center">${items.name}</p>
                        <p class="p_center">${items.price}</p>
                        <p class="p_center">${items.description}</p>
                        <a href="#pizza" class="myButton" onclick='add_to_order(${items.id},"pizza")'>Добавить в корзину</a>
                            <%--<input  type="button" class="button1" value="Заказать" onclick='add_to_order("${items.name}","${clazz}")'>--%>
                    </div>
                </c:forEach>
            </div>
            <br/>
            <h1 id="drink_id">DRINK</h1>
            <br/>
            <div class="flex">

                <c:forEach  var="items" items="${itemDrink}" varStatus="loop">


                    <%--<c:if test="${not loop.first and loop.index % 3 == 0}">
                    </tr><tr>
                    </c:if>--%>
                    <%--<tr><th>текст заголовка</th><th>текст заголовка</th></tr> <!--ряд с ячейками заголовков-->
                    <tr><td>данные</td><td>данные</td></tr> <!--ряд с ячейками тела таблицы-->--%>
                    <div class="item">

                        <img  src="/resources/img/${items.imgPath}.jpg" title="PICTION"/>
                        <p class="p_center">${items.name}</p>
                        <p class="p_center">${items.price}</p>
                        <p class="p_center">${items.description}</p>
                        <a href="#drink" class="myButton" onclick='add_to_order("${items.id}","drink")'>Добавить в корзину</a>
                            <%--<input  type="button" class="button1" value="Заказать" onclick='add_to_order("${items.name}","${clazz}")'>--%>
                    </div>
                </c:forEach>
            </div>
        </div>

    <style>

        .right-side {
            display: flex;
            flex-direction: column;
            align-content: left;
        }

        .right-side a {
            color:#fff; padding:15px 10px; text-decoration:none; text-align:center; background: #adb4ad;
        }
        .right-side a:hover { background: #4c4849; }

        .content{
            display: flex;
            flex-direction: row;
            text-align: center;
        }

        .right-side {
            flex: 0.5 0 auto;
        }

        .center-side {
            flex: 2 0 auto;
        }

        .flex{
            display: flex;
            flex-wrap: wrap;

            max-width: 1000px; /* макс ширина */
            margin: 0 auto; /* выровняем по центру */
        }

        .item{
            flex:1 1 calc(33.33% - 30px); /* отнимем margin и скажем растягиваться */
            margin:5px;
            box-sizing:border-box; /* чтобы внутренний отступ не влиял когда там будет текст... */
            min-width:170px; /* мин. ширина блока, чтобы переносились на другой ряд */

            padding:50px 20px;  text-align:center; /*background:#b5ced8;*/ /* для красоты */
        }
    </style>
</div>
