package com.greenhouseci.test;

import android.test.ActivityInstrumentationTestCase2;

import com.greenhouseci.MainActivity;
import com.greenhouseci.R;
import com.robotium.solo.Solo;

import junit.framework.Assert;

/**
 * Created by priit on 28.11.14.
 */
public class RobotiumTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private Solo solo;

    public RobotiumTest() {
        super(MainActivity.class);
    }

    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    public void testSuccess() throws Exception {
        // check that we have the right activity
        solo.assertCurrentActivity("wrong activity", MainActivity.class);
        String message = solo.getString(R.string.message);
        Assert.assertTrue(solo.searchText(message));
    }

    public void testFail() throws Exception {
        // check that we have the right activity
        solo.assertCurrentActivity("wrong activity", MainActivity.class);
        Assert.assertTrue(false);
    }
}
