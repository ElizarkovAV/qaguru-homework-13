package pages.components;
import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setDate (String day, String month, String year) {
        $(".react-datepicker__month-select").click(); //выбор месяца
         $(byText(month)).click();
        $(".react-datepicker__year-select").click(); //выбор года
         $(byText(year)).click();
        $(".react-datepicker__day--0" + day)
                .shouldNotHave(cssClass("react-datepicker__day--outside-month")).click(); //выбор дня
        }
    }