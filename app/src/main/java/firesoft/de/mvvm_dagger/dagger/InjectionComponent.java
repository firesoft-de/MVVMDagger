package firesoft.de.mvvm_dagger.dagger;

import javax.inject.Singleton;

import dagger.Component;
import firesoft.de.mvvm_dagger.MainActivity;
import firesoft.de.mvvm_dagger.inputFragment.InputFragment;
import firesoft.de.mvvm_dagger.outputFragment.OutputFragment;

@Singleton
@Component(modules = InjectionModule.class)
public interface InjectionComponent {

    void inject(MainActivity mainActivity);

    void inject(InputFragment inputFragment);

    void inject(OutputFragment outputFragment);

}
