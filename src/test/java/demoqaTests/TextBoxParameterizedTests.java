package demoqaTests;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import test_data.EmailType;
import test_data.TestBase;
import test_data.UserData;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxParameterizedTests extends TestBase {



    @ParameterizedTest(name = "Тест с пользователем: {0} {1}")
    @CsvSource({
            "Alex, alex@test.com, Moscow Street 1, Perm Street 1",
            "John, john@test.com, New York Street, Brooklyn Street",
            "Maria, maria@test.com, Madrid Street, Barcelona Street",
            "Елена, elena@test.ru, Улица Пушкина 1, Улица Лермонтова 1"
    })
    void fillFormWithCsvSourceTest(String name, String email, String currentAddress, String permanentAddress) {
        open("/text-box");

        $("#userName").setValue(name);
        $("#userEmail").setValue(email);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);
        $("#submit").click();

        $("#output #name").shouldHave(text(name));
        $("#output #email").shouldHave(text(email));
        $("#output #currentAddress").shouldHave(text(currentAddress));
        $("#output #permanentAddress").shouldHave(text(permanentAddress));
    }


    @ParameterizedTest(name = "Тест с именем: {0}")
    @ValueSource(strings = {"Alex", "John", "Maria", "Елена", "Michael", "Sarah"})
    void fillFormWithDifferentNamesTest(String name) {
        String email = "test@example.com";
        String currentAddress = "Current Street 123";
        String permanentAddress = "Permanent Street 456";

        open("/text-box");

        $("#userName").setValue(name);
        $("#userEmail").setValue(email);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);
        $("#submit").click();

        $("#output #name").shouldHave(text(name));
        $("#output #email").shouldHave(text(email));
        $("#output #currentAddress").shouldHave(text(currentAddress));
        $("#output #permanentAddress").shouldHave(text(permanentAddress));
    }


    @ParameterizedTest(name = "Тест: {0}")
    @MethodSource("userDataProvider")
    void fillFormWithMethodSourceTest(UserData user) {
        open("/text-box");

        $("#userName").setValue(user.name);
        $("#userEmail").setValue(user.email);
        $("#currentAddress").setValue(user.currentAddress);
        $("#permanentAddress").setValue(user.permanentAddress);
        $("#submit").click();

        $("#output #name").shouldHave(text(user.name));
        $("#output #email").shouldHave(text(user.email));
        $("#output #currentAddress").shouldHave(text(user.currentAddress));
        $("#output #permanentAddress").shouldHave(text(user.permanentAddress));
    }



    static Stream<UserData> userDataProvider() {
        return Stream.of(
                new UserData("Alice", "alice@wonderland.com", "Wonderland 1", "Wonderland 2"),
                new UserData("Bob", "bob@builder.com", "Construction St", "Tool St"),
                new UserData("Charlie", "charlie@brown.com", "Peanuts St", "Snoopy St")
        );
    }



    @ParameterizedTest(name = "CSV файл: {0}")
    @CsvFileSource(resources = "/users.csv", numLinesToSkip = 1)
    void fillFormWithCsvFileTest(String name, String email, String currentAddress, String permanentAddress) {
        open("/text-box");

        $("#userName").setValue(name);
        $("#userEmail").setValue(email);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);
        $("#submit").click();

        $("#output #name").shouldHave(text(name));
        $("#output #email").shouldHave(text(email));
        $("#output #currentAddress").shouldHave(text(currentAddress));
        $("#output #permanentAddress").shouldHave(text(permanentAddress));
    }

   
    @ParameterizedTest(name = "Тест с email типа: {0}")
    @EnumSource(EmailType.class)
    void fillFormWithDifferentEmailTypesTest(EmailType emailType) {
        String name = "Test User";
        String email = emailType.generate();
        String currentAddress = "Test Address";
        String permanentAddress = "Test Permanent Address";

        open("/text-box");

        $("#userName").setValue(name);
        $("#userEmail").setValue(email);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);
        $("#submit").click();

        $("#output #name").shouldHave(text(name));
        $("#output #email").shouldHave(text(email));
        $("#output #currentAddress").shouldHave(text(currentAddress));
        $("#output #permanentAddress").shouldHave(text(permanentAddress));
    }
}