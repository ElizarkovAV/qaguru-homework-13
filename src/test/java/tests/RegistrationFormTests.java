package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomDataUtil;

@Tag("registration")
public class RegistrationFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RandomDataUtil random = new RandomDataUtil();

    String name = random.getRandomFirstName(),
            lastName = random.getRandomLastName(),
            email = random.getRandomEmail(),
            mobile = random.getRandomMobile(),
            subject = random.getRandomSubject(),
            address = random.getRandomAddress(),
            state = random.getRandomState(),
            city = random.getRandomCity(state),
            gender = random.getRandomGender(),
            hobby = random.getRandomHobby(),
            day = random.getRandomDay(),
            month = random.getRandomMonth(),
            year = random.getRandomYear(),
            picture = random.getRandomPicture();

    @Test
    @DisplayName("Успешная регистрация пользователя")
    void fillRegistrationFormTest() {

        //act
        registrationPage.openPage()
                .setFirstName(name)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(mobile)
                .setDateOfBirth(day, month, year)
                .setSubject(subject)
                .setHobby(hobby)
                .uploadImage(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submit();

        //asserts
        registrationPage
                .checkResult("Student Name", name + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", mobile)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", picture)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    @DisplayName("Успешная регистрация при минимальном количестве данных")
    public void minimalNumbersOfValuesTest() {
        //act
        registrationPage.openPage()
                .setFirstName(name)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(mobile)
                .submit();
        //assert
        registrationPage
                .checkResult("Student Name", name + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", mobile);
    }

    @Test
    @DisplayName("Попытка регистрации без заполнения фамилии")
    public void registrationWithoutLastname() {
        //act
        registrationPage.openPage()
                .setFirstName(name)
                .setGender(gender)
                .setUserNumber(mobile)
                .submit();

        //assert
        registrationPage.checkUnsuccessfulValidation();
    }

}