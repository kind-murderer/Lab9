package tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

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
            //String delimSymbols = "[ ,.1234567890:;'!~`=%#@_\]";
            //ой что так плохо то а
            //без падежей, не все
            String[] neproizvodniePredlogi_mestoimeniya_souz = new String[]
                    {"Без", "в", "для", "за", "из", "к", "на", "над", "о", "об", "от", "по", "под", "пред", "при", "про", "с", "у", "через",
                            "я", "ты", "он", "она", "оно", "мы", "вы", "они","себя", "мой", "твой", "свой", "ваш", "наш", "его", "её", "их",
                            "кто", "что", "какой", "чей", "где", "который", "откуда", "сколько", "каковой", "каков", "зачем", "каков", "когда",
                            "тот", "этот", "столько", "такой", "таков", "сей", "всякий", "каждый", "сам", "самый", "весь",
                            "никто", "ничто", "никакой", "ничей", "некого", "нечего", "незачем",
                            "некто", "весь", "нечто", "некоторый", "несколько", "то",
                            "и", "а", "но", "да", "или", "либо", "однако", "ни", "либо", "как", "чтобы", "ежели", "будто", "ли"};

            String[] splitText = searchingText.split("[ ,.1234567890:;'!~`=%#@_]");
            StringBuilder builderToken = new StringBuilder(30);
            //подкидывает в builderToken, если не предлог/местоимение/союз
            boolean isHere = false;
            for(String token:splitText)
            {
                if(token.equals("")) {
                    continue;
                }

                isHere = false;
                for(String str: neproizvodniePredlogi_mestoimeniya_souz)
                {
                    if (token.equals(str)) {
                        isHere = true;
                        break;
                    }
                }
                if (!isHere)
                {
                    //убираю некоторые окончания существительных и прилагательных
                    int length = token.length();

                    if(length >= 4 && (token.endsWith("ого") || token.endsWith("его")  || token.endsWith("ому")  || token.endsWith("ему")
                            || token.endsWith("ими") || token.endsWith("ыми")  || token.endsWith("ами")  || token.endsWith("ями")))
                    {
                        builderToken.append(token, 0, length - 3).append(",");
                    }
                    else if(length >= 3 && (token.endsWith("ая") || token.endsWith("яя") || token.endsWith("ое") || token.endsWith("ее")
                            || token.endsWith("ой") || token.endsWith("ий")|| token.endsWith("ый")|| token.endsWith("ие") || token.endsWith("ые")
                            || token.endsWith("ей") || token.endsWith("их") || token.endsWith("ых") || token.endsWith("им")
                            || token.endsWith("ым") || token.endsWith("ую")|| token.endsWith("юю")|| token.endsWith("ом")|| token.endsWith("ем")
                            || token.endsWith("ам") || token.endsWith("ям")|| token.endsWith("ах")|| token.endsWith("ях") || token.endsWith("ов")))
                    {
                        builderToken.append(token, 0, length - 2).append(",");
                    }
                    else{
                        builderToken.append(token).append(",");
                    }
                }
            }
            searchingToken = builderToken.toString();
        }
        getJspContext().setAttribute("searchingToken", searchingToken);
        // Сохранить описание ошибки (текст или null) в сессии
        getJspContext().setAttribute("errorMessage", errorMessage, PageContext.SESSION_SCOPE);
    }
}