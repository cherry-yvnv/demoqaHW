package demoqaTests;

import test_data.TestBase;
import org.junit.jupiter.api.Test;

import static test_data.TestData.*;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationFormWithDataTest extends TestBase {

    @Test
    void successfulRegistrationFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(sex)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText(month)).click();
        $(".react-datepicker__year-select").$(byText(year)).click();
        $(".react-datepicker__day.react-datepicker__day--0" + day).click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbies-checkbox-3").click();
        $("#uploadPicture").uploadFromClasspath(picture);
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();

        $(".modal-open").should(appear);
        $(".table-responsive") .shouldHave(text(firstName));
        $(".table-responsive") .shouldHave(text(lastName));
        $(".table-responsive").shouldHave(text(userEmail));
        $(".table-responsive").shouldHave(text(sex));
        $(".table-responsive").shouldHave(text(userNumber));
        $(".table-responsive").shouldHave(text(day + " " + month + "," + year));
        $(".table-responsive").shouldHave(text(subject));
        $(".table-responsive").shouldHave(text(hobby));
        $(".table-responsive").shouldHave(text(currentAddress));
        $(".table-responsive").shouldHave(text(picture));
        $(".table-responsive").shouldHave(text(state + " " + city));
        $("#closeLargeModal").click();

    }
}
