package com.demoqa;

import com.demoqa.model.MainPage;
import com.demoqa.model.PracticePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PracticeFormTest extends BaseTest {

    //Абсолютный путь к директории проекта
    private static String absolutePathToProject = System.getProperty("user.dir");

    //Параметризация через метод
    public static Stream<Arguments> isTestData() {

        return Stream.of(
                //позитивные тесты
                //имя фамилия - латиница/кириллица
                arguments(true, "Ivan", "Ivanov", "user1996@gmail.com", 1, "8001112233", 1996, "October", 13, "QA manual", false, true, false, "src/test/resources/JPG-test-image.jpg", "Boston", 1, 1),
                arguments(true, "Иванов", "Иван", "user1996@gmail.com", 1, "8001112233", 1996, "October", 13, "QA manual", false, true, false, "src/test/resources/JPG-test-image.jpg", "Boston", 1, 1),
               //пол ж/other
                arguments(true, "Ivanova", "Anna", "user1996@gmail.com", 2, "8001112233", 1996, "October", 13, "QA manual", false, true, false, "src/test/resources/JPG-test-image.jpg", "Boston", 1, 1),
                arguments(true, "Ivan", "Ivanov", "user1996@gmail.com", 3, "8001112233", 1996, "October", 13, "QA manual", false, true, false, "src/test/resources/JPG-test-image.jpg", "Boston", 1, 1),
                //дата рождения 1900г/2025г
                arguments(true, "Ivan", "Ivanov", "user1996@gmail.com", 1, "8001112233", 2025, "March", 30, "QA manual", false, true, false, "src/test/resources/JPG-test-image.jpg", "Boston", 1, 1),
                arguments(true, "Ivan", "Ivanov", "user1996@gmail.com", 1, "8001112233", 1900, "January", 1, "QA manual", false, true, false, "src/test/resources/JPG-test-image.jpg", "Boston", 1, 1),
                //хобби все возможные варианты
                arguments(true, "Ivan", "Ivanov", "user1996@gmail.com", 1, "8001112233", 1996, "October", 13, "QA manual", false, false, false, "src/test/resources/JPG-test-image.jpg", "Boston", 1, 1),
                arguments(true, "Ivan", "Ivanov", "user1996@gmail.com", 1, "8001112233", 1996, "October", 13, "QA manual", false, false, true, "src/test/resources/JPG-test-image.jpg", "Boston", 1, 1),
                arguments(true, "Ivan", "Ivanov", "user1996@gmail.com", 1, "8001112233", 1996, "October", 13, "QA manual", true, false, false, "src/test/resources/JPG-test-image.jpg", "Boston", 1, 1),
                arguments(true, "Ivan", "Ivanov", "user1996@gmail.com", 1, "8001112233", 1996, "October", 13, "QA manual", true, true, true, "src/test/resources/JPG-test-image.jpg", "Boston", 1, 1),
                arguments(true, "Ivan", "Ivanov", "user1996@gmail.com", 1, "8001112233", 1996, "October", 13, "QA manual", true, false, true, "src/test/resources/JPG-test-image.jpg", "Boston", 1, 1),
                arguments(true, "Ivan", "Ivanov", "user1996@gmail.com", 1, "8001112233", 1996, "October", 13, "QA manual", false, true, true, "src/test/resources/JPG-test-image.jpg", "Boston", 1, 1),
                arguments(true, "Ivan", "Ivanov", "user1996@gmail.com", 1, "8001112233", 1996, "October", 13, "QA manual", true, true, false, "src/test/resources/JPG-test-image.jpg", "Boston", 1, 1),
                //формат картинки png
                arguments(true, "Ivan", "Ivanov", "user1996@gmail.com", 1, "8001112233", 1996, "October", 13, "QA manual", false, true, false, "src/test/resources/PNG-test-image.png", "Boston", 1, 1),

                //негативные тесты
                //невалидный номер телефона
                arguments(false, "Ivan", "Ivanov", "user1996@gmail.com", 1, "800111223", 1996, "October", 13, "QA manual", false, true, false, "src/test/resources/JPG-test-image.jpg", "Boston", 1, 1),
                arguments(false, "Ivan", "Ivanov", "user1996@gmail.com", 1, "800111223o", 1996, "October", 13, "QA manual", false, true, false, "src/test/resources/JPG-test-image.jpg", "Boston", 1, 1)
        );
    }

    @ParameterizedTest
    @DisplayName("Заполнение формы Practice Form")
    @MethodSource("isTestData")
    public void checkClickOnButtonForms(boolean expectedResult, String firstName, String lastName, String email, int numberGender, String mobile,
                                        int numberYearOfBirth, String nameMonthOfBirth, int numberDayOfBirth, String subjects,
                                        boolean isHobbies1, boolean isHobbies2, boolean isHobbies3, String relativePathToImage,
                                        String currentAddress, int numberState, int numberCity) {
        //Arrange
        MainPage mainPage = new MainPage(driver);
        PracticePage practicePage = new PracticePage(driver);
        mainPage.clickOnButtonForms();
        practicePage.clickOnButtonPracticeForm();

        //Act
        practicePage.fillingFieldFirstName(firstName);
        practicePage.fillingFieldLastName(lastName);
        practicePage.fillingFieldEmail(email);
        practicePage.selectGender(numberGender);
        practicePage.fillingFieldMobile(mobile);
        practicePage.fillingFieldDateOfBirth(numberYearOfBirth, nameMonthOfBirth, numberDayOfBirth);
        practicePage.fillingFieldSubjects(subjects);
        practicePage.selectCheckBoxHobbies(isHobbies1, isHobbies2, isHobbies3);
        String absolutePathToImage = absolutePathToProject + "/" + relativePathToImage;
        practicePage.uploadImage(absolutePathToImage);
        practicePage.inputCurrentAddress(currentAddress);
        practicePage.selectState(numberState);
        practicePage.selectCity(numberCity);
        practicePage.pushOnButtonSubmit();

        //Assert
        Assertions.assertEquals(expectedResult, practicePage.formIsDone(),"ошибка при заполнении полей формы");
    }
}