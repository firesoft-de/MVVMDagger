package firesoft.de.mvvm_dagger.inputFragment;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import firesoft.de.mvvm_dagger.models.IOModel;

public class InputViewmodel extends ViewModel {

    IOModel model;

    public MutableLiveData<String> userInput;


    public InputViewmodel(IOModel model) {

        this.model = model;
        initLiveData();

    }

    private void initLiveData() {

        userInput = new MutableLiveData<>();

    }

    // region Public Business Methods

    public void deliverUserInput() {
        model.deliverUserInput(userInput.getValue());
    }

    // endregion

}
