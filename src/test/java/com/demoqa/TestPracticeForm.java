package com.demoqa;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;


public class TestPracticeForm {
    @BeforeAll
    static void configure(){
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browser = "firefox";
        Configuration.browserSize = "1024x768";
    }
    @BeforeEach
    void beforeTest() {
        Selenide.clearBrowserCookies();
    }
        @Test
                void StudentRegistrationFormTest(){
        open("automation-practice-form");
        

        }




}
