// TODO: copyright

package com.mongodb.crypt.capi;

public class MongoCryptCAPI {
    // TODO: for library search path, if needed
    private static final String NATIVE_LIBRARY_NAME = "mongocrypt";

    public static MongoCryptLibrary create() {
        return new MongoCryptLibraryImpl();
    }
}
