package firesoft.de.mvvm_dagger;

import android.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import firesoft.de.mvvm_dagger.models.IOModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IOModelShould {

    IOModel model;

    @Before
    public void setUp() throws Exception {

        model = new IOModel();

    }

    // A JUnit Test Rule that swaps the background executor used by the Architecture Components with a different one which executes each task synchronously. (Livedata)
    // https://medium.com/pxhouse/unit-testing-with-mutablelivedata-22b3283a7819
    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    @Test
    public void initUserInput() {

        assertNotNull(model.userInput);

    }

    @Test
    public void initModifiedInput() {

        assertNotNull(model.modifiedInput);

    }

    @Test
    public void setInput() throws Exception {

        model.deliverUserInput("Test");

        assertEquals(model.userInput.getValue(), "Test");

    }

    @Test
    public void modifyInput() throws Exception {

        model.deliverUserInput("Test");

        assertEquals(model.modifiedInput.getValue(), "Der Nutzer hat folgende Eingabe gemacht: Test");

    }

    @Test
    public void handleNullInput() throws Exception{

        model.deliverUserInput(null);

        assertEquals(model.userInput.getValue(), "");

    }


}