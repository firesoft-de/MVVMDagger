package firesoft.de.mvvm_dagger.inputFragment;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import firesoft.de.mvvm_dagger.R;
import firesoft.de.mvvm_dagger.dagger.CustomViewmodelFactory;
import firesoft.de.mvvm_dagger.dagger.InjectableApplication;
import firesoft.de.mvvm_dagger.databinding.FragmentInputBinding;
import firesoft.de.mvvm_dagger.wrapper.FactoryHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class InputFragment extends Fragment {

    @Inject
    InjectableApplication application;

    @Inject
    CustomViewmodelFactory factory;

    InputViewmodel viewmodel;

    public InputFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        receiveViewmodel();
        View view = bindViewmodel(inflater, container);

        return view;
    }

    @Override
    public void onAttach(Context context) {

        ((InjectableApplication) getActivity().getApplication())
                .getComponent()
                .inject(this);

        super.onAttach(context);
    }

    // region Methods for Initialisation

    private void receiveViewmodel() {
        try {
            viewmodel = FactoryHelper.generateViewmodel(getActivity(), factory, InputViewmodel.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private View bindViewmodel(LayoutInflater inflater, ViewGroup container) {

        FragmentInputBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_input, container,false);
        binding.setViewModel(viewmodel);
        binding.setLifecycleOwner(getActivity());

        return binding.getRoot();
    }

    // endregion

}
