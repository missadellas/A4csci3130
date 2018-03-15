package com.acme.a3csci3130;

import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
/**
 * Created by sadel on 2018-03-13.
 */
public class CreateBusinessAcitivityTest {

    @Rule
    public ActivityTestRule<CreateBusinessAcitivity> mActivityRule =
            new ActivityTestRule<>(CreateBusinessAcitivity.class);

    public IntentsTestRule<CreateBusinessAcitivity> intentsTestRule =
            new IntentsTestRule<>(CreateBusinessAcitivity.class);

    @Test
    public void submitBusiness() {
        // Type text and then press the button.
        onView(withId(R.id.businessNumber))
                .perform(typeText("123456789"), closeSoftKeyboard());
        onView(withId(R.id.primaryBusiness)).perform(typeText("Fisher"), closeSoftKeyboard());
        onView(withId(R.id.name)).perform(typeText("Company1"), closeSoftKeyboard());
        onView(withId(R.id.address)).perform(typeText("Baroness ave"), closeSoftKeyboard());
        onView(withId(R.id.province)).perform(typeText("AB"), closeSoftKeyboard());
        onView(withId(R.id.submitButton)).perform(click());
       // intended(hasComponent(MainActivity.class.getName()));

    }


}