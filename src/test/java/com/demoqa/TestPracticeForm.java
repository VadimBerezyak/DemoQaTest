package com.demoqa;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class TestPracticeForm {
    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browser = "firefox";
        Configuration.browserSize = "1024x768";
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
        $("#userNumber").setValue("79999999999");

        $("#dateOfBirthInput").click();
        $x("//option[@value = '0']").click();
        $x("//option[@value = '1900']").click();
        $x("//div[@aria-label = 'Choose Monday, January 1st, 1900']").click();

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

    }


}
