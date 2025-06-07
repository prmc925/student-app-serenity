package com.studentapp.studentinfo;

import com.studentapp.testbase.TestBase;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jay
 */
@UseTestDataFrom("src/test/resources/testdata/studentinfo.csv")
@RunWith(SerenityParameterizedRunner.class)
public class CreateStudentDataDrivenTest extends TestBase {

    private String firstName;
    private String lastName;
    private String email;
    private String programme;
    private String course1;
    private String course2;

    @Steps
    StudentSteps steps;

    @Title("Data driven test for adding multiple students to the application")
    @Test
    public void createMultipleStudent(){
        List<String> courseList = new ArrayList<>();
        courseList.add(course1);
        courseList.add(course2);
        steps.createStudent(firstName, lastName, email, programme, courseList).statusCode(201);
    }
}