package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.PracticeFormPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Tag("demoqa")
public class PFPageObjectTests  extends TestBase{

    @Test
    void fillFormTest() {

        formPage.openPage()
                        .setFirstName("Mikhail")
                        .setLastName("Solovyov")
                        .setEmail("contact@mikeysoll.ru")
                        .setGender("Male")
                        .setUserNumber("9853612907")
                        .setDateOfBirth("15", "October", "2002")
                        .setSubjects("Math")
                        .setSubjects("Computer Science")
                        .setHobbies("Reading")
                        .setHobbies("Music")
                        .setHobbies("Sports")
                        .setPicture("img/pic.jpg")
                        .setAddress("Moscow, Red Square")
                        .setState("Haryana")
                        .setCity("Karnal")
                        .submitForm()

                        .checkResult("Student Name", "Mikhail Solovyov")
                        .checkResult("Student Email", "contact@mikeysoll.ru")
                        .checkResult("Gender", "Male")
                        .checkResult("Mobile", "9853612907")
                        .checkResult("Date of Birth", "15 October,2002")
                        .checkResult("Subjects", "Maths, Computer Science")
                        .checkResult("Hobbies", "Reading, Music, Sports")
                        .checkResult("Picture", "pic.jpg")
                        .checkResult("Address", "Moscow, Red Square")
                        .checkResult("State and City", "Haryana Karnal");

    }

    @Test
    void fillWithMinimalDataTest(){

        formPage.openPage()
                .setFirstName("Mikhail")
                .setLastName("Solovyov")
                .setGender("Male")
                .setUserNumber("9853612907")
                .setDateOfBirth("15", "October", "2002")
                .submitForm()

                .checkResult("Student Name", "Mikhail Solovyov")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9853612907")
                .checkResult("Date of Birth", "15 October,2002");

    }

    @Test
    void negativeTest(){
        formPage.openPage()
                .submitForm()
                .checkValidation();

    }
}
