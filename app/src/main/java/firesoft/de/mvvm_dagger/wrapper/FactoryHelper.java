package firesoft.de.mvvm_dagger.wrapper;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;

import firesoft.de.mvvm_dagger.inputFragment.InputViewmodel;
import firesoft.de.mvvm_dagger.outputFragment.OutputViewmodel;

public class FactoryHelper {

    /**
     * Provides a method to generate viewmodels
     * @param activity The activity in which scope the viewmodel should be used.
     * @param factory The factory to use
     * @param viewModel The desired viewmodel
     * @param <T>
     * @return Instance of the desired viewmodel
     */
    public static <T extends ViewModel> T generateViewmodel(AppCompatActivity activity, ViewModelProvider.Factory factory, Class<T> viewModel) throws Exception{

        T newViewmodel;

        if (viewModel.isAssignableFrom(OutputViewmodel.class)) {
            newViewmodel = (T) ViewModelProviders.of(activity, factory).get(OutputViewmodel.class);
            return newViewmodel;
        }
        else if (viewModel.isAssignableFrom(InputViewmodel.class)) {
            newViewmodel = (T) ViewModelProviders.of(activity, factory).get(InputViewmodel.class);
            return newViewmodel;
        }

        throw new Exception("Unable to parse give viewmodelclass");

    }

    /**
     * Provides a method to generate viewmodels
     * @param activity The activity in which scope the viewmodel should be used.
     * @param factory The factory to use
     * @param viewModel The desired viewmodel
     * @param <T>
     * @return Instance of the desired viewmodel
     */
    public static <T extends ViewModel> T generateViewmodel(FragmentActivity activity, ViewModelProvider.Factory factory, Class<T> viewModel) throws Exception{

        T newViewmodel;

        if (viewModel.isAssignableFrom(OutputViewmodel.class)) {
            newViewmodel = (T) ViewModelProviders.of(activity, factory).get(OutputViewmodel.class);
            return newViewmodel;
        }
        else if (viewModel.isAssignableFrom(InputViewmodel.class)) {
            newViewmodel = (T) ViewModelProviders.of(activity, factory).get(InputViewmodel.class);
            return newViewmodel;
        }

        throw new Exception("Unable to parse give viewmodelclass");

    }

}
