package firesoft.de.mvvm_dagger;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertContains;
import static com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed;
import static com.schibsted.spain.barista.interaction.BaristaEditTextInteractions.writeTo;

public class MainActivityShould {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(
            MainActivity.class, true, false);

    private Context context = InstrumentationRegistry.getTargetContext();

    private void initalise() {
        Intent intent = new Intent(context, MainActivity.class);
        activityRule.launchActivity(intent);
        MainActivity activity = activityRule.getActivity();
        activity.initaliseFragments();
    }

    @Test
    public void showOutputFragment() throws Exception{

        initalise();
        assertDisplayed(R.id.textView);

    }

    @Test
    public void displayPlayerInput() throws Exception{

        initalise();
        writeTo(R.id.editText, "Test"); // UI-Test mit Barista
        assertContains(R.id.tvOutput,"Test");

    }

    @Test
    public void displaymodifedPlayerInput() throws Exception{

        initalise();
        writeTo(R.id.editText, "Test");
        assertContains(R.id.tvModifiedOutput,"Der Nutzer hat folgende Eingabe gemacht: Test");

    }


}