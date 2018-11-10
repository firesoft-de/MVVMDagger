package firesoft.de.mvvm_dagger.dagger;

import android.app.Application;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

@Module
public class InjectionModule {

    private final Application application;

    InjectionModule(Application application) {this.application =   application;}

    @Provides
    InjectableApplication provideApplication() {return (InjectableApplication) application;}



}
