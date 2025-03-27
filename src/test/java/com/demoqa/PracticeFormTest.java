package com.demoqa;

import com.demoqa.model.MainPage;
import com.demoqa.model.PracticePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PracticeFormTest extends BaseTest {

    //параметризация через метод
    public static Stream<Arguments> isTestData() {
        return Stream.of(
                arguments("Alexander", "Pushkin"),
                arguments("Александр", "Пушкин")
        );
    }

    @ParameterizedTest
    @DisplayName("Заполнение формы Practice Form")
    @MethodSource("isTestData")
    public void checkClickOnButtonForms(String firstName, String lastName) {
        //Arrange
        MainPage mainPage = new MainPage(driver);
        PracticePage practicePage = new PracticePage(driver);
        mainPage.clickOnButtonForms();
        practicePage.clickOnButtonPracticeForm();

        //Act
        practicePage.fillingFieldFirstName(firstName);
        practicePage.fillingFieldLastName(lastName);
    }
}