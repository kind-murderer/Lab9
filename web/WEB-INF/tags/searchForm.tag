<%@ tag pageEncoding="UTF-8" %>

<%-- Входным атрибутом тега является processor - адрес страницы-обработчика запроса на аутентификацию --%>
<%@ attribute name="processor" required="true" rtexprvalue="true" %>

<form action="${processor}" method="post">
    <table border="0" cellspacing="0" cellpadding="5">
        <tr>
            <td>Ваш текст:</td>
            <td><input type="text" name="searchingText" value=""></td>
        </tr>
        <tr>
            <td>&nbsp</td>
            <td><input type="submit" value="Найти"></td>
        </tr>
    </table>
</form>