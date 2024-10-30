package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.ResultsTable;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbyRadioBtn = $("#hobbiesWrapper"),
            uploadImageInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateTabs = $("#state"),
            stateInput = $("#stateCity-wrapper"),
            cityTabs = $("#city"),
            cityInput = $("#stateCity-wrapper"),
            submitBtn = $("#submit"),
            userForm = $("form#userForm");

    CalendarComponent calendarComponent = new CalendarComponent();

    @Step("Открыть страницу регистрации")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    @Step("Ввести имя")
    public RegistrationPage setFirstName (String value) {
        firstNameInput.setValue(value);
        return this;
    }
    @Step("Ввести фамилию")
    public RegistrationPage setLastName (String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Ввести email")
    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }
    @Step("Выбрать пол")
    public RegistrationPage setGender (String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }
    @Step("Ввести номер телефона")
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    @Step("Выбрать дату рождения")
    public RegistrationPage setDateOfBirth (String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    @Step("Проверка отображения результатов")
    public RegistrationPage checkResult(String key, String value) {
        new ResultsTable().checkResult(key, value);
        return this;
    }

    @Step("Выбрать предмет")
    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Выбрать хобби")
    public RegistrationPage setHobby(String hobby) {
        hobbyRadioBtn.$(byText(hobby)).click();
        return this;
    }

    @Step("Загрузить изображение")
    public RegistrationPage uploadImage(String value) {
        uploadImageInput.uploadFromClasspath("images/" + value);
        return this;
    }

    @Step("Выбрать адрес")
    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    @Step("Выбрать штат")
    public RegistrationPage setState (String value) {
        stateTabs.scrollTo();
        stateTabs.click();
        stateInput.$(byText(value)).click();
        return this;
    }

    @Step("Выбрать город")
    public RegistrationPage setCity (String value) {
        cityTabs.scrollTo();
        cityTabs.click();
        cityInput.$(byText(value)).click();
        return this;
    }

    @Step("Нажать submit")
    public RegistrationPage submit() {
        submitBtn.click();
        return this;
    }

    @Step("Проверка на неуспешнный ввод данных")
    public RegistrationPage checkUnsuccessfulValidation() {
        userForm.shouldHave(attribute("class", "was-validated"));
        return this;
    }

}