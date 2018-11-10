package firesoft.de.mvvm_dagger.wrapper;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import firesoft.de.mvvm_dagger.inputFragment.InputFragment;
import firesoft.de.mvvm_dagger.outputFragment.OutputFragment;

@SuppressLint("Registered")
public class ExtendedActivity extends AppCompatActivity {

    public static final String INPUT_FRAGMENT = "INPUT";
    public static final String OUTPUT_FRAGMENT = "OUTPUT";

    public FragmentManager fManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createFragmentManager();
    }

    private void createFragmentManager() {
        fManager = this.getSupportFragmentManager();
    }

    /**
     * Provides a method to switch Fragments in a single frame. In this project its abused to show the fragments.
     * @param id ID of the target view
     * @param fragment fragment to display
     * @param tag tag of the fragment defined in ExtendedActivity
     */
    public void switchFragment(int id, @Nullable Fragment fragment, String tag) {

        FragmentTransaction ft = fManager.beginTransaction();
        boolean newFragment = false;

        if (fragment == null) {
            fragment = fManager.findFragmentByTag(tag);

            if (fragment == null) {
                newFragment = true;
            }
        }
        try {
            switch (tag) {

                case INPUT_FRAGMENT:
                    if (newFragment) {
                        fragment = new InputFragment();
                    }
                    break;

                case OUTPUT_FRAGMENT:
                    if (newFragment) {
                        fragment = new OutputFragment();
                    }
                    break;

                default:
                    throw new IllegalArgumentException("Unable to parse given tag to fragment!");

            }

        } catch (NullPointerException e) {
            e.printStackTrace();
            return;
        }

        ft.replace(id, fragment, tag);
        ft.addToBackStack(tag);
        ft.commit();

    }

}
