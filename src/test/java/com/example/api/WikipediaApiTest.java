package com.example.api;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class WikipediaApiTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://ru.wikipedia.org/api/rest_v1";
    }

    @Test
    public void testGetArticleSummary() {
        given()
                .header("User-Agent", "MyTestAutomationProject/1.0 (contact@example.com)")
                .pathParam("title", "Java")
                .when()
                .get("/page/summary/{title}")
                .then()
                .statusCode(200)
                .body("title", equalTo("Java"))
                .body("lang", equalTo("ru"));
    }

    @Test
    public void testInvalidArticleReturns404() {
        given()
                .header("User-Agent", "MyTestAutomationProject/1.0 (contact@example.com)")
                .pathParam("title", "NonExistentPage123456789")
                .when()
                .get("/page/summary/{title}")
                .then()
                .statusCode(404);
    }
}