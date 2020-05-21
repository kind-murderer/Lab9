<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page language="java" pageEncoding="UTF-8" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="ad" uri="http://tlds/ad" %>
<%-- Указать, что мы ожидаем данные в кодировке UTF-8 --%>
<fmt:requestEncoding value="UTF-8" />

<ad:search searchingText="${param.searchingText}" />
<c:redirect url="/searchpage.jsp">
    <c:param name="searchingToken" value="${searchingToken}"/>
</c:redirect>