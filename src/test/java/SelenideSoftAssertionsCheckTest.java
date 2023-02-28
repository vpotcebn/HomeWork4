import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideSoftAssertionsCheckTest {

    String s = "@ExtendWith({SoftAssertsExtension.class})\n" +
            "class Tests {\n" +
            "  @Test\n" +
            "  void test() {\n" +
            "    Configuration.assertionMode = SOFT;\n" +
            "    open(\"page.html\");\n" +
            "\n" +
            "    $(\"#first\").should(visible).click();\n" +
            "    $(\"#second\").should(visible).click();\n" +
            "  }\n" +
            "}";
    @Test
    void checkAssertionsAndJUnitTest(){
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("[placeholder='Find a page…']").setValue("SoftAssertions");
        $(".Layout-sidebar").shouldHave(text("SoftAssertions"));
        $(byText("SoftAssertions")).click();
        $("#user-content-3-using-junit5-extend-test-class").parent().sibling(0).shouldHave(text(s));
        sleep(4000);



    }


}
