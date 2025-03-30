package com.demoqa.model;

import io.qameta.allure.Step;
import org.openqa.selenium.*;

public class PracticePage {

    private WebDriver driver;

    public PracticePage(WebDriver driver) {
        this.driver = driver;
    }

    //кнопка выбора Practice Form
    private By buttonPracticeForm = By.xpath(".//span[text()='Practice Form']");
    //поле First Name
    private By fieldFirstName = By.cssSelector("#firstName");
    //поле Last Name
    private By fieldLastName = By.cssSelector("#lastName");
    //поле E-mail
    private By fieldEmail = By.xpath(".//input[@id='userEmail']");
    //поле Mobile
    private By fieldMobile = By.xpath(".//input[@id='userNumber']");
    //поле Date of Birth
    private By fieldDateOfBirth = By.xpath(".//input[@id='dateOfBirthInput']");
    //поле Subjects
    private By fieldSubjects = By.xpath(".//input[@id='subjectsInput']");
    //чекбокс Hobbies 1
    private By checkboxHobbies1 = By.xpath(".//input[@id='hobbies-checkbox-1']/parent::div");
    //чекбокс Hobbies 2
    private By checkboxHobbies2 = By.xpath(".//input[@id='hobbies-checkbox-2']/parent::div");
    //чекбокс Hobbies 3
    private By checkboxHobbies3 = By.xpath(".//input[@id='hobbies-checkbox-3']/parent::div");
    //кнопка Загрузить файл
    private By buttonUploadFile = By.xpath(".//input[@id='uploadPicture']");
    //поле ввода текущего адреса
    private By fieldCurrentAddress = By.xpath(".//textarea[@id='currentAddress']");
    //поле выбора State
    private By fieldSelectState = By.cssSelector("#state");
    //поле выбора City
    private By fieldSelectCity = By.cssSelector("#city");
    //кнопка Submit
    private By buttonSubmit = By.xpath(".//button[@id='submit']");
    //Заголовок формы Thanks for submitting the form
    private By titleFormIsDone = By.xpath(".//div[@id='example-modal-sizes-title-lg']");

    @Step("выбор раздела Practice Form")
    public void clickOnButtonPracticeForm() {
        driver.findElement(buttonPracticeForm).click();
    }

    @Step("заполнение поля First Name")
    public void fillingFieldFirstName(String firstName) {
        driver.findElement(fieldFirstName).sendKeys(firstName);
    }

    @Step("заполнение поля Last Name")
    public void fillingFieldLastName(String lastName) {
        driver.findElement(fieldLastName).sendKeys(lastName);
    }

    @Step("заполнение поля Email")
    public void fillingFieldEmail(String email) {
        driver.findElement(fieldEmail).sendKeys(email);
    }

    @Step("выбор радиокнопки Gender")
    public void selectGender(int numberGender) {
        driver.findElement(By.xpath(".//input[@id='gender-radio-" + numberGender + "']/parent::div")).click();
    }

    @Step("заполнение поля Mobile")
    public void fillingFieldMobile(String mobile) {
        driver.findElement(fieldMobile).sendKeys(mobile);
    }

    @Step("заполнение поля Date of Birth")
    public void fillingFieldDateOfBirth(int yearOfBirth, String monthOfBirth, int dayNumberOfBirth) {
        WebElement elementFieldDateOfBirth = driver.findElement(fieldDateOfBirth);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", elementFieldDateOfBirth);
        elementFieldDateOfBirth.click();
        //выбор года рождения
        driver.findElement(By.xpath(".//select[@class='react-datepicker__year-select']/option[text()='" + yearOfBirth + "']")).click();
        //выбор месяца рождения
        driver.findElement(By.xpath(".//select[@class='react-datepicker__month-select']/option[text()='" + monthOfBirth + "']")).click();
        //выбор числа рождения
        driver.findElement(By.xpath(".//div[text()='" + dayNumberOfBirth + "']")).click();
    }

    @Step("заполнение поля Subjects")
    public void fillingFieldSubjects(String subjects) {
        driver.findElement(fieldSubjects).sendKeys(subjects);
    }

    @Step("выбор чекбокса Hobbies")
    public void selectCheckBoxHobbies(boolean isHobbies1, boolean isHobbies2, boolean isHobbies3) {
        if (isHobbies1 == true) {
            driver.findElement(checkboxHobbies1).click();
        }
        if (isHobbies2 == true) {
            driver.findElement(checkboxHobbies2).click();
        }
        if (isHobbies3 == true) {
            driver.findElement(checkboxHobbies3).click();
        }
    }

    @Step("загрузка изображения")
    public void uploadImage(String absolutePathToProject) {
        driver.findElement(buttonUploadFile).sendKeys(absolutePathToProject);
    }

    @Step("ввод текущего адреса")
    public void inputCurrentAddress(String currentAddress) {
        driver.findElement(fieldCurrentAddress).sendKeys(currentAddress);
    }

    @Step("выбор State")
    public void selectState(int numberState) {
        driver.findElement(fieldSelectState).click();
        driver.findElement(By.xpath(".//div[@id='react-select-3-option-"+numberState+"']")).click();
    }

    @Step("выбор City")
    public void selectCity(int numberCity) {
        driver.findElement(fieldSelectCity).click();
        driver.findElement(By.xpath(".//div[@id='react-select-4-option-"+numberCity+"']"));
    }

    @Step("нажать кнопку Submit")
    public void pushOnButtonSubmit() {
        driver.findElement(buttonSubmit).click();
    }

    @Step("форма успешно заполнена")
    public boolean formIsDone() {
        try {
            driver.findElement(titleFormIsDone);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}