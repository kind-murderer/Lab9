package tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Search extends SimpleTagSupport
{
    //Поле для атрибута-искомого текста
    private String searchingText;

    //вызывается контейнером
    public void setSearchingText(String searchingText) {
        this.searchingText = searchingText;
    }

    public void doTag() throws JspException, IOException
    {
        // Изначально описание ошибки = null (т.е. ошибки нет)
        String errorMessage = null;
        String searchingToken = null;
        if (searchingText == null || searchingText.equals(""))
        {
            errorMessage = "Строчка пустая!";
        }
        else {
            //тут будет всякая магия со строкой? может быть
            searchingToken = "Мы хотим найти:" + searchingText;
        }
        getJspContext().setAttribute("searchingToken", searchingToken);
        // Сохранить описание ошибки (текст или null) в сессии
        getJspContext().setAttribute("errorMessage", errorMessage, PageContext.SESSION_SCOPE);
    }
}