<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>

<script>

    $(document).ready(function($) {
        $(window).scroll(function(){
            if($(this).scrollTop()>140){
                $('.navv').addClass('fixed');
            }
            else if ($(this).scrollTop()<140){
                $('.navv').removeClass('fixed');
            }
        });
    });

</script>

<p class="title_header">Горячая пицца с доставкой</p>


<span id="login_span">

    <c:if test="${user==null}">
        <form:form modelAttribute="singin" acceptCharset="UTF-8" method="post" action="/pizza_home/singin" >
        <label for="username">Логин</label>
        <form:input id="username" path="login" type="text"/>
        <label for="password">Пароль</label>
        <form:password id="password" path="password" />
        <input name="commit" type="submit" value="Войти"/>
        <a href="">Зарегистрироваться</a>
        </form:form>
    </c:if>
    <c:if test="${user!=null}">
        <span class="glyphicon-log-out">
            <output>Добро пожаловать, ${user.login}!</output>
            <a href="<c:url value="/pizza_home/logout"/>">Выйти</a>
        </span>
    </c:if>
</span>

<div class="navv">
    <a id="first_link" href="<c:url value="/pizza_home/"/>">Главная</a>
    <a href="#">О нас</a>
    <a href="#">Доставка</a>
    <a id="last_link" href="#">Контакты</a>
    <div id="cart_container">
        <a id="cart" href="<c:url value="/pizza_home/get_order"/>">
            <span class="icon_cart"></span>
            <span id="cart_span">Корзина на: </span>
            <output id="output1">${cashFromCart}</output>
        </a>
       <%-- <div class="cart-content" style="display: block;opacity: 1;margin-top: 0px;">

        </div>--%>
    </div>
</div>

<style>

    /*#cart_container {
        position: absolute;
        right: 0;
        bottom: 0;
        width: 210px;
        height: 70px;
        background: transparent;
        border-top-left-radius: 3px;
    }

    .cart-content {
        width: 300px;
        background-color: #faf4e6;
        position: absolute;
        !* opacity: 0; *!
        !* top: 100%; *!
        margin-top: 10px;
        right: 0;
        border-bottom-left-radius: 3px;
        padding: 25px;
        !* z-index: 100; *!
    }*/

    .title_header {
        font-size: 32px;
        color: black;
        font-weight: 600;
        text-shadow: 1px 1px 2px white, 0 0 1em red;
    }

    .navv {
        display: flex;
        justify-content: center; /* разместим center */
        font-size: 20px;
        margin-top: 15px;
        opacity: 0.90;
        /*background: #6e9cc3;*/
       /* border-left-width: 1px !important;
        border-right-width: 1px !important;
        border-left-color: #de0300;
        border-radius: 5px 0 0 5px;*/
    }

    .navv.fixed{
        position: fixed;
        top: 0;
        width: 100%;
        /*background: rgba(239, 5, 5, 0.95);*/
    }

    #first_link {
        border-radius: 45px 0 0 45px;
    }

    #last_link {
        border-radius: 0 45px 45px 0;
    }



    .navv > a {
        color:#fff; padding:15px 10px; text-decoration:none; text-align:center; background: #adb4ad; text-shadow: 1px 1px 2px black;
    }
    .navv > a:hover { background: #4c4849; }

    #cart_container {
        display: inline;
        padding-left: 30%;
        position: absolute;
        right: 50px;
    }

    #cart {
        font-size: 120%;
        text-decoration: none;
        font-weight: bold;
    }

    #cart_span {
        color: white;
        text-shadow: 1px 1px 2px black;
    }

    #output1 {
        color: gold;
        text-shadow: 1px 1px 2px black;
    }

    .icon_cart {
        min-height: 60px;
        min-width: 60px;
        background-image: url("/resources/img/cart.png");
    }

    /* меньше 800px */
    @media all and (max-width: 800px) {
        .navv { justify-content: space-around; }
        .navv a{ flex-grow:1; /* растягиваться на всю ширину */ }
    }

    /* меньше 500px */
    @media all and (max-width: 500px) {
        .navv { flex-direction: column; }
    }
</style>