<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Обработать параметр сортировки --%>
<c:if test="${param.sort!=null}">
    <c:set var="sort" scope="session" value="${param.sort}"/>
</c:if>
<%-- Обработать параметр направления сортировки --%>
<c:if test="${param.dir!=null}">
    <c:set var="dir" scope="session" value="${param.dir}"/>
</c:if>
<%-- Общая декоративная "шапка" для всех страниц --%>
<div style="background-color:#838804; padding: 10px; ">
    <img src="/resources/pict2.png" width="50" height="50" border="0" align="left" alt="pic">
    <div style="font-family: 'Times New Roman'; font-size: 30px; height: 53px; margin-left: 80px;">
        <b>Доска объявлений</b>
    </div>
</div>
<%-- Панель отображается если пользователь аутентифицирован --%>
<c:if test="${sessionScope.authUser!=null}">
    <div style="background-color: #ccc; padding: 5px">
        <div style="float: right; margin-right: 5px">
            [ <a href="<c:url value="/doLogout.jsp" />">Выйти</a> ]
        </div>
        Вы вошли как:
        <c:out value="${sessionScope.authUser.name}" />
        ( <c:out value="${sessionScope.authUser.login}" /> )
    </div>
</c:if>