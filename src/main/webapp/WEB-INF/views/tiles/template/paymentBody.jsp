<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12.08.2018
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="payment_div">

    <sf:form method="post" modelAttribute="user" acceptCharset="UTF-8" >

        <table>
            <tr>
                <th><label for="first_name">Имя:</label></th>
                <td><sf:input  path="name" size="15" id="first_name" /></td>
            </tr>
            <tr>
                <th><label for="last_name">Фамилия:</label></th>
                <td><sf:input path="lastName" size="15" id="last_name"/></td>
            </tr>
            <tr>
                <th><label for="adres">Адрес:</label></th>
                <td><sf:input path="adres" size="15" id="adres"/></td>
            </tr>
            <tr>
                 <th><label for="phone_number">Телефон:</label></th>
                 <td><sf:input path="phoneNumber" size="15" id="phone_number"/></td>
            </tr>
            <tr>
                    <td><input name="commit" type="submit" value="ГОТОВО"></td>
            </tr>
        </table>
    </sf:form>

    <%--<a href="<c:url value="/pizza_home/finish"/>">ГОТОВО</a>--%>

</div>