package test.tools.workshop.junit;

public class Initializer {

    private boolean initalized = false;

    public void initialize() {
        initalized = true;
    }

    public boolean isInitalized() {
        return initalized;
    }

    public void doIfInitialized() {
        if (!initalized) {
            throw new IllegalStateException("Initialize me first!");
        }
    }

    public void cleanUp() {
        initalized = false;
    }
}
