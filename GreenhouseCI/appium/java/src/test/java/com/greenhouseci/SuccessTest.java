package com.greenhouseci;

import com.greenhouseci.util.AppiumTest;
import static com.greenhouseci.util.Helpers.*;
import org.openqa.selenium.WebElement;
import org.junit.Test;

public class SuccessTest extends AppiumTest {

    @Test
    public void hasText2() throws Exception {
        text("GreenhouseCI");
    }
}
