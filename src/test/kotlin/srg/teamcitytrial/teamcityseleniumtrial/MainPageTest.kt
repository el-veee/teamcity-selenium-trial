package srg.teamcitytrial.teamcityseleniumtrial

import com.codeborne.selenide.Condition.attribute
import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selectors.*
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.open
import org.testng.annotations.*
import org.testng.Assert.*

class MainPageTest {
    private val mainPage = MainPage()

    @BeforeMethod
    fun setUpAll() {
        Configuration.browserSize = "1280x800"
    }

    @BeforeMethod
    fun setUp() {
        open("https://www.jetbrains.com/")
    }

    @Test
    fun search() {
        mainPage.searchButton.click()

        element("[data-test='search-input']").sendKeys("Selenium")
        element("button[data-test='full-search-button']").click()

        element("input[data-test='search-input']").shouldHave(attribute("value", "Selenium"))
    }

    @Test
    fun toolsMenu() {
        mainPage.toolsMenu.click()

        element("div[data-test='main-submenu']").shouldBe(visible)
    }

    @Test
    fun navigationToAllTools() {
        mainPage.seeAllToolsButton.click()

        element("#products-page").shouldBe(visible)

        assertEquals(Selenide.title(), "All Developer Tools and Products by JetBrains")
    }
}
