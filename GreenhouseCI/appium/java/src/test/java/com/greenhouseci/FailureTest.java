package com.greenhouseci;

import com.greenhouseci.util.AppiumTest;
import static com.greenhouseci.util.Helpers.*;
import org.openqa.selenium.WebElement;
import org.junit.Test;

public class FailureTest extends AppiumTest {

    @Test
    public void doesNotHaveText() throws Exception {
        text("no such text");
    }
}
