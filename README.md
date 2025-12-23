# Автоматизация тестирования Wikipedia (Web & Mobile)
Данный проект содержит автоматизированные UI-тесты для веб-версии сайта Wikipedia и мобильного приложения Wikipedia для Android.
* **Язык:** Java 21
* **Сборка:** Maven
* **Тестовый фреймворк:** TestNG
* **Веб-драйвер:** Selenium WebDriver (4.27.0)
* **Мобильный драйвер:** Appium (9.3.0) с использованием UIAutomator2
* **Логирование:** SLF4J + Logback
* **BaseWebTest**: Базовый класс для веб-тестов. Отвечает за инициализацию ChromeDriver и настройку браузера.
* **BaseMobileTest**: Базовый класс для мобильных тестов. Настраивает соединение с Appium Server и задает Capabilities для устройства Poco X7.
**Класс WikipediaHomePage (Методы):**
* `open()`: Загрузка главной страницы Википедии.
* `enterSearchText(String text)`: Ввод текста в поисковую строку с автоматическим нажатием клавиши Enter.
* `clickSearch()`: Клик по кнопке поиска.
* `isMainPageLinkDisplayed()`: Проверка видимости логотипа/ссылки на главную страницу.
**Класс WikipediaMobilePage (Методы):**
* `clickSearchContainer()`: Пропуск приветственных экранов и активация поля поиска.
* `enterSearchText(String text)`: Ввод текста запроса в приложении.
* `selectFirstSearchResult()`: Выбор первого элемента из списка результатов и автоматическое закрытие всплывающих уведомлений (например, анонсов игр).
* `getArticleTitle()`: Извлечение заголовка открытой статьи для проверки.
* `scrollToBottom()`: Выполнение прокрутки (Scroll) до конца страницы.
Для запуска требуется Google Chrome.
```bash
mvn clean test -Dtest=WikipediaWebTest
```
1. Убедитесь, что Android-устройство подключено по USB и включена отладка.
2. Запустите Appium сервер командой: `appium`
3. Выполните команду:
```bash
mvn clean test -Dtest=WikipediaMobileTest
```
Тестирование проводилось на реальном устройстве **Poco X7 (Android 15)** и браузере **Google Chrome (Linux)**.
**Результат прогона мобильных тестов:**
```text
[INFO] Running com.example.mobile.tests.WikipediaMobileTest
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

