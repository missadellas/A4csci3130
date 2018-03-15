package com.acme.a3csci3130;

import android.content.Intent;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.anything;
import static org.junit.Assert.*;

/**
 * Created by sadel on 2018-03-14.
 */
public class DetailViewActivityTest {

    @Rule
    public ActivityTestRule<DetailViewActivity> ActivityRule =
            new ActivityTestRule<>(DetailViewActivity.class);

    public IntentsTestRule<DetailViewActivity> intentsTestRule =
            new IntentsTestRule<>(DetailViewActivity.class);
    public ActivityTestRule<MainActivity> mActivityTestRule=
            new ActivityTestRule<>(MainActivity.class,false,false);
    
    @Test
    public void updateBusiness() throws Exception {

        onView(withId(R.id.name)).perform(typeText("Business1"), closeSoftKeyboard());
        onView(withId(R.id.updateButton)).perform(click());
    }

    @Test
    public void eraseBusiness() throws Exception {
        mActivityTestRule.launchActivity(new Intent());
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
    }

}