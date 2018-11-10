package firesoft.de.mvvm_dagger.dagger;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import javax.inject.Inject;
import javax.inject.Singleton;

import firesoft.de.mvvm_dagger.models.IOModel;
import firesoft.de.mvvm_dagger.inputFragment.InputViewmodel;
import firesoft.de.mvvm_dagger.outputFragment.OutputViewmodel;

@Singleton
public class CustomViewmodelFactory implements ViewModelProvider.Factory {

    private IOModel model;

    @Inject
    public CustomViewmodelFactory(IOModel model) {
        this.model = model;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(OutputViewmodel.class)) {
            return (T) new OutputViewmodel(model);
        }
        else if (modelClass.isAssignableFrom(InputViewmodel.class)) {
            return (T) new InputViewmodel(model);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
