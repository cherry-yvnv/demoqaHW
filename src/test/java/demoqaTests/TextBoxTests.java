package demoqaTests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;


public class TextBoxTests  {

    @Test
    void successfulTextBoxTest() {
        open("https://demoqa.com/text-box");

        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);
        $("#userName").setValue("Lady Gaga");
        $("#userEmail").setValue("lady@gaga.com");
        $("#currentAddress").setValue("New York");
        $("#permanentAddress").setValue("Las Vegas");
        $("#submit").click();

        $("#output").should(appear);
        $("#output #name").shouldHave(text("Lady Gaga"));
        $("#output #currentAddress").shouldHave(text("New York"));
        $("#output #email").shouldHave(text("lady@gaga.com"));
        $("#output #permanentAddress").shouldHave(text("Las Vegas"));

    }
    @Test
    void    invalidEmailTestBoxTest() {
        open("https://demoqa.com/text-box");

        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);
        $("#userEmail").setValue("lady");
        $("#submit").click();
        $("#output").shouldNot(appear);
    }








}