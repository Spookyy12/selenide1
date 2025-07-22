package autotest1;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Condition.*;

import org.junit.jupiter.api.Test;

public class CardTest {

    /**
     * 
     */
    @Test
    public void testCardFunctionality() {
        open("http://0.0.0.0:9999/");
        $("[data-test-id=name] input").setValue("игорь завр");
        $("[data-test-id=phone] input").setValue("+79161234567");
        $("[data-test-id=agreement]").click();
        $(byXpath("//*[@id='root']/div/form/div[4]/button")).click();
        $(".paragraph_theme_alfa-on-white").shouldHave(
                exactText("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

        
    }

    @Test
    public void testCardFunctionalityWithInvalidPhone() {
        open("http://0.0.0.0:9999/");
        $("[data-test-id=name] input").setValue("игорь завр");
        $("[data-test-id=phone] input").setValue("12345");
        $("[data-test-id=agreement]").click();
        $(byXpath("//*[@id='root']/div/form/div[4]/button")).click();
        $("[data-test-id=phone].input_invalid .input__sub")
                .shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }
}
