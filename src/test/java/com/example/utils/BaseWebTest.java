package com.example.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseWebTest {
    protected WebDriver driver;
    protected static final Logger logger = LoggerFactory.getLogger(BaseWebTest.class);

    @BeforeMethod
    public void setUp() {
        System.out.println("--- НАЧАЛО SETUP ---");
        try {
            logger.info("Инициализация ChromeDriver");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            System.out.println("--- SETUP УСПЕШНО ЗАВЕРШЕН ---");
        } catch (Exception e) {
            System.out.println("--- ОШИБКА В SETUP ---");
            e.printStackTrace();
            throw e;
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            System.out.println("--- ЗАКРЫТИЕ БРАУЗЕРА ---");
            logger.info("Закрытие браузера");
            driver.quit();
        }
    }
}