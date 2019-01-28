// TODO: copyright

package com.mongodb.crypt.capi;

import com.mongodb.crypt.internal.CAPI;


public class MongoCryptLibraryImpl implements MongoCryptLibrary {

    public MongoCryptLibraryImpl() {
        CAPI.mongocrypt_init();
    }

    @Override
    public MongoCrypt create() {
        return new MongoCryptImpl();
    }

    @Override
    public void close() {
        CAPI.mongocrypt_cleanup();
    }
}
