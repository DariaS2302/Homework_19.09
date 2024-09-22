package tests;

import org.junit.jupiter.api.Test;
import pages.DemoqaFormPage;


public class DemoqaFormTest extends TestBase {

    private final DemoqaFormPage demoqaFormPage = new DemoqaFormPage();

    String firstName = "Daria",
            lastName = "Sarycheva",
            userEmail = "daria@test.com",
            gender = "Female",
            userNumber = "8900900999",
            negativeUserNumber = "8900900AAA",
            dayOfBirth = "23",
            monthOfBirth = "February",
            yearOfBirth = "1990",
            subjects = "Art",
            hobbies = "Sports",
            pictureName = "tst.jpg",
            address = "World",
            state = "NCR",
            city = "Del";

    @Test
    void fullFormTest() {
        demoqaFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthDay(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subjects)
                .setHobby(hobbies)
                .uploadPicture(pictureName)
                .setCurrentAddress(address)
                .setUserState(state)
                .setUserCity(city)
                .clickSubmit();


        demoqaFormPage.checkSuccessResult("Student Name", firstName + " " + lastName)
                .checkSuccessResult ("Student Email", userEmail)
                .checkSuccessResult ("Gender", gender)
                .checkSuccessResult ("Mobile", userNumber)
                .checkSuccessResult ("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkSuccessResult ("Subjects", subjects)
                .checkSuccessResult ("Hobbies", hobbies)
                .checkSuccessResult ("Picture", pictureName)
                .checkSuccessResult ("Address", address)
                .checkSuccessResult ("State and City", state + " " + city);
    }

    @Test
    void minFormTest() {
        demoqaFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .clickSubmit();

        demoqaFormPage.checkSuccessResult("Student Name", firstName + " " + lastName)
                .checkSuccessResult("Student Email", userEmail)
                .checkSuccessResult("Gender", gender)
                .checkSuccessResult("Mobile", userNumber);
    }

    @Test
    void NegativeFormTest() {
        demoqaFormPage.openPage()
                .setUserNumber(negativeUserNumber)
                .clickSubmit();

        demoqaFormPage.checkNegativeResult();
    }
}
