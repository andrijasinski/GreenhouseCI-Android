package com.greenhouseci.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;
import com.greenhouseci.MainActivity;
import com.greenhouseci.R;

public class RealTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity activity;
    private TextView tv;

    public RealTest() {
        super(MainActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
        tv = (TextView) activity.findViewById(R.id.text_thanks);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testTextView() throws Exception {
        assertNotNull(tv.getText());
        assertEquals(tv.getText().toString(), activity.getResources().getString(R.string.message));
    }
}
