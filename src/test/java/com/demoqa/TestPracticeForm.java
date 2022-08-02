package com.demoqa;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class TestPracticeForm {
    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    void beforeTest() {
        Selenide.clearBrowserCookies();
    }

    @Test
    void StudentRegistrationFormTest() {
        open("automation-practice-form");
        $("#firstName").setValue("Vadim");
        $("#lastName").setValue("Berezyak");
        $("#userEmail").setValue("berez@mail.ru");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("7999999999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1900");
        $(".react-datepicker__day--001").click();
        $("#submit").scrollTo();
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#subjectsInput").setValue("English").pressEnter();
        $("[for= 'hobbies-checkbox-1']").click();
        $("[for= 'hobbies-checkbox-2']").click();
        $("[for= 'hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/theCat.jpg"));
        $("#currentAddress").setValue("USSR, Red Square");
        $("#currentAddress").setValue("USSR, Red Square");
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();
        $(".table-responsive").shouldHave(
                text("Vadim Berezyak"),
                text("berez@mail.ru"),
                text("Male"),
                text("Male"),
                text("01 January,1900"),
                text("Maths, English"),
                text("Sports, Reading, Music"),
                text("theCat.jpg"),
                text("USSR, Red Square"),
                text("Haryana Karnal"),
                text("7999999999"));
    }
}
