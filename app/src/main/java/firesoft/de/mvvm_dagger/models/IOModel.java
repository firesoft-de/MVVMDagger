package firesoft.de.mvvm_dagger.models;

import android.arch.lifecycle.MutableLiveData;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class IOModel {

    // region Private Variables

    // endregion

    // region Public Variables

    // endregion

    // region Constants

    // endregion

    // region LiveData-Variables

    public MutableLiveData<String> userInput;
    public MutableLiveData<String> modifiedInput;

    // endregion


    // region Constructor

    @Inject
    public IOModel() {

        initLiveData();

    }

    // endregion

    // region Methods for Initialisation

    private void initLiveData() {

        userInput = new MutableLiveData<>();
        modifiedInput = new MutableLiveData<>();

    }

    // endregion

    // region Public Business Methods

    public void deliverUserInput(String userInput) {

        if (userInput == null) {
            userInput = "";
        }

        this.userInput.setValue(userInput);
        modifiedInput.setValue("Der Nutzer hat folgende Eingabe gemacht: " + userInput);

    }

    // endregion


}
