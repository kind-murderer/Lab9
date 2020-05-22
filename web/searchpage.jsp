<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="ad" uri="http://tlds/ad" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:requestEncoding value="UTF-8" />

<html>
<head>
    <title>Поиск</title>
</head>
<body>
<%-- Подключить заголовок страницы --%>
<jsp:include page="/static/header.jsp"></jsp:include>

<h1>Страница поиска</h1>
<my:layout2Columns leftColumnWidth="68%" rightColumnWidth="28%">
    <jsp:attribute name="leftColumnBody">

         <c:if test="${param.searchingToken !=null}">
            <p>Ведутся работы по созданию функционала поиска.
                    ${param.searchingToken}</p>
        </c:if>
    </jsp:attribute>
    <jsp:attribute name="rightColumnBody">
        <%-- Вставить тег отображения сообщения об ошибке --%>
        <my:errorMessage />
        <%-- Вставить форму ввода текста --%>
        <my:searchForm>
            <jsp:attribute name="processor">
                  <%-- Адрес страницы-обработчика задаѐтся как атрибут processor--%>
                <c:url value="/doSearch.jsp" />
            </jsp:attribute>
        </my:searchForm>
    </jsp:attribute>
</my:layout2Columns>

<%-- Вставить нижний заголовок страницы --%>
<%@ include file="/static/footer.jsp" %>
</body>
</html>
