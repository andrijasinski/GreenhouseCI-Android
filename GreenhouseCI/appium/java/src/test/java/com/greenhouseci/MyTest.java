package com.greenhouseci;

import com.greenhouseci.util.AppiumTest;
import static com.greenhouseci.util.Helpers.*;
import org.openqa.selenium.WebElement;

public class MyTest extends AppiumTest {

    @org.junit.Test
    public void hasText() throws Exception {
        text("Thank you");
    }
}
