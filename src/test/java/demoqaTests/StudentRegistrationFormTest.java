package demoqaTests;


import org.junit.jupiter.api.Test;
import test_data.TestBase;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class StudentRegistrationFormTest extends TestBase {

    @Test
    void successfulRegistrationFormTest() {
        open("/automation-practice-form");
        executeJavaScript("""
        document.getElementById('fixedban')?.remove();
        document.querySelector('footer')?.remove();
        """);
        $("#firstName").setValue("Britney");
        $("#lastName").setValue("Spears");
        $("#userEmail").setValue("britney@spears.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("8987654321");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("March")).click();
        $(".react-datepicker__year-select").$(byText("1994")).click();
        $(".react-datepicker__day.react-datepicker__day--004").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbies-checkbox-3").click();
        $("#uploadPicture").uploadFromClasspath("img.png");
        $("#currentAddress").setValue("San-Andreas");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Gurgaon")).click();
        $("#submit").click();

        $(".modal-open").should(appear);
        $(".table-responsive") .shouldHave(text("Britney"));
        $(".table-responsive") .shouldHave(text("Spears"));
        $(".table-responsive").shouldHave(text("britney@spears.com"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("8987654321"));
        $(".table-responsive").shouldHave(text("04 March,1994"));
        $(".table-responsive").shouldHave(text("Maths"));
        $(".table-responsive").shouldHave(text("Music"));
        $(".table-responsive").shouldHave(text("San-Andreas"));
        $(".table-responsive").shouldHave(text("img.png"));
        $(".table-responsive").shouldHave(text("NCR Gurgaon"));
        $("#closeLargeModal").click();

    }
}
