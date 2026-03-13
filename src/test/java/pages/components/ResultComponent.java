package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultComponent {
    private static SelenideElement resultWindow = $(".modal-open");
    private static SelenideElement tableOutput = $(".table-responsive");
    private static SelenideElement closeButton = $("closeLargeModal");


    public static void checkResultWindow() {
        resultWindow.should(appear);

    }
    public static void  checkResult(String key, String value) {
        tableOutput.$(byText(key)).parent().shouldHave(text(value));


    }
    public static void  closeWindow() {
        closeButton.click();


    }
}
