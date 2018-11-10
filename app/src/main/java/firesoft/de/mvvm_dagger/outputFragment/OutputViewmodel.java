package firesoft.de.mvvm_dagger.outputFragment;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import firesoft.de.mvvm_dagger.models.IOModel;

public class OutputViewmodel extends ViewModel {

    IOModel model;

    // region Public Variables

    public MutableLiveData<String> directUserOutput;
    public MutableLiveData<String> modifiedUserOutput;

    // endregion

    // region Constructor

    public OutputViewmodel(IOModel model) {

        this.model = model;

        initLiveData();

    }

    // endregion

    // region Methods for Initialisation

    private void initLiveData() {

        directUserOutput = model.userInput;
        modifiedUserOutput = model.modifiedInput;

    }

    // endregion


}
