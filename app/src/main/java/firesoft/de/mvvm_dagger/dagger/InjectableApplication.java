package firesoft.de.mvvm_dagger.dagger;

import android.app.Application;

public class InjectableApplication extends Application {

    private InjectionComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        createComponent();
    }

    public InjectionComponent getComponent() {

        createComponent();

        return  mComponent;
    }

    private void createComponent() {

        // Falls noch keine Instanz vorhanden ist (was eigentlich der Fall sein sollte), muss diese erstellt werden
        if (mComponent == null) {

            // Component instanzieren
            mComponent = DaggerInjectionComponent.builder()
                    // Das Modul implementieren und mit den Basisabhängigkeiten versorgen (MainActivity)
                    .injectionModule(new InjectionModule(this))
                    .build();
        }

    }

}
