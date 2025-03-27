package com.demoqa;

import com.demoqa.model.MainPage;
import com.demoqa.model.PracticePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PracticeFormTest extends BaseTest {

    //параметризация через метод
    public static Stream<Arguments> isTestData() {
        return Stream.of(
//                arguments("Ivan", "Ivanov", "ivan1996@gmail.com", 1, "9202223344"),
//                arguments("Иванова", "Анна", "ivanova2005@yandex.ru", 2, "9009998877"),
                arguments("Unknown", "None", "xxx@gmail.com", 3, "8001112233")
        );
    }

    @ParameterizedTest
    @DisplayName("Заполнение формы Practice Form")
    @MethodSource("isTestData")
    public void checkClickOnButtonForms(String firstName, String lastName, String email, int numberGender, String mobile) {
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
        practicePage.clickOnFieldDateOfBirth();//исправить на заполнение поля
    }
}