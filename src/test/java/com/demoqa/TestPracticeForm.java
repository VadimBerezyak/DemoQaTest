package com.demoqa;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


public class TestPracticeForm {
    @BeforeAll
    static void configure(){
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browser = "firefox";
        Configuration.browserSize = "1024x768";
    }
    @BeforeEach
    static  void beforeTest(){

    }


}
