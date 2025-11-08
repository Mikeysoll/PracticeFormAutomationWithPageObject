package tests;

import data.TestData;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("faker")
public class PFFakerDataTests extends TestBase{

    @Test
    void fillFormTest() {

        formPage.openPage()
                        .setFirstName(testData.firstName)
                        .setLastName(testData.lastName)
                        .setEmail(testData.userEmail)
                        .setGender(testData.gender)
                        .setUserNumber(testData.userNumber)
                        .setDateOfBirth(testData.day, testData.month, testData.year)
                        .setSubjects(testData.subject)
                        .setHobbies(testData.hobby)
                        .setPicture("img/pic.jpg")
                        .setAddress(testData.currentAddress)
                        .setState(testData.state)
                        .setCity(testData.city)
                        .submitForm()
                        .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                        .checkResult("Student Email", testData.userEmail)
                        .checkResult("Gender", testData.gender)
                        .checkResult("Mobile", testData.userNumber)
                        .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                        .checkResult("Subjects", testData.subject)
                        .checkResult("Hobbies", testData.hobby)
                        .checkResult("Picture", "pic.jpg")
                        .checkResult("Address", testData.currentAddress)
                        .checkResult("State and City", testData.state + " " + testData.city);
    }

    @Test
    void fillWithMinimalDataTest(){

        formPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .submitForm()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year);

    }

    @Test
    void negativeTest(){
        formPage.openPage()
                .submitForm()
                .checkValidation();

    }
}
