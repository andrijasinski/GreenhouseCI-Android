package com.greenhouseci.test;

import android.test.ActivityInstrumentationTestCase2;

import com.greenhouseci.MainActivity;
import com.greenhouseci.R;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;

public class EspressoTest extends ActivityInstrumentationTestCase2<MainActivity> {

    @SuppressWarnings("deprecation")
    public EspressoTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        // Espresso will not launch our activity for us, we must launch it via getActivity().
        getActivity();
    }

    public void testCheckTextSuccess() {
        onView(withId(R.id.text_thanks))
                .check(matches(withText("Thank you for building with GreenhouseCI!")));
    }

    public void testCheckTextFailure() {
        onView(withId(R.id.text_thanks))
                .check(matches(withText("Hello Espresso!")));
    }
}