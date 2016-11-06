package cz.droidboy.test;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * @author Jonáš Ševčík
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginScreenTest {

    private LoginActivity loginActivity;

    @Rule
    public final ActivityTestRule<LoginActivity> rule = new ActivityTestRule<>(LoginActivity.class);

    @Before
    public void init() {
        loginActivity = rule.getActivity();
    }

    @Test
    public void testDisplaysErrorWhenNoUsername() throws Exception {
        onView(withId(R.id.login)).perform(click());
        onView(withId(R.id.username)).check(matches(hasErrorText(loginActivity.getString(R.string.username_error))));
    }

    @Test
    public void testDisplaysErrorWhenNoPassword() throws Exception {
        onView(withId(R.id.username)).perform(replaceText("John"));
        onView(withId(R.id.login)).perform(click());
        onView(withId(R.id.password)).check(matches(hasErrorText(loginActivity.getString(R.string.password_error))));
    }
}
