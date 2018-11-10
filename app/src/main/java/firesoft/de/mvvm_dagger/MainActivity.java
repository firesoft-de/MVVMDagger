package firesoft.de.mvvm_dagger;

import android.os.Bundle;
import android.support.annotation.VisibleForTesting;

import javax.inject.Inject;

import firesoft.de.mvvm_dagger.dagger.CustomViewmodelFactory;
import firesoft.de.mvvm_dagger.dagger.InjectableApplication;
import firesoft.de.mvvm_dagger.wrapper.ExtendedActivity;

public class MainActivity extends ExtendedActivity {

    @Inject
    CustomViewmodelFactory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ((InjectableApplication) getApplication()).getComponent().inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initaliseFragments();

    }

    @VisibleForTesting(otherwise = MODE_PRIVATE)
    public void initaliseFragments() {

        switchFragment(R.id.InputFrame,null,ExtendedActivity.INPUT_FRAGMENT);
        switchFragment(R.id.OutputFrame,null,ExtendedActivity.OUTPUT_FRAGMENT);

    }

}
