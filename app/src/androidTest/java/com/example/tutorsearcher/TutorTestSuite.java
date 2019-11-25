package com.example.tutorsearcher;

// Tutor Suite for testing the available hours, profile, and requests

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import androidx.annotation.NonNull;
import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import com.example.tutorsearcher.activity.MainActivity;
import com.example.tutorsearcher.ui.login.LoginActivity;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.longClick;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static com.example.tutorsearcher.SearchTestSuite.hasChildren;
import static org.hamcrest.core.AllOf.allOf;
import java.util.ArrayList;

@RunWith(AndroidJUnit4.class)
public class TutorTestSuite {
    private String stringToBetyped;
    private Availability a;

    // Need this to define the activity we're going to pull elements from
    @Rule
    public ActivityTestRule<MainActivity> activityRule
            = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void initValidString() {
        // Specify a valid string.
        stringToBetyped = "Espresso";
    }

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void addCourseTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatEditText2 = onView(
                Matchers.allOf(withId(R.id.password),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("password"), closeSoftKeyboard());

        ViewInteraction appCompatEditText5 = onView(
                Matchers.allOf(withId(R.id.username), withText("test@usc.edu"),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText5.perform(closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                Matchers.allOf(withId(R.id.login), withText("Log In"),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatButton.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction bottomNavigationItemView = onView(
                Matchers.allOf(withId(R.id.navigation_dashboard), withContentDescription("Profile"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0),
                                1),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());

        ViewInteraction appCompatButton2 = onView(
                Matchers.allOf(withId(R.id.edit_profile_button), withText("Edit Profile"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                0)));
        appCompatButton2.perform(scrollTo(), click());

        ViewInteraction appCompatEditText6 = onView(
                Matchers.allOf(withId(R.id.courses_text), withText("Add class names delimited by newlines\nex. AMST100\n"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                12)));
        appCompatEditText6.perform(scrollTo(), replaceText("Add class names delimited by newlines\nex. AM4ST100\n"));

        ViewInteraction appCompatEditText7 = onView(
                Matchers.allOf(withId(R.id.courses_text), withText("Add class names delimited by newlines\nex. AM4ST100\n"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                12),
                        isDisplayed()));
        appCompatEditText7.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText8 = onView(
                Matchers.allOf(withId(R.id.courses_text), withText("Add class names delimited by newlines\nex. AM4ST100\n"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                12)));
        appCompatEditText8.perform(scrollTo(), click());

        ViewInteraction appCompatEditText9 = onView(
                Matchers.allOf(withId(R.id.courses_text), withText("Add class names delimited by newlines\nex. AM4ST100\n"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                12)));
        appCompatEditText9.perform(scrollTo(), replaceText("CSCI310\nCSCI360\n"));

        ViewInteraction appCompatEditText10 = onView(
                Matchers.allOf(withId(R.id.courses_text), withText("CSCI310\nCSCI360\n"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                12),
                        isDisplayed()));
        appCompatEditText10.perform(closeSoftKeyboard());

        ViewInteraction appCompatButton3 = onView(
                Matchers.allOf(withId(R.id.edit_profile_button), withText("Submit"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                0)));
        appCompatButton3.perform(scrollTo(), click());
    }


    @Test
    public void acceptRequestTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatEditText = onView(
                Matchers.allOf(withId(R.id.username),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("tutor1@usc.edu"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                Matchers.allOf(withId(R.id.password),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("123456"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                Matchers.allOf(withId(R.id.login), withText("Log In"),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatButton.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction bottomNavigationItemView = onView(
                Matchers.allOf(withId(R.id.navigation_notifications), withContentDescription("Requests"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0),
                                2),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());

        ViewInteraction button = onView(
                Matchers.allOf(withText("Accept"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.requestsContainer),
                                        0),
                                1),
                        isDisplayed()));
        button.perform(click());
    }



    @Test
    public void addAvailabilityTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatEditText = onView(
                Matchers.allOf(withId(R.id.username),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("test@usc"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                Matchers.allOf(withId(R.id.password),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("password"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                Matchers.allOf(withId(R.id.username), withText("test@usc"),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText3.perform(click());

        ViewInteraction appCompatEditText4 = onView(
                Matchers.allOf(withId(R.id.username), withText("test@usc"),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText4.perform(click());

        ViewInteraction appCompatEditText5 = onView(
                Matchers.allOf(withId(R.id.username), withText("test@usc"),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText5.perform(replaceText("test@usc.edu"));

        ViewInteraction appCompatEditText6 = onView(
                Matchers.allOf(withId(R.id.username), withText("test@usc.edu"),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText6.perform(closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                Matchers.allOf(withId(R.id.login), withText("Log In"),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatButton.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction bottomNavigationItemView = onView(
                Matchers.allOf(withId(R.id.navigation_notifications), withContentDescription("Requests"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0),
                                2),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());

        ViewInteraction bottomNavigationItemView2 = onView(
                Matchers.allOf(withId(R.id.navigation_dashboard), withContentDescription("Profile"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0),
                                1),
                        isDisplayed()));
        bottomNavigationItemView2.perform(click());

        ViewInteraction appCompatButton2 = onView(
                Matchers.allOf(withId(R.id.edit_profile_button), withText("Edit Profile"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                0)));
        appCompatButton2.perform(scrollTo(), click());

        ViewInteraction appCompatEditText7 = onView(
                Matchers.allOf(withId(R.id.availability_text), withText("Add availability delimited by newlines\nex. Mon 14 (Monday 2pm-3pm)\n"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                14)));
        appCompatEditText7.perform(scrollTo(), replaceText("Add availability delimited by newlines\nex. Mon 14 (Monday 2pm-3pm)\n"));

        ViewInteraction appCompatEditText8 = onView(
                Matchers.allOf(withId(R.id.availability_text), withText("Add availability delimited by newlines\nex. Mon 14 (Monday 2pm-3pm)\n"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                14),
                        isDisplayed()));
        appCompatEditText8.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText9 = onView(
                Matchers.allOf(withId(R.id.availability_text), withText("Add availability delimited by newlines\nex. Mon 14 (Monday 2pm-3pm)\n"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                14)));
        appCompatEditText9.perform(scrollTo(), click());

        ViewInteraction appCompatEditText10 = onView(
                Matchers.allOf(withId(R.id.availability_text), withText("Add availability delimited by newlines\nex. Mon 14 (Monday 2pm-3pm)\n"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                14)));
        appCompatEditText10.perform(scrollTo(), longClick());

        ViewInteraction appCompatEditText11 = onView(
                Matchers.allOf(withId(R.id.availability_text), withText("Add availability delimited by newlines\nex. Mon 14 (Monday 2pm-3pm)\n"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                14)));
        appCompatEditText11.perform(scrollTo(), replaceText("Mon 13 (Monday 2pm -5pm)\n"));

        ViewInteraction appCompatEditText12 = onView(
                Matchers.allOf(withId(R.id.availability_text), withText("Mon 13 (Monday 2pm -5pm)\n"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                14),
                        isDisplayed()));
        appCompatEditText12.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText17 = onView(
                Matchers.allOf(withId(R.id.availability_text), withText("Mon 13 (Monday 2pm -5pm)"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                14),
                        isDisplayed()));
        appCompatEditText17.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText18 = onView(
                Matchers.allOf(withId(R.id.gender_text), withText("NA"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        appCompatEditText18.perform(scrollTo(), click());

        ViewInteraction appCompatButton3 = onView(
                Matchers.allOf(withId(R.id.edit_profile_button), withText("Submit"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                0)));
        appCompatButton3.perform(scrollTo(), click());
    }

    @Test
    public void receiveRequestTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatEditText = onView(
                Matchers.allOf(withId(R.id.username),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("ginatest@usc.edu"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                Matchers.allOf(withId(R.id.password),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("password"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                Matchers.allOf(withId(R.id.login), withText("Log In"),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatButton.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction bottomNavigationItemView = onView(
                Matchers.allOf(withId(R.id.navigation_notifications), withContentDescription("Requests"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0),
                                2),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());
    }

    @Test
    public void rejectRequestTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatEditText = onView(
                Matchers.allOf(withId(R.id.username),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("karalem@usc.edu"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                Matchers.allOf(withId(R.id.password),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("password"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                Matchers.allOf(withId(R.id.login), withText("Log In"),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatButton2 = onView(
                Matchers.allOf(withId(R.id.login), withText("Log In"),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatButton3 = onView(
                Matchers.allOf(withId(R.id.login), withText("Log In"),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction appCompatButton4 = onView(
                Matchers.allOf(withId(R.id.login), withText("Log In"),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction appCompatButton5 = onView(
                Matchers.allOf(withId(R.id.login), withText("Log In"),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatButton5.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                Matchers.allOf(withId(R.id.username), withText("karalem@usc.edu"),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText3.perform(click());

        ViewInteraction appCompatEditText4 = onView(
                Matchers.allOf(withId(R.id.username), withText("karalem@usc.edu"),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText4.perform(click());

        ViewInteraction appCompatEditText5 = onView(
                Matchers.allOf(withId(R.id.username), withText("karalem@usc.edu"),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText5.perform(replaceText("karaleem@usc.edu"));

        ViewInteraction appCompatEditText6 = onView(
                Matchers.allOf(withId(R.id.username), withText("karaleem@usc.edu"),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText6.perform(closeSoftKeyboard());

        ViewInteraction appCompatButton6 = onView(
                Matchers.allOf(withId(R.id.login), withText("Log In"),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatButton6.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction bottomNavigationItemView = onView(
                Matchers.allOf(withId(R.id.navigation_notifications), withContentDescription("Requests"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0),
                                2),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());

        ViewInteraction button = onView(
                Matchers.allOf(withText("Reject"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.requestsContainer),
                                        0),
                                2),
                        isDisplayed()));
        button.perform(click());
    }

    @Test
    public void sendRequestFirst() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatSpinner = onView(
                Matchers.allOf(withId(R.id.spinner),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                4),
                        isDisplayed()));
        appCompatSpinner.perform(click());

        DataInteraction appCompatCheckedTextView = onData(anything())
                .inAdapterView(childAtPosition(
                        withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
                        0))
                .atPosition(1);
        appCompatCheckedTextView.perform(click());

        ViewInteraction appCompatEditText = onView(
                Matchers.allOf(withId(R.id.username),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("tutee1@usc.edu"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                Matchers.allOf(withId(R.id.password),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("123456"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                Matchers.allOf(withId(R.id.login), withText("Log In"),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatButton.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatEditText3 = onView(
                Matchers.allOf(withId(R.id.searchText),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("CSCI310"), closeSoftKeyboard());

        ViewInteraction appCompatSpinner2 = onView(
                Matchers.allOf(withId(R.id.daySpinner),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment),
                                        0),
                                2),
                        isDisplayed()));
        appCompatSpinner2.perform(click());

        DataInteraction appCompatCheckedTextView2 = onData(anything())
                .inAdapterView(childAtPosition(
                        withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
                        0))
                .atPosition(1);
        appCompatCheckedTextView2.perform(click());

        ViewInteraction appCompatSpinner3 = onView(
                Matchers.allOf(withId(R.id.timeSpinner),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment),
                                        0),
                                3),
                        isDisplayed()));
        appCompatSpinner3.perform(click());

        DataInteraction appCompatCheckedTextView3 = onData(anything())
                .inAdapterView(childAtPosition(
                        withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
                        0))
                .atPosition(2);
        appCompatCheckedTextView3.perform(click());

        ViewInteraction appCompatButton2 = onView(
                Matchers.allOf(withId(R.id.searchButton),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment),
                                        0),
                                0),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction button = onView(
                Matchers.allOf(withText("Gina Yang"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.searchResultsContainer),
                                        0),
                                0),
                        isDisplayed()));
        button.perform(click());
    }


    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }


}
